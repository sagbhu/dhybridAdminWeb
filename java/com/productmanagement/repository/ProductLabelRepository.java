package com.productmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productmanagement.model.ProductLabel;

@Repository
public interface ProductLabelRepository extends MongoRepository<ProductLabel, String>{

}
