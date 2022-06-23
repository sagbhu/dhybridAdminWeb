package com.productmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.constant.URLConstants;
import com.productmanagement.model.Product;
import com.productmanagement.model.ProductCategory;
import com.productmanagement.request.ProductCategorySearchRequest;
import com.productmanagement.request.ProductCategorySyncRequest;
import com.productmanagement.request.ProductRequest;
import com.productmanagement.request.ProductSearchRequest;
import com.productmanagement.request.ProductSyncRequest;
import com.productmanagement.response.ProductCategoryResponse;
import com.productmanagement.response.ProductResponse;
import com.productmanagement.response.ProductSearchResponse;
import com.productmanagement.service.ProductCategoryService;
import com.productmanagement.service.ProductService;

@RestController
@RequestMapping(URLConstants.PRODUCT_SERVICE_URL)
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping("/syncProductsWithVinculum")
	public ResponseEntity<ProductResponse> syncProductsWithVinculum(@RequestBody ProductSyncRequest productRequest,
			boolean isFromScheduler) {
		logger.debug("syncProductsWithVinculum method start in ProductController");
		ProductResponse productResponse = productService.syncProductsWithVinculum(productRequest, false);
		logger.debug("syncProductsWithVinculum method end in ProductController");
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	@PostMapping("/syncProductCategoriesWithVinculum")
	public ResponseEntity<ProductCategoryResponse> syncProductCategoriesWithVinculum(
			@RequestBody ProductCategorySyncRequest productCategoryRequest) {
		logger.info("syncProductCategoriesWithVinculum method start in ProductController");
		ProductCategoryResponse productCategoryResponse = productCategoryService.syncProductsCategoriesWithVinculum(productCategoryRequest, false);
		logger.debug("syncProductCategoriesWithVinculum method end in ProductController");
		return new ResponseEntity<>(productCategoryResponse, HttpStatus.OK);
	}

	@PostMapping("/getProductCategories")
	public ResponseEntity<List<ProductCategory>> getProductCategories(
			@RequestBody ProductCategorySearchRequest productCategorySearchRequest) {
		logger.debug("getProductCategories method start in ProductController");
		List<ProductCategory> productCategory = productCategoryService.getProductCategories();
		logger.debug("getProductCategories method end in ProductController");
		return new ResponseEntity<>(productCategory, HttpStatus.OK);
	}

	@PostMapping("/getProducts")
	public ResponseEntity<ProductSearchResponse> getProducts(@RequestBody ProductSearchRequest productSearchRequest) {
		logger.debug("getProducts method start in ProductController");
		ProductSearchResponse productSearchResponse = productService.getProducts(productSearchRequest);
		logger.debug("getProducts method end in ProductController");
		return new ResponseEntity<>(productSearchResponse, HttpStatus.OK);
	}

	@PutMapping("/updateProducts")
	public ResponseEntity<Product> updateProduct(@Validated @RequestBody ProductRequest productRequest) {
		logger.debug("updateProduct method start in ProductController");
		Product product = productService.updateProducts(productRequest);
		logger.debug("updateProduct method end in ProductController");
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
}
