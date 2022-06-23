package com.productmanagement.custom.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.productmanagement.model.ProductSlug;
import com.productmanagement.service.ProductSlugService;



public class SlugValidator implements ConstraintValidator<SlugValidation, List<ProductSlug>> {

	@Autowired
	private ProductSlugService productSlugService;

	@Override
	public void initialize(SlugValidation slugId) {
	}

	@Override
	public boolean isValid(List<ProductSlug> slugFromUser, ConstraintValidatorContext context) {
		List<ProductSlug> slugFromDB = productSlugService.getAllProductSlugs();
		List<ProductSlug> tempSlugList = new ArrayList<>();
		tempSlugList.addAll(slugFromUser);
		tempSlugList.removeAll(slugFromDB);
		if (!tempSlugList.isEmpty()) {
			return false;
		}
		return true;
	}
}