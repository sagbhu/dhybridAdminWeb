package com.dhybrid.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dhybrid.admin.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{username : ?0}")
	User getUserByUsername(String username);
}
