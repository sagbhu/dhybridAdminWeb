package com.productmanagement.serviceimpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productmanagement.constant.ProductServiceConstants;
import com.productmanagement.model.Product;
import com.productmanagement.repository.ProductRepository;
import com.productmanagement.request.ProductRequest;
import com.productmanagement.request.ProductRequestBody;
import com.productmanagement.request.ProductSearchRequest;
import com.productmanagement.request.ProductSyncRequest;
import com.productmanagement.response.ProductResponse;
import com.productmanagement.response.ProductSearchResponse;
import com.productmanagement.response.SkuList;
import com.productmanagement.service.ProductService;
import com.productmanagement.utils.APIUtils;
import com.productmanagement.utils.DateUtils;

@Service
public class ProductServiceImpl implements ProductService {
	private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	public ProductResponse syncProductsWithVinculum(ProductSyncRequest productRequest, boolean isFromScheduler) {
		logger.debug("syncProductsWithVinculum method start in ProductServiceImpl Class");
		ProductResponse productResponse = null;
		int pageNumber = 1;
		List<ProductResponse> productResponseList = new ArrayList<>();
		if (isFromScheduler) {
			while (pageNumber > 0) {
				productRequest = getProductRequest(pageNumber);
				productResponse = executePost(productRequest);
				Integer pageSize = 0;
				if (null != productResponse) {
					pageSize = Integer
							.parseInt(null != productResponse.getPageSize() ? productResponse.getPageSize() : "0");
				}
				if (pageSize == 0) {
					break;
				} else {
					productResponseList.add(productResponse);
					pageNumber++;
				}
			}
		} else {
			productResponse = executePost(productRequest);
			productResponseList.add(productResponse);
		}
		saveProducts(productResponseList);
		logger.debug("syncProductsWithVinculum method end in ProductServiceImpl Class");
		return productResponse;
	}

	private void saveProducts(List<ProductResponse> productResponseList) {
		logger.debug("saveProducts method Start in ProductServiceImpl Class");
		if (!productResponseList.isEmpty()) {
			List<SkuList> skuList = getSkuList(productResponseList);
			List<Product> productList = setProductDetails(skuList);
			saveProduct(productList);
		}
		logger.debug("saveProducts method End in ProductServiceImpl Class");
	}

	private List<SkuList> getSkuList(List<ProductResponse> productResponseList) {
		logger.debug("getSkuList method Start in ProductServiceImpl Class");
		List<SkuList> skuList = new ArrayList<>();
		for (int i = 0; i < productResponseList.size(); i++) {
			if (null != productResponseList.get(i) && null != productResponseList.get(i).getSkuList()) {
				for (int j = 0; j < productResponseList.get(i).getSkuList().size(); j++) {
					skuList.add(productResponseList.get(i).getSkuList().get(j));
				}
			}
		}
		logger.debug("getSkuList method End in ProductServiceImpl Class");
		return skuList;
	}

