package com.productmanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.model.ProductSlug;
import com.productmanagement.repository.ProductSlugRepository;
import com.productmanagement.service.ProductSlugService;

@Service
public class ProductSlugServiceImpl implements ProductSlugService{

	@Autowired
	ProductSlugRepository productSlugRepository;
	
	@Override
	public ProductSlug createProductSlug(ProductSlug productSlug) {
		return productSlugRepository.insert(productSlug);
	}

	@Override
	public List<ProductSlug> getAllProductSlugs() {
		return productSlugRepository.findAll();
	}

	@Override
	public ProductSlug getProductSlugById(String id) {
		Optional<ProductSlug> productSlugDB =productSlugRepository.findById(id);
		ProductSlug productSlug=null;
		if(productSlugDB.isPresent()) {
			productSlug=productSlugDB.get();
		}
		return productSlug;
	}

	@Override
	public ProductSlug updateProductSlug(ProductSlug productSlug) {
		  return productSlugRepository.save(productSlug);
	}
	@Override
	public void deleteProductSlugById(String id) {
		 productSlugRepository.deleteById(id);
	}



}
