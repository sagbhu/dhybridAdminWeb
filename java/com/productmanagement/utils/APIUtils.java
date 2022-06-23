package com.productmanagement.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productmanagement.constant.URLConstants;
import com.productmanagement.request.ProductCategorySyncRequest;
import com.productmanagement.request.ProductSyncRequest;

public final class APIUtils {
	private static final Logger logger = LoggerFactory.getLogger(APIUtils.class);

	private APIUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String doPost(ProductSyncRequest productRequest) throws IOException {
		logger.debug("doPost method start in APIUtils class");
		String productsJson = "";
		String productRequestJson = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			productRequestJson = mapper.writeValueAsString(productRequest.getProductRequestBody());
		} catch (JsonProcessingException e) {
			logger.debug("Error while converting productRequest object to json :" + e.getMessage());
		}
		HttpPost post = new HttpPost(URLConstants.FETCH_PRODUCT_URL);
		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("ApiOwner", productRequest.getApiOwner()));
		urlParameters.add(new BasicNameValuePair("ApiKey", productRequest.getApiKey()));
		urlParameters.add(new BasicNameValuePair("RequestBody", productRequestJson));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doPost(ProductCategorySyncRequest productCategoryRequest) throws IOException {
		logger.debug("Category doPost method start in APIUtils class");
		String categoriesJson = "";
		String requestBody = "";
		try {
			requestBody = new ObjectMapper().writeValueAsString(productCategoryRequest.getCategoryRequestBody());
		} catch (IOException e) {
			logger.debug("Error when Convert CategoryRequestBody to json string in APIUtils class:" + e.getMessage());
		}
		HttpPost post = new HttpPost(URLConstants.FETCH_PRODUCT_CATEGORY_URL);
		post.addHeader("ApiOwner", productCategoryRequest.getApiOwner());
		post.addHeader("ApiKey", productCategoryRequest.getApiKey());
		post.addHeader("content-type", "application/json");
		post.setEntity(new StringEntity(requestBody));
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			categoriesJson = EntityUtils.toString(response.getEntity());
		}
		logger.debug("Category doPost method end in APIUtils class");
		return categoriesJson;
	}
}
