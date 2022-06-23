package com.dhybrid.admin.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.BlogRequest;
import com.dhybrid.admin.request.UploadFileRequest;
import com.dhybrid.admin.service.BlogService;
import com.dhybrid.admin.utils.APIUtils;
import com.dhybrid.admin.utils.AWSUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BlogServiceImpl implements BlogService {
	
	
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public Map<String, Object> addUpdate(BlogRequest blogRequest) {
		Map<String, Object> response = null;
		String blogJson = null;
		String endPoint = null;
		try {
			if (blogRequest.getId() != null) {
				endPoint = URLConstants.UPDATE_BLOG_LIST_URL;
				blogJson = APIUtils.doPut(new StringEntity(mapper.writeValueAsString(blogRequest)), endPoint);
			} else {
				endPoint = URLConstants.CREATE_BLOG_LIST_URL;
				blogJson = APIUtils.doPost(new StringEntity(mapper.writeValueAsString(blogRequest)), endPoint);
			}
			response = mapper.readValue(blogJson, Map.class);
		} catch (JsonProcessingException | UnsupportedEncodingException e) {
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
					.doGet(URLConstants.FETCH_BLOG_LIST_URL + "?search=" + search + "&page=" + page + "&size=" + size);
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;

	}

	@Override
	public Map<String, Object> delete(String id) {
		String productJson = APIUtils.doDelete(id, URLConstants.DELETE_BLOG_URL);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", true);
		response.put("code", org.apache.http.HttpStatus.SC_OK);
		response.put("message", productJson);
		return response;
	}

	@Override
	public Map<String, Object> getById(String id) {
		Map<String, Object> response = null;

		String productJson = APIUtils.doGet(URLConstants.FETCH_SINGLE_BLOG_URL + "/" + id);
		try {
			response = mapper.readValue(productJson, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public String getBlogCategories() {
		String categoriesJson = APIUtils.doGet(URLConstants.FETCH_BLOG_CATEGORY_LIST_URL);
		return categoriesJson;
	}

	@Override
	public String uploadFiles(List<MultipartFile> blogFiles, String id) {
		List<String> images = new ArrayList<>();
		for (int i = 0; i < blogFiles.size(); i++) {
			String img = AWSUtil.uploadFileToAWSS3Bucket(AWSUtil.blogsFileBucketName, blogFiles.get(i));
			images.add(img);
		}
		UploadFileRequest uploadFileRequest = new UploadFileRequest();
		uploadFileRequest.setBlogId(id);
		uploadFileRequest.setImages(images);
		String response=APIUtils.doPut(uploadFileRequest);
		return response;
	}

}
