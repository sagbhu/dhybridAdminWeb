package com.dhybrid.admin.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;
import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.ProductLabelRequest;
import com.dhybrid.admin.request.ProductRequest;
import com.dhybrid.admin.request.ProductSearchRequest;
import com.dhybrid.admin.request.ProductSlugRequest;
import com.dhybrid.admin.service.ProductService;
import com.dhybrid.admin.utils.APIUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductServiceimpl implements ProductService {

	ObjectMapper mapper = new ObjectMapper();

	public String getProducts(String pageNumber) {
		ProductSearchRequest productSearchRequest = new ProductSearchRequest();
		productSearchRequest.setPageNumber(Integer.parseInt(pageNumber));
		String productJson = APIUtils.doPost(productSearchRequest);
		return productJson;
	}

	@Override
	public Map<String, Object> updateProducts(HttpServletRequest request) {
		ProductRequest productRequest = new ProductRequest();
		String slugName = request.getParameter("slugName");
		String productIds = request.getParameter("productIdList");
		String selectedLabel = request.getParameter("label");
		String updateProductInto = request.getParameter("updateProductInto");

		String updateProductByLine = request.getParameter("updateProductByLine");
		String updateProductAboutTheBrand = request.getParameter("updateProductAboutTheBrand");
		String updateProductServiceCode = request.getParameter("updateProductServiceCode");
		String updateProductKeyword = request.getParameter("updateProductKeyword");
		String updateProductMixedFile = request.getParameter("updateProductMixedFile");
		String updateProductFile3d = request.getParameter("updateProductFile3d");
		String imageTransition = request.getParameter("imageTransition");
		String videoTransition = request.getParameter("videoTransition");

		String[] slugList = null;
		String[] pIdList = null;

		if (productIds != null) {

			slugName = slugName.replace("'", "");
			if (slugName != null && !slugName.isEmpty()) {
				if (slugName.endsWith(",")) {
					slugName = slugName.substring(0, slugName.length() - 1);
				}
				slugList = slugName.split(",");
				List<ProductSlugRequest> slug = new ArrayList<ProductSlugRequest>();
				if (slugList.length > 0) {
					for (int i = 0; i < slugList.length; i++) {
						ProductSlugRequest pr = new ProductSlugRequest();
						pr.setSlugName(slugList[i]);
						slug.add(pr);
					}
					productRequest.setSlug(slug);
				}
			}

			selectedLabel = selectedLabel.replace("'", "");
			if (selectedLabel != null && !selectedLabel.isEmpty()) {

				if (selectedLabel.endsWith(",")) {
					selectedLabel = selectedLabel.substring(0, selectedLabel.length() - 1);
				}
				ProductLabelRequest productLabelRequest = new ProductLabelRequest();
				productLabelRequest.setLabelName(selectedLabel);
				productRequest.setLabel(productLabelRequest);
			}

			List<String> productIdsList = null;
			productIds = productIds.replace("'", "");
			if (selectedLabel.contains(",")) {
				pIdList = productIds.split(",");
				productIdsList = Arrays.asList(pIdList);
			} else {
				productIdsList = new ArrayList<String>();
				productIdsList.add(productIds);
			}
			productRequest.setProductId(productIdsList);

			List<String> keyWords = new ArrayList<>();
			productRequest.setAboutTheBrand(updateProductAboutTheBrand);
			productRequest.setByLine(updateProductByLine);
			productRequest.setDesc(videoTransition);
			productRequest.setFile3d(updateProductFile3d);
			productRequest.setIntro(updateProductInto);
			productRequest.setKeyword(keyWords);
			productRequest.setMixedFile(null);
			productRequest.setServiceCode(updateProductServiceCode);
			productRequest.setSkuCode(videoTransition);
			productRequest.setImageTransition(imageTransition);
			productRequest.setVideoTransition(videoTransition);
			String productJson = null;
			Map<String, Object> response = null;
			try {
				productJson = APIUtils.doPut(new StringEntity(mapper.writeValueAsString(productRequest)),
						URLConstants.UPDATE_PRODUCTS_URL);
				response = mapper.readValue(productJson, Map.class);
			} catch (JsonProcessingException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return response;
		}
		return null;
	}

	@Override
	public Map<String, Object> getProducts(String name, int page, int size) {

		String productJson = APIUtils
				.doGet(URLConstants.FETCH_PRODUCT_LIST_URL + "?name=" + name + "&page=" + page + "&size=" + size);
		Map<String, Object> response = null;
		try {
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
}
