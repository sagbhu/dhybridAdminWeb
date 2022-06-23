package com.productmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.productmanagement.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String>{

	
	@Query("{}")
	List<ProductCategory> getLastProductCategoryUpdatedDate(Pageable page);
}
