package com.dhybrid.admin.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.ProductSlugRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APISlug {

	private static final Logger logger = LoggerFactory.getLogger(APIUtils.class);
	public static String doPost(ProductSlugRequest productSlugRequest ){
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = new HttpPost(URLConstants.UPDATE_PRODUCTSLUG_URL);
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(productSlugRequest)));
		} catch (JsonProcessingException e1) {
		logger.debug("error when converting object to json"+e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			
			logger.debug("error when converting object to json"+e1.getMessage());
		}
		
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json"+e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}
	public static String doGet(ProductSlugRequest productSlugRequest ){
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = new HttpPost(URLConstants.UPDATE_PRODUCTSLUG_URL);
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(productSlugRequest)));
		} catch (JsonProcessingException e1) {
		logger.debug("error when converting object to json"+e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			
			logger.debug("error when converting object to json"+e1.getMessage());
		}
		
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json"+e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}
	
	public static String doPost(String id){
		String productsJson = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = new HttpPost(URLConstants.DELETE_PRODUCTSLUG_URL);
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(id)));
		} catch (JsonProcessingException e1) {
		logger.debug("error when converting object to json"+e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			
			logger.debug("error when converting object to json"+e1.getMessage());
		}
		
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			productsJson = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.debug("error when converting object to json"+e.getMessage());
		}
		logger.debug("doPost method end in APIUtils class");
		return productsJson;
	}
	
}