	private List<Product> setProductDetails(List<SkuList> skuList) {
		logger.debug("setProductDetails method Start in ProductServiceImpl Class");
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < skuList.size(); i++) {
			Product product = new Product();
			product.setSkuCode(skuList.get(i).getSkuCode());
			product.setSkuName(skuList.get(i).getSkuName());
			product.setSkuClassification(skuList.get(i).getSkuClassification());
			product.setStyle(skuList.get(i).getSkuClassificationText());
			product.setIsApproved(skuList.get(i).getApproveStatusText());
			product.setIsActive(skuList.get(i).getApproveStatus());
			product.setProductStatus(skuList.get(i).getProductStatus());
			product.setBrandName(skuList.get(i).getBrandText());
			product.setColor(skuList.get(i).getColor());
			product.setMrp(skuList.get(i).getMsrp());
			product.setSalePrice(skuList.get(i).getSalePrice());
			product.setBaseCost(skuList.get(i).getBasePrice());
			product.setPackageWidth(skuList.get(i).getWeight());
			product.setPackageHeight(skuList.get(i).getHeight());
			product.setPackageLength(skuList.get(i).getLength());
			product.setPackageWeight(skuList.get(i).getWeight());
			product.setProductCategory(skuList.get(i).getMerchIdText());
			product.setListingDate(skuList.get(i).getCreateDateText());
			product.setUpdateDate(DateUtils.dateTimeFormat());
			product.setUserId(ProductServiceConstants.PRODUCT_API_USER_ID);
			productList.add(product);
		}
		logger.debug("setProductDetails method end in ProductServiceImpl Class");
		return productList;
	}

	private void saveProduct(List<Product> productList) {
		productRepository.saveAll(productList);
	}

	private ProductSyncRequest getProductRequest(int pageNumber) {
		ProductSyncRequest productRequest = new ProductSyncRequest();
		ProductRequestBody productRequestBody = new ProductRequestBody();
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern(ProductServiceConstants.DATE_TIME_FORMAT);
		LocalDate fromDate = LocalDate.parse(getLastProductUpdatedDate(), inputFormat);
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern(ProductServiceConstants.DATE_FORMAT);
		productRequestBody.setPageSize(ProductServiceConstants.PAGE_SIZE);
		productRequestBody.setPageNumber(Integer.toString(pageNumber));
		productRequestBody.setDisplaySkuList(new ArrayList<>());
		productRequestBody.setFromDate(fromDate.format(outputFormat));
		productRequestBody.setToDate(fromDate.plusDays(1).format(outputFormat));
		productRequest.setApiKey(ProductServiceConstants.PRODUCT_API_KEY);
		productRequest.setApiOwner(ProductServiceConstants.PRODUCT_API_OWNER);
		productRequest.setProductRequestBody(productRequestBody);
		return productRequest;
	}

	@Override
	public ProductSearchResponse getProducts(ProductSearchRequest productSearchRequest) {
		logger.debug("getProducts method Start in ProductServiceImpl Class");
		if (productSearchRequest.getPageNumber() != 0 && productSearchRequest.getNumberOfRecord() != 0) {
			productSearchRequest.setPageNumber(productSearchRequest.getPageNumber() - 1);
		} else if (productSearchRequest.getPageNumber() != 0) {
			productSearchRequest.setNumberOfRecord(ProductServiceConstants.NUMBER_OF_RECORD);
		} else if (productSearchRequest.getNumberOfRecord() != 0) {
			productSearchRequest.setPageNumber(Integer.parseInt(ProductServiceConstants.PAGE_NUMBER) - 1);
		} else {
			productSearchRequest.setNumberOfRecord(ProductServiceConstants.NUMBER_OF_RECORD);
			productSearchRequest.setPageNumber(Integer.parseInt(ProductServiceConstants.PAGE_NUMBER) - 1);
		}
		Pageable paging = getPaging(productSearchRequest);
		ProductSearchResponse productSearchResponse = getProductList(productSearchRequest, paging);
		logger.debug("getProducts method end in ProductServiceImpl Class");
		return productSearchResponse;
	}

	private ProductSearchResponse getProductList(ProductSearchRequest productSearchRequest, Pageable paging) {
		logger.debug("getProductList method Start in ProductServiceImpl Class");
		Page<Product> pagedResult=null;
		if (null != productSearchRequest.getSearchParam()) {
			pagedResult = productRepository.getProductListBySearchParam(productSearchRequest.getSearchParam(), paging);
		} else if (null != productSearchRequest.getAvailability()) {
			pagedResult = productRepository.getProductListByAvailability(productSearchRequest.getAvailability(),
					paging);
		} else if (null != productSearchRequest.getColor()) {
			pagedResult = productRepository.getProductListByColor(productSearchRequest.getColor(), paging);
		} else if (null != productSearchRequest.getBrandName()) {
			pagedResult = productRepository.getProductListByBrandName(productSearchRequest.getBrandName(), paging);
		} else if ((productSearchRequest.getPriceStart() != 0) && (productSearchRequest.getPriceEnd() != 0)) {
			pagedResult = productRepository.getProductListByPriceRange(productSearchRequest.getPriceStart(),productSearchRequest.getPriceEnd(), paging);
		} else if (null != productSearchRequest.getSlugId()) {
			pagedResult= productRepository.getProductListBySlug(productSearchRequest.getSlugId(), paging);
			
		} else {
			 pagedResult = productRepository.findAll(paging);
		}
		ProductSearchResponse productSearchResponse=new ProductSearchResponse();
		productSearchResponse.setCount(pagedResult.getTotalElements());
		productSearchResponse.setProductList(pagedResult.toList());
		logger.debug("getProductList method end in ProductServiceImpl Class");
		return productSearchResponse;
	}

	private Pageable getPaging(ProductSearchRequest productSearchRequest) {
		logger.debug("getPaging method Start in ProductServiceImpl Class");
		Pageable paging = null;
		if (null != productSearchRequest.getSortColumnName() && null != productSearchRequest.getSortOrder()) {
			if (productSearchRequest.getSortOrder().equalsIgnoreCase(ProductServiceConstants.SORT_ORDER_DESC)) {
				paging = PageRequest.of(productSearchRequest.getPageNumber(), productSearchRequest.getNumberOfRecord(),
						Sort.Direction.DESC, productSearchRequest.getSortColumnName());
			} else {
				paging = PageRequest.of(productSearchRequest.getPageNumber(), productSearchRequest.getNumberOfRecord(),
						Sort.by(productSearchRequest.getSortColumnName()));
			}

		} else if (null != productSearchRequest.getSortColumnName()) {
			paging = PageRequest.of(productSearchRequest.getPageNumber(), productSearchRequest.getNumberOfRecord(),
					Sort.by(productSearchRequest.getSortColumnName()));
		} else {
			paging = PageRequest.of(productSearchRequest.getPageNumber(), productSearchRequest.getNumberOfRecord());
		}
		logger.debug("getPaging method end in ProductServiceImpl Class");
		return paging;
	}

	@Override
	public String getLastProductUpdatedDate() {
		Pageable paging = PageRequest.of(0, 1, Sort.Direction.DESC, "updateDate");
		List<Product> lastInsertedProduct = productRepository.getLastProductUpdatedDate(paging);
		if (lastInsertedProduct != null && !lastInsertedProduct.isEmpty()) {
			return lastInsertedProduct.get(0).getUpdateDate();
		} else {
			return DateUtils.dateTimeFormat();
		}
	}

	private ProductResponse executePost(ProductSyncRequest productRequest) {
		logger.debug("executePost method start in ProductServiceImpl Class");
		ProductResponse productResponse = null;
		try {
			String result = APIUtils.doPost(productRequest);
			productResponse = new ObjectMapper().readValue(result, ProductResponse.class);
		} catch (IOException e) {
			logger.debug("Error while executing executePost" + e.getMessage());
		}
		logger.debug("executePost method end in ProductServiceImpl Class");
		return productResponse;
	}

	@Override
	public Product updateProducts(ProductRequest productRequest) {
		logger.debug("updateProducts method end in ProductServiceImpl Class");
		Optional<Product> isProduct = productRepository.findById(productRequest.getProductId());
		Product product = null;
		if (isProduct.isPresent()) {
			product = isProduct.get();
			product.setSlug(productRequest.getSlug());
			product.setLabel(productRequest.getLabel());
			product.setIntro(productRequest.getIntro());
			product.setByLine(productRequest.getByLine());
			product.setDesc(productRequest.getDesc());
			product.setAboutTheBrand(productRequest.getAboutTheBrand());
			product.setServiceCode(productRequest.getServiceCode());
			product.setKeyword(productRequest.getKeyword());
			product.setMixedFile(productRequest.getMixedFile());
			product.setFile3d(productRequest.getFile3d());
			productRepository.save(product);
		}
		logger.debug("updateProducts method end in ProductServiceImpl Class");
		return product;
	}

}
