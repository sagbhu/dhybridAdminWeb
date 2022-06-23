package com.dhybrid.admin.serviceimpl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;

import com.dhybrid.admin.constant.URLConstants;
import com.dhybrid.admin.request.ProductLabelRequest;
import com.dhybrid.admin.service.ProductLabelService;
import com.dhybrid.admin.utils.APIUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductLabelServiceimpl implements ProductLabelService {

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public String create(HttpServletRequest request) {
		String productJson = null;
		try {
			ProductLabelRequest productLabelRequest = new ProductLabelRequest();
			productLabelRequest.setLabelName(request.getParameter("labelName"));
			productLabelRequest.setState(request.getParameter("labelstate"));
			productJson = APIUtils.doPost(new StringEntity(mapper.writeValueAsString(productLabelRequest)),
					URLConstants.CREATE_PRODUCT_LABEL);
		} catch (JsonProcessingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return productJson;
	}

	@Override
	public String get() {
		return APIUtils.doGet(URLConstants.FETCH_PRODUCT_LABEL);
	}

	@Override
	public String update(HttpServletRequest request) {
		String slugJson = null;
		try {
			
			ProductLabelRequest productLabelRequest = new ProductLabelRequest();
			productLabelRequest.setId(request.getParameter("Id"));
			productLabelRequest.setLabelName(request.getParameter("labelName"));
			productLabelRequest.setState(request.getParameter("state"));
			slugJson = APIUtils.doPut(new StringEntity(mapper.writeValueAsString(productLabelRequest)),
					URLConstants.UPDATE_PRODUCT_LABEL);
		} catch (JsonProcessingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slugJson;
	}

	@Override
	public String delete(String id) {
		String slugJson = APIUtils.doDelete(id,URLConstants.DELETE_PRODUCT_LABEL);
		return slugJson;
	}
}
