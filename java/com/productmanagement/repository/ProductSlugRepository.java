package com.productmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productmanagement.model.ProductSlug;

@Repository
public interface ProductSlugRepository extends MongoRepository<ProductSlug, String>{

}
