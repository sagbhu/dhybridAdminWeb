package com.productmanagement.service;

import java.util.List;

import com.productmanagement.model.ProductSlug;

public interface ProductSlugService {

	// Save operation
	ProductSlug createProductSlug(ProductSlug productSlug);

	// Read operation
	List<ProductSlug> getAllProductSlugs();

	ProductSlug getProductSlugById(String id);

	// Update operation
	ProductSlug updateProductSlug(ProductSlug productSlug);

	// Delete operation
	void deleteProductSlugById(String id);
}
