package com.dhybrid.admin.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.Content;
import com.dhybrid.admin.service.ContentService;
import com.dhybrid.admin.utils.APIUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ContentServiceImpl implements ContentService {

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<Content> getContent() {
		String productJson = APIUtils.doGet(URLConstants.FETCH_CONTENT_LIST_URL);
		List<Content> response = null;
		try {
			response = mapper.readValue(productJson, List.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

}
