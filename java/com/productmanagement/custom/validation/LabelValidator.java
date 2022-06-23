package com.productmanagement.custom.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.productmanagement.model.ProductLabel;
import com.productmanagement.service.ProductLabelService;




public class LabelValidator implements ConstraintValidator<LabelValidation, ProductLabel> {

	@Autowired
	private ProductLabelService productLabelService;

	@Override
	public void initialize(LabelValidation labelId) {
	}



	@Override
	public boolean isValid(ProductLabel labelFromUser, ConstraintValidatorContext context) {
		List<ProductLabel> LabelFromDB = productLabelService.getAllProductLabels();
		List<ProductLabel> tempLabelList = new ArrayList<>();
		tempLabelList.add(labelFromUser);
		tempLabelList.removeAll(LabelFromDB);
		if (!tempLabelList.isEmpty()) {
			return false;
		}
		return true;
	}
}