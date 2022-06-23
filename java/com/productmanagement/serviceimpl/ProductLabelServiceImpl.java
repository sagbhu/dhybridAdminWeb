package com.productmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.model.ProductLabel;
import com.productmanagement.repository.ProductLabelRepository;
import com.productmanagement.service.ProductLabelService;

@Service
public class ProductLabelServiceImpl implements ProductLabelService{

	@Autowired
	ProductLabelRepository productLabelRepository;
	
	@Override
	public ProductLabel createProductLabel(ProductLabel productLabel) {
		return productLabelRepository.insert(productLabel);
	}

	@Override
	public List<ProductLabel> getAllProductLabels() {

		return productLabelRepository.findAll();
	}

	@Override
	public void deleteProductLabelById(String id) {
		productLabelRepository.deleteById(id);
		
	}

	@Override
	public ProductLabel updateProductLabel(ProductLabel productLabel) {
		
		return productLabelRepository.insert(productLabel);
	}

	

}
