package com.productmanagement.service;

import java.util.List;

import com.productmanagement.model.ProductLabel;

public interface ProductLabelService {

	ProductLabel createProductLabel(ProductLabel productLabel);

	List<ProductLabel> getAllProductLabels();

	void deleteProductLabelById(String id);

	ProductLabel updateProductLabel(ProductLabel productLabel);

}
