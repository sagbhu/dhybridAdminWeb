package com.dhybrid.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhybrid.admin.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/getProducts")
	public ResponseEntity<String> getProduct(HttpServletRequest request) {
		String pageNumber = request.getParameter("pageNumber");
		return new ResponseEntity<String>(productService.getProducts(pageNumber), HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> getProducts(
			@RequestParam(defaultValue = "", required = false) String name, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return new ResponseEntity<>(productService.getProducts(name, page, size), HttpStatus.OK);
	}

	@PostMapping("/updateProduct")
	public ResponseEntity<Map<String, Object>> updateProduct(HttpServletRequest request) {
		Map<String, Object> response = productService.updateProducts(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/updateProductsSlugsLabels")
	public ResponseEntity<Map<String, Object>> updateProductsSlugsLabels(HttpServletRequest request) {
		return new ResponseEntity<>(productService.updateProducts(request), HttpStatus.OK);
	}
}
