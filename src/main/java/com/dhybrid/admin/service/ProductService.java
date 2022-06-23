package com.dhybrid.admin.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ProductService {

	String getProducts(String pageNumber);

	Map<String, Object> updateProducts(HttpServletRequest request);

	Map<String, Object> getProducts(String name, int page, int size);

}
