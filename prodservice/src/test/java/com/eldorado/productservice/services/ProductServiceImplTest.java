package com.eldorado.productservice.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.eldorado.productservice.constant.Constants;
import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.EntityNotFoundException;
import com.eldorado.productservice.exceptions.InvalidEntryException;
import com.eldorado.productservice.repositories.ProductRepository;
import com.eldorado.productservice.repositories.ProductRepositoryImpl;

//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.InvalidEntryException;

// Test Class for ProductServiceImpl
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

	@Autowired
	ProductServiceImpl productService;
	
	@MockBean
	ProductRepositoryImpl productRepository;
	
	@Test
	public void addProductServiceTest() throws EmptyFieldException, InvalidEntryException {
		//given
//		ProductServiceImpl productService=new ProductServiceImpl();
//		ProductRepositoryImpl productRepository = mock(ProductRepositoryImpl.class);
		
		List<String> imageLinksList = new ArrayList<>();
		imageLinksList.add("https://cdn.britannica.com/17/83817-050-67C814CD/Mount-Everest.jpg"); // Adding an invalid Image URL

		List<String> videoLinksList = new ArrayList<>();
		videoLinksList.add("https://www.youtube.com/watch?v=lFP3-4b1NYg"); // Adding an invalid Video URL

		Product product = new Product("p1", "v1", "add87@", "description",1.0, "Accessories", 1,
				"http://www.example.com/ %26here.html",videoLinksList,imageLinksList);
		
		//when
		when(productRepository.save(product)).thenReturn(product);

		//then
		assertEquals(product.getProductId(),(productService.addProductService(product)).getProductId());
//		productService.addProductService(p1);
//		verify(productService).addProductService(p1);

	}

	@Test
	public void getProductDetailsTest() throws EntityNotFoundException, EmptyFieldException {

		List<String> imageLinksList = new ArrayList<>();
		imageLinksList.add("https://cdn.britannica.com/17/83817-050-67C814CD/Mount-Everest.jpg"); // Adding an invalid Image URL

		List<String> videoLinksList = new ArrayList<>();
		videoLinksList.add("https://www.youtube.com/watch?v=lFP3-4b1NYg"); // Adding an invalid Video URL

		Product product = new Product("p1", "v1", "add87@", "description",1.0, "Accessories", 1,
				"http://www.example.com/ %26here.html",videoLinksList,imageLinksList);
		
//		when(productRepository.save(product)).thenReturn(product);
		when(productRepository.getProduct("v1")).thenReturn(product);

		// verify
		assertNotNull(productService.getProductDetails("v1"));

	}

	@Test
	public void deleteByIdTest() throws EntityNotFoundException, EmptyFieldException {

		List<String> imageLinksList = new ArrayList<>();
		imageLinksList.add("https://cdn.britannica.com/17/83817-050-67C814CD/Mount-Everest.jpg"); // Adding an invalid Image URL

		List<String> videoLinksList = new ArrayList<>();
		videoLinksList.add("https://www.youtube.com/watch?v=lFP3-4b1NYg"); // Adding an invalid Video URL

		Product product = new Product("p1", "v1", "add87@", "description",1.0, "Accessories", 1,
				"http://www.example.com/ %26here.html",videoLinksList,imageLinksList);		
		
		when(productRepository.getDeleteById("v1")).thenReturn(Constants.deleteProductMsg);
		
		assertEquals(Constants.deleteProductMsg,productService.deleteById("v1"));
		
	}

}
