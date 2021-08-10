package com.eldorado.productservice.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.InvalidEntryException;

/*
 * 
 * Product Service Interface Having Functions
 * to save data in product and tags database tables
 */
@Service
public interface ProductService {
	public Product addProductService(Product product) throws EmptyFieldException, InvalidEntryException;

	public Map<String, Object> getProductList(int view);

	public Map<String,Object> filter(int view, String category, double minPrice, double maxPrice,int quantity);
}
