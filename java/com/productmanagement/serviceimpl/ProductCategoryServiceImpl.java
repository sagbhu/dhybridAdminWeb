package com.productmanagement.serviceimpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productmanagement.constant.ProductServiceConstants;
import com.productmanagement.model.ProductCategory;
import com.productmanagement.repository.ProductCategoryRepository;
import com.productmanagement.request.ProductCategorySyncRequest;
import com.productmanagement.request.ProductCategorySyncRequestBody;
import com.productmanagement.response.ProductCategoryResponse;
import com.productmanagement.response.SkuCategoryList;
import com.productmanagement.service.ProductCategoryService;
import com.productmanagement.utils.APIUtils;
import com.productmanagement.utils.DateUtils;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	private static final Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

	@Autowired
	ProductCategoryRepository productCategoryRepositry;

	@Override
	public ProductCategoryResponse syncProductsCategoriesWithVinculum(ProductCategorySyncRequest productCategorySyncRequest, boolean isFromScheduler) {
		logger.debug("syncProductsCategoriesWithVinculum Method Start in ProductCategoryServiceImpl class");
		ProductCategoryResponse productCategoryResponse = null;
		int pageNumber = 1;
		List<ProductCategoryResponse> productCategoryResponseList = new ArrayList<>();
		if (isFromScheduler) {
			while (pageNumber > 0) {
				productCategorySyncRequest = getProductCategoryRequest(pageNumber);
				productCategoryResponse = executePost(productCategorySyncRequest);
				if (null != productCategoryResponse) {
					if(null==productCategoryResponse.getSkuCategoryList()) {
						break;
					}
				}
				else {
					productCategoryResponseList.add(productCategoryResponse);
					pageNumber++;
				}
			}
		} else {
			productCategoryResponse = executePost(productCategorySyncRequest);
			productCategoryResponseList.add(productCategoryResponse);
		}
		saveProductCategories(productCategoryResponseList);
		logger.debug("syncProductsCategoriesWithVinculum Method end in ProductCategoryServiceImpl class");
		return productCategoryResponse;
	}

	private ProductCategoryResponse executePost(ProductCategorySyncRequest productCategoryRequest) {
		String result = "";
		ProductCategoryResponse productCategoriesResponse = null;
		try {
			result = APIUtils.doPost(productCategoryRequest);
			productCategoriesResponse = new ObjectMapper().readValue(result, ProductCategoryResponse.class);
		} catch (IOException e) {
			logger.info("Error when execute dopost method in ProductCategoryServiceImpl class: " + e.getMessage());
		}
		return productCategoriesResponse;
	}

	private List<ProductCategory> setProductCategoryDetails(List<SkuCategoryList> skuCategoryList) {
		logger.debug("setProductCategoryDetails Method Start in ProductCategoryServiceImpl class");
		List<ProductCategory> productCategoryList = new ArrayList<>();
		for (int i = 0; i < skuCategoryList.size(); i++) {
			ProductCategory productCategory = new ProductCategory();
			productCategory.setMerchId(skuCategoryList.get(i).getMerchId());
			productCategory.setMerchLevel(skuCategoryList.get(i).getMerchLevel());
			productCategory.setExtMerchCode(skuCategoryList.get(i).getExtMerchCode());
			productCategory.setMerchName(skuCategoryList.get(i).getMerchName());
			productCategory.setMerchDesc(skuCategoryList.get(i).getMerchDesc());
			productCategory.setParentMerchCode(skuCategoryList.get(i).getParentMerchCode());
			productCategory.setIsActive(skuCategoryList.get(i).getIsActive());
			productCategory.setUdf1(skuCategoryList.get(i).getUdf1());
			productCategory.setUdf2(skuCategoryList.get(i).getUdf2());
			productCategory.setUdf3(skuCategoryList.get(i).getUdf3());
			productCategory.setUdf4(skuCategoryList.get(i).getUdf4());
			productCategory.setUdf5(skuCategoryList.get(i).getUdf5());
			productCategory.setUpdateDate(DateUtils.dateTimeFormat());
			productCategory.setUserId(ProductServiceConstants.PRODUCT_CATEGORY_API_USER_ID);
			productCategoryList.add(productCategory);
		}
		logger.debug("setProductCategoryDetails Method Start in ProductCategoryServiceImpl class");
		return productCategoryList;
	}

	private void saveProductCategories(List<ProductCategoryResponse> productCategoryResponseList) {
		logger.debug("saveProductCategories Method Start in ProductCategoryServiceImpl class");
		if (!productCategoryResponseList.isEmpty()) {
			List<SkuCategoryList> skuCategoryList = getSkuCategoryList(productCategoryResponseList);
			List<ProductCategory> productCategoryList = setProductCategoryDetails(skuCategoryList);
			saveProductCategory(productCategoryList);
		}
		logger.debug("saveProductCategories Method end in ProductCategoryServiceImpl class");
	}

	private List<SkuCategoryList> getSkuCategoryList(List<ProductCategoryResponse> productCategoryResponseList) {
		logger.debug("getSkuCategoryList method Start in ProductServiceImpl Class");
		List<SkuCategoryList> skuCategoryList = new ArrayList<>();
		for (int i = 0; i < productCategoryResponseList.size(); i++) {
			if (null != productCategoryResponseList.get(i)
					&& null != productCategoryResponseList.get(i).getSkuCategoryList()) {
				for (int j = 0; j < productCategoryResponseList.get(i).getSkuCategoryList().size(); j++) {
					skuCategoryList.add(productCategoryResponseList.get(i).getSkuCategoryList().get(j));
				}
			}
		}
		logger.debug("getSkuCategoryList method End in ProductServiceImpl Class");
		return skuCategoryList;
	}

	private void saveProductCategory(List<ProductCategory> productCategoryList) {
		productCategoryRepositry.saveAll(productCategoryList);
	}

	@Override
	public List<ProductCategory> getProductCategories() {
		return productCategoryRepositry.findAll();
	}

	@Override
	public String getLastProductCategoryUpdatedDate() {
		  Pageable paging = PageRequest.of(0, 1,Sort.Direction.DESC,"updateDate");
			List<ProductCategory> lastInsertedProduct=productCategoryRepositry.getLastProductCategoryUpdatedDate(paging);
			if (lastInsertedProduct != null && !lastInsertedProduct.isEmpty() ) {
				return lastInsertedProduct.get(0).getUpdateDate();
			} else {
				return DateUtils.dateTimeFormat();
			}
	}

	private ProductCategorySyncRequest getProductCategoryRequest(int pageNumber) {
		logger.debug("getProductCategoryRequest Method Start in ProductCategoryServiceImpl class");
		ProductCategorySyncRequest productcategorySyncRequest = new ProductCategorySyncRequest();
		ProductCategorySyncRequestBody categoryRequestBody = new ProductCategorySyncRequestBody();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ProductServiceConstants.DATE_TIME_FORMAT);
		LocalDateTime toDate = LocalDateTime.parse(getLastProductCategoryUpdatedDate(), formatter);
		categoryRequestBody.setMerchId(new ArrayList<>());
		categoryRequestBody.setExtMerchCode("");
		categoryRequestBody.setMerchName(new ArrayList<>());
		categoryRequestBody.setParentMerchCode("");
		categoryRequestBody.setFromDate(getLastProductCategoryUpdatedDate());
		categoryRequestBody.setToDate(formatter.format(toDate.plusDays(1)));
		categoryRequestBody.setPageNumber(Integer.toString(pageNumber));
		categoryRequestBody.setFilterBy("");
		productcategorySyncRequest.setApiKey(ProductServiceConstants.PRODUCT_CATEGORY_API_KEY);
		productcategorySyncRequest.setApiOwner(ProductServiceConstants.PRODUCT_CATEGORY_API_OWNER);
		productcategorySyncRequest.setCategoryRequestBody(categoryRequestBody);
		logger.debug("getProductCategoryRequest Method end in ProductCategoryServiceImpl class");
		return productcategorySyncRequest;
	}

}
