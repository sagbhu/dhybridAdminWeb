package com.dhybrid.admin.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.RoleRequest;
import com.dhybrid.admin.service.RoleService;
import com.dhybrid.admin.utils.APIUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RoleServiceImpl implements RoleService {
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public Map<String, Object> createUpdate(RoleRequest roleRequest) {
		Map<String, Object> response = null;
		String productJson = null;
		String endPoint = null;
		try {
			if (roleRequest.getRoleId() != null) {
				endPoint = URLConstants.UPDATE_ROLE_URL;
				productJson = APIUtils.doPut(new StringEntity(mapper.writeValueAsString(roleRequest)), endPoint);
			} else {
				endPoint = URLConstants.CREATE_ROLE_URL;
				productJson = APIUtils.doPost(new StringEntity(mapper.writeValueAsString(roleRequest)), endPoint);

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

		String productJson = APIUtils.doGet(URLConstants.FETCH_SINGLE_ROLE_URL + "/" + id);
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
			search = search.isEmpty()?"":search.replaceAll(" ", "%20");
			String productJson = APIUtils
					.doGet(URLConstants.FETCH_ROLES_URL + "?search=" + search + "&page=" + page + "&size=" + size);
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Map<String, Object> delete(String id) {
		Map<String, Object> response = null;

		String productJson = APIUtils.doDelete(id,URLConstants.DELETE_ROLE_URL );
		try {
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

}
