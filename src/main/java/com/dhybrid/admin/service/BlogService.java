package com.dhybrid.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dhybrid.admin.request.BlogRequest;

public interface BlogService {

	Map<String, Object> addUpdate(BlogRequest blogRequest);

	Map<String, Object> delete(String id);

	Map<String, Object> getAll(String searchParam,int page, int size);

	Map<String, Object> getById(String id);
	
	String getBlogCategories();

	String uploadFiles(List<MultipartFile> blogFiles, String id);

}
