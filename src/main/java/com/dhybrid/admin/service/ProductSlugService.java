package com.dhybrid.admin.service;

import com.dhybrid.admin.request.ProductSlugRequest;

public interface ProductSlugService {
	String createProductSlug(String slugName, String slugState);

	String getProductsSlug();

	String updateProductSlug(ProductSlugRequest productSlugRequest);
	
	String deleteProductSlug(String slugId);
}
