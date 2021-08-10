package com.mongo.mongodbpoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.mongodbpoc.entities.Product;
import com.mongo.mongodbpoc.repositories.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		repository.save(product);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/filter")
	public List<Product> filterByCategory(@RequestParam String category, @RequestParam int minAge, @RequestParam int maxAge) {
		Pageable pageable = PageRequest.of(0, 5);
		return repository.find(category, minAge, maxAge, pageable).getContent();
	}

}
