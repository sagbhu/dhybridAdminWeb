package com.dhybrid.admin.serviceimpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.LoginRequest;
import com.dhybrid.admin.request.UserRequest;
import com.dhybrid.admin.service.UserService;
import com.dhybrid.admin.utils.APIUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.reponse.ApplicationResponse;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public ApplicationResponse login(String username, String password) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername(username);
		loginRequest.setPassword(password);
		return doLogin(loginRequest);

	}

	private ApplicationResponse doLogin(LoginRequest loginRequest) {
		ObjectMapper mapper = new ObjectMapper();
		HttpPost post = new HttpPost(URLConstants.LOGIN);
		post.addHeader("content-type", "application/json");
		try {
			post.setEntity(new StringEntity(mapper.writeValueAsString(loginRequest)));
		} catch (JsonProcessingException | UnsupportedEncodingException e1) {
			logger.debug("error when converting object to json" + e1.getMessage());
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			return mapper.readValue(EntityUtils.toString(response.getEntity()), ApplicationResponse.class);
		} catch (IOException e) {
			logger.debug("error when converting object to json" + e.getMessage());
		}
		return null;
	}

	@Override
	public Map<String, Object> createUpdate(UserRequest userRequest) {
		Map<String, Object> response = null;
		String productJson = null;
		String endPoint = null;
		try {
			if (userRequest.getUserId() != null) {
				endPoint = URLConstants.UPDATE_USER_URL;
				productJson = APIUtils.doPut(new StringEntity(mapper.writeValueAsString(userRequest)), endPoint);
			} else {
				endPoint = URLConstants.CREATE_USER_URL;
				productJson = APIUtils.doPost(new StringEntity(mapper.writeValueAsString(userRequest)), endPoint);
			}
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Map<String, Object> get(String id) {
		Map<String, Object> response = null;

		String productJson = APIUtils.doGet(URLConstants.FETCH_SINGLE_USER_URL + "/" + id);
		try {
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Map<String, Object> getAll(String search, int page, int size) {
		Map<String, Object> response = null;
		try {
			search = search.replaceAll(" ", "%20");
			String productJson = APIUtils
					.doGet(URLConstants.FETCH_USERS_URL + "?search=" + search + "&page=" + page + "&size=" + size);
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Map<String, Object> delete(String id) {
		String productJson = APIUtils.doDelete(id, URLConstants.DELETE_USER_URL);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", true);
		response.put("code", HttpStatus.OK);
		response.put("message", productJson);
		return response;
	}

}
