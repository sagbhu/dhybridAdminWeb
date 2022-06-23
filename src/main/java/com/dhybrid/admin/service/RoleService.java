package com.dhybrid.admin.service;

import java.util.Map;

import com.dhybrid.admin.request.RoleRequest;

public interface RoleService {

	Map<String, Object> createUpdate(RoleRequest request);

	Map<String, Object> get(String id);

	Map<String, Object> getAll(String name, int page, int size);

	Map<String, Object> delete(String id);

}
