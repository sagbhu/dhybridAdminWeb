package com.dhybrid.admin.service;

import java.util.Map;

import com.dhybrid.admin.request.UserRequest;
import com.usermanagement.reponse.ApplicationResponse;

public interface UserService {

	ApplicationResponse login(String username, String password);

	Map<String, Object> createUpdate(UserRequest userRequest);

	Map<String, Object> get(String id);

	Map<String, Object> getAll(String name, int page, int size);

	Map<String, Object> delete(String id);

}
