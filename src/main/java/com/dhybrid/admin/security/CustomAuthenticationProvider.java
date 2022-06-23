package com.dhybrid.admin.security;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.AuthenticationRequestDto;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto(username, password);

		if (isUserAuthenticated(authenticationRequestDto)) {
			return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
		} else {
			return null;
		}
	}

	private boolean isUserAuthenticated(AuthenticationRequestDto authenticationRequestDto) {
		try {
			String token = generateToken(authenticationRequestDto);
			if (token != null && token != "") {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	String generateToken(AuthenticationRequestDto authenticationRequestDto) throws Exception {
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"username\":\"" + authenticationRequestDto.getUsername() + "\"" + ",");
		json.append("\"password\":\"" + authenticationRequestDto.getPassword() + "\"");
		json.append("}");
		String result = "";
		HttpPost post = new HttpPost(URLConstants.USER_AUTHENTICATE_URL);
		post.addHeader("content-type", "application/json");
		post.setEntity(new StringEntity(json.toString()));
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				result = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
