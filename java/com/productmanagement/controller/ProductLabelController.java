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
import com.productmanagement.model.ProductLabel;
import com.productmanagement.service.ProductLabelService;

@RestController
@RequestMapping(URLConstants.PRODUCT_SERVICE_URL)
public class ProductLabelController {

	private static final Logger logger = LoggerFactory.getLogger(ProductLabelController.class);

	@Autowired
	private ProductLabelService productLabelService;

	
	@PostMapping("/createProductLabel")
	public ResponseEntity<ProductLabel> createProductLabel(@RequestBody ProductLabel productLabel) {
		logger.debug("createProductLabel method start in ProductLabelController");
		ProductLabel newProductLabel = productLabelService.createProductLabel(productLabel);
		logger.debug("createProductLabel method start in ProductLabelController");
		return new ResponseEntity<>(newProductLabel, HttpStatus.CREATED);
	}
	
	@GetMapping("/productLabelList")
	public ResponseEntity<List<ProductLabel>> getAllProductLabels() {
		logger.debug("getAllProductLabels method start in ProductLabelController");
		List<ProductLabel> productLabelList = productLabelService.getAllProductLabels();
		logger.debug("getting AllProductLabels method end  in ProductLabelController");
		return new ResponseEntity<>(productLabelList, HttpStatus.OK);
	}



	@PutMapping("/updateProductLabel")
	public ResponseEntity<ProductLabel> updateProductLabel(@RequestBody ProductLabel productLabel) {
		logger.debug("updateProductLabel method start in ProductLabelController");
		ProductLabel updatedProductLabel = productLabelService.updateProductLabel(productLabel);
		logger.debug("updateProductLabel method end in ProductLabelController");
		return new ResponseEntity<>(updatedProductLabel, HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductLabel/{id}")
	public ResponseEntity<HttpStatus> deleteProductLabel(@PathVariable("id") String id) {
		logger.debug("deleteProductLabel method start in ProductLabelController");
		productLabelService.deleteProductLabelById(id);
		logger.debug("deleteProductLabel method end in ProductLabelController");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
