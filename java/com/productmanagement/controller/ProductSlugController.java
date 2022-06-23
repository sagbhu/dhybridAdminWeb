package com.productmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.constant.URLConstants;
import com.productmanagement.model.ProductSlug;
import com.productmanagement.service.ProductSlugService;

@RestController
@RequestMapping(URLConstants.PRODUCT_SERVICE_URL)
public class ProductSlugController {

	private static final Logger logger = LoggerFactory.getLogger(ProductSlugController.class);

	@Autowired
	private ProductSlugService productSlugService;

	
	@PostMapping("/createProductSlug")
	public ResponseEntity<ProductSlug> createProductSlug(@RequestBody ProductSlug productSlug) {
		logger.debug("createProductSlug method start in ProductSlugController");
		ProductSlug newProductSlug = productSlugService.createProductSlug(productSlug);
		logger.debug("createProductSlug method start in ProductSlugController");
		return new ResponseEntity<>(newProductSlug, HttpStatus.CREATED);
	}
	
	@GetMapping("/productSlugList")
	public ResponseEntity<List<ProductSlug>> getAllProductSlugs() {
		logger.debug("getAllProductSlugs method start in ProductSlugController");
		List<ProductSlug> productSlugList = productSlugService.getAllProductSlugs();
		logger.debug("getAllProductSlugs method end  in ProductSlugController");
		return new ResponseEntity<>(productSlugList, HttpStatus.OK);
	}

	@GetMapping("/productSlug/{id}")
	public ResponseEntity<ProductSlug> getProductSlugById(@PathVariable("id") String id) {
		logger.debug("getProductSlugById method start in ProductSlugController");
		ProductSlug productSlug = productSlugService.getProductSlugById(id);
		logger.debug("getProductSlugById method end in ProductSlugController");
		return new ResponseEntity<>(productSlug, HttpStatus.OK);

	}

	@PutMapping("/updateProductSlug")
	public ResponseEntity<ProductSlug> updateProductSlug(@RequestBody ProductSlug productSlug) {
		logger.debug("updateProductSlug method start in ProductSlugController");
		ProductSlug updatedProductSlug = productSlugService.updateProductSlug(productSlug);
		logger.debug("updateProductSlug method end in ProductSlugController");
		return new ResponseEntity<>(updatedProductSlug, HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductSlug/{id}")
	public ResponseEntity<HttpStatus> deleteProductSlug(@PathVariable("id") String id) {
		logger.debug("deleteProductSlug method start in ProductSlugController");
		productSlugService.deleteProductSlugById(id);
		logger.debug("deleteProductSlug method end in ProductSlugController");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
