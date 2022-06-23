package com.dhybrid.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dhybrid.admin.request.ProductSlugRequest;
import com.dhybrid.admin.service.ProductSlugService;

@Controller
public class ProductSlugController {
	@Autowired
	ProductSlugService productSlugService;

	@PostMapping("/createProductSlug")
	public ResponseEntity<String> createProductSlug(HttpServletRequest request) {
		String slugName = request.getParameter("slugName");
		String slugState = request.getParameter("slugState");
		return new ResponseEntity<String>(productSlugService.createProductSlug(slugName, slugState),
				HttpStatus.CREATED);
	}

	@PostMapping("/productSlugList")
	public ResponseEntity<String> getAllProductSlugs() {
		return new ResponseEntity<String>(productSlugService.getProductsSlug(), HttpStatus.OK);
	}

	@PostMapping("/updateProductSlug")
	public ResponseEntity<String> updateProductSlug(HttpServletRequest request) {
		
		ProductSlugRequest productSlugRequest = new ProductSlugRequest();
		productSlugRequest.setId(request.getParameter("Id"));
		productSlugRequest.setSlugName(request.getParameter("slugName"));
		productSlugRequest.setState(request.getParameter("state"));
		return new ResponseEntity<String>(productSlugService.updateProductSlug(productSlugRequest), HttpStatus.OK);
	}

	@PostMapping("/deleteProductSlug/{slugId}")
	public ResponseEntity<String> deleteProductSlug(@PathVariable String slugId) {
		return new ResponseEntity<String>(productSlugService.deleteProductSlug(slugId), HttpStatus.OK);
	}
}
