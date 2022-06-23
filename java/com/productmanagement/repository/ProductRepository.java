package com.productmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.productmanagement.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@Query("{'$or':[ {'skuName':/?0/}, {'productCategory':/?0/} ] }")
	Page<Product> getProductListBySearchParam(String searchParam, Pageable page);
	
	
	

	@Query("{brandName : /?0/}")
	Page<Product> getProductListByBrandName(String brandName, Pageable page);

	@Query("{'color': /?0/}")
	Page<Product> getProductListByColor(String color, Pageable page);

	@Query("{productStatus : /?0/}")
	Page<Product> getProductListByAvailability(String availability, Pageable page);

	@Query("{mrp : {$gt : ?0, $lt : ?1}}")
	Page<Product> getProductListByPriceRange(double priceStart, double priceEnd, Pageable page);

	@Query("{'slug.$id': ObjectId('?0')}")
	Page<Product> getProductListBySlug(String slugId, Pageable page); 

	@Query("{}")
	List<Product> getLastProductUpdatedDate(Pageable page);
}
