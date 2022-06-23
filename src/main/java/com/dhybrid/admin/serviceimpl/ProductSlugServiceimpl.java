package com.dhybrid.admin.serviceimpl;

import org.springframework.stereotype.Service;

import com.dhybrid.admin.request.ProductSlugRequest;
import com.dhybrid.admin.service.ProductSlugService;
import com.dhybrid.admin.utils.APIUtils;

@Service
public class ProductSlugServiceimpl implements ProductSlugService {

	@Override
	public String createProductSlug(String slugName, String slugState) {
		ProductSlugRequest productSlugRequest = new ProductSlugRequest();
		productSlugRequest.setSlugName(slugName);
		productSlugRequest.setState(slugState);
		String productJson = APIUtils.doPost(productSlugRequest);
		return productJson;
	}

	@Override
	public String getProductsSlug() {
		String productSlugJson = APIUtils.doGet();
		return productSlugJson;
	}

	@Override
	public String updateProductSlug(ProductSlugRequest productSlugRequest) {
		String slugJson = APIUtils.doPut(productSlugRequest);
		return slugJson;
	}

	@Override
	public String deleteProductSlug(String slugId) {
		ProductSlugRequest productSlugRequest = new ProductSlugRequest();
		productSlugRequest.setId(slugId);
		String slugJson = APIUtils.doDelete(slugId);
		return slugJson;
	}
}
