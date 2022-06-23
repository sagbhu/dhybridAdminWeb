package com.dhybrid.admin.service;

import javax.servlet.http.HttpServletRequest;

public interface ProductLabelService {
	String create(HttpServletRequest request);

	String get();

	String update(HttpServletRequest request);
	
	String delete(String slugId);
}
