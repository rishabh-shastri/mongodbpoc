package com.eldorado.productservice.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.eldorado.productservice.entities.Product;

/*
 * ProductRepository Interface have save method
 * save method use to save data in product table in database
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	@Query("{ category:{$eq : ?0}, price: { $gt: ?1, $lt: ?2}, quantity:{$eq :?3 }}")
	public Page<Product> find(String category,double minPrice, double maxPrice, int quantity, Pageable pageable);
}
