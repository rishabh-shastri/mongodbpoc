package com.eldorado.productservice.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.InvalidEntryException;
import com.eldorado.productservice.services.ProductService;
import com.eldorado.productservice.services.ProductServiceImpl;

class ProductControllerTest {
/*
	@Test
	public void addProductTest() throws EmptyFieldException, InvalidEntryException 
	{
		// given
		Product product = new Product();
		ProductController productcontroller = new ProductController();
		
		// when
		ProductService productService = mock(ProductService.class);
		when(productService.addProductService(product)).thenThrow(new EmptyFieldException(null));
		
		// then
		assertThrows(EmptyFieldException.class,() -> productcontroller.addProduct(product));
		
	}
*/
}
