package com.productmanagement.service;

import com.productmanagement.model.Product;
import com.productmanagement.request.ProductRequest;
import com.productmanagement.request.ProductSearchRequest;
import com.productmanagement.request.ProductSyncRequest;
import com.productmanagement.response.ProductResponse;
import com.productmanagement.response.ProductSearchResponse;

public interface ProductService {

	ProductResponse syncProductsWithVinculum(ProductSyncRequest productRequest,boolean isFromScheduler);

	ProductSearchResponse getProducts(ProductSearchRequest productSearchRequest);

	String getLastProductUpdatedDate();

	Product updateProducts(ProductRequest productRequest);

}
