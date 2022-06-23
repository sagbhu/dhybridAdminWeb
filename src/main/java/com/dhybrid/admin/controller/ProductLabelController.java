package com.dhybrid.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhybrid.admin.service.ProductLabelService;

@Controller

@RequestMapping("/product/label")
public class ProductLabelController {
	@Autowired
	ProductLabelService productLabelService;

	@PostMapping("/create")
	public ResponseEntity<String> create(HttpServletRequest request) {
		return new ResponseEntity<String>(productLabelService.create(request), HttpStatus.CREATED);
	}

	@PostMapping("/list")
	public ResponseEntity<String> getAlls() {
		return new ResponseEntity<String>(productLabelService.get(), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<String> update(HttpServletRequest request) {
		return new ResponseEntity<String>(productLabelService.update(request), HttpStatus.OK);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity<String>(productLabelService.delete(id), HttpStatus.OK);
	}
	
	@PostMapping("/getLabel/{name}")
	public ResponseEntity<String> getProductLabel(@PathVariable String name) {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
}
