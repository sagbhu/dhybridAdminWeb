package com.dhybrid.admin.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.ProductRequest;
import com.dhybrid.admin.request.ProductSearchRequest;
import com.dhybrid.admin.request.ProductSlugRequest;
import com.dhybrid.admin.request.UploadFileRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class APIUtils {
	private static final Logger logger = LoggerFactory.getLogger(APIUtils.class);

	public static String doPost(ProductSearchRequest productSearchRequest) {
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = new HttpPost(URLConstants.FETCH_PRODUCT_URL);
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(productSearchRequest)));
		} catch (JsonProcessingException e1) {
			logger.debug("error when converting object to json" + e1.getMessage());
		} catch (UnsupportedEncodingException e1) {

			logger.debug("error when converting object to json" + e1.getMessage());
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doPost(HttpEntity entity, String url) {
		String responseJson = "";
		HttpPost post = new HttpPost(url);
		post.addHeader("content-type", "application/json");
		post.setEntity(entity);

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			responseJson = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return responseJson;
	}
	
	

	public static String doPost(ProductSlugRequest productSlugRequest) {
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = null;
		if (productSlugRequest.getId() == null) {
			post = new HttpPost(URLConstants.CREATE_PRODUCT_SLUG);
		} else {
			post = new HttpPost(URLConstants.UPDATE_PRODUCTSLUG_URL);
		}
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(productSlugRequest)));
		} catch (JsonProcessingException e1) {
			logger.debug("error when converting object to json" + e1.getMessage());
		} catch (UnsupportedEncodingException e1) {

			logger.debug("error when converting object to json" + e1.getMessage());
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doPut(ProductSlugRequest productSlugRequest) {
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPut post = new HttpPut(URLConstants.UPDATE_PRODUCTSLUG_URL);

		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(productSlugRequest)));
		} catch (JsonProcessingException e1) {
			logger.debug("error when converting object to json" + e1.getMessage());
		} catch (UnsupportedEncodingException e1) {

			logger.debug("error when converting object to json" + e1.getMessage());
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doPut(HttpEntity entity, String url) {
		String productsJson = "";
		HttpPut put = new HttpPut(url);
		put.addHeader("content-type", "application/json");
		put.setEntity(entity);

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(put)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doGet() {
		String productsJson = "";
		HttpGet request = new HttpGet(URLConstants.FETCH_PRODUCTSLUG_URL);
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}
	
	
	public static String doGet(String url) {
		String productsJson = "";
		HttpGet request = new HttpGet(url);
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doPost(ProductRequest productRequest) {
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = new HttpPost(URLConstants.UPDATE_PRODUCTS_URL);
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(productRequest)));
		} catch (JsonProcessingException e1) {
			logger.debug("error when converting object to json" + e1.getMessage());
		} catch (UnsupportedEncodingException e1) {

			logger.debug("error when converting object to json" + e1.getMessage());
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}

	public static String doDelete(String slugId) {
		String slugJson = "";
		HttpDelete delete = new HttpDelete(URLConstants.DELETE_PRODUCTSLUG_URL + "/" + slugId);
		delete.addHeader("content-type", "application/json");
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(delete)) {
			slugJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when doDelete" + e.getMessage());
		}
		logger.debug("doDelete method end in APIUtils class");
		return slugJson;
	}
	
	public static String doDelete(String id,String url) {
		String responseJson = "";
		HttpDelete delete = new HttpDelete(url+ "/" + id);
		delete.addHeader("content-type", "application/json");
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(delete)) {
			responseJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when doDelete" + e.getMessage());
		}
		logger.debug("doDelete method end in APIUtils class");
		return responseJson;
	}
	
	public static String doPut(UploadFileRequest uploadFileRequest) {
		String uploadFileJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPut put = new HttpPut(URLConstants.UPDATE_UPLOAD_BLOG_IMAGES_URL);
		put.addHeader("content-type", "application/json");
		try {
			put.setEntity(new StringEntity(mapper.writeValueAsString(uploadFileRequest)));
		} catch (JsonProcessingException e1) {
			logger.debug("error when converting object to json" + e1.getMessage());
		} catch (UnsupportedEncodingException e1) {

			logger.debug("error when converting object to json" + e1.getMessage());
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(put)) {
			uploadFileJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return uploadFileJson;
	}

}
