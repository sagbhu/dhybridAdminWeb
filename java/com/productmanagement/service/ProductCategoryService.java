package com.productmanagement.service;

import java.util.List;

import com.productmanagement.model.ProductCategory;
import com.productmanagement.request.ProductCategorySyncRequest;
import com.productmanagement.response.ProductCategoryResponse;

public interface ProductCategoryService {

	ProductCategoryResponse syncProductsCategoriesWithVinculum(ProductCategorySyncRequest categoryRequest,boolean isFromScheduler);

	List<ProductCategory> getProductCategories();

	String getLastProductCategoryUpdatedDate();

}
