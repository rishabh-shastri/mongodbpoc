package com.eldorado.productservice.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eldorado.productservice.config.LoggingConfig;
import com.eldorado.productservice.constant.Constants;
import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.InvalidEntryException;
import com.eldorado.productservice.repositories.ProductRepository;

//Implementation of Product Service Interface
/*
 * ProductServiceImpl class acts as service for repository class
 * handle all the service level implementation
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	// log4j Logger object for logging in
	Logger log = LoggingConfig.getLog();

	/*
	 * @param Product
	 * 
	 * @return Product
	 */
	public Product addProductService(Product product) throws EmptyFieldException, InvalidEntryException {

		Product ret = productRepository.save(product);
		
		if (product != null) {
			log.info(Constants.productAddedSuccessfully);
		} else {
			log.info(Constants.productDetailsNotReceived);
		}
		return ret;
	}


	
	@Override
	public Map<String, Object> getProductList(int view) {
		Pageable pageable = PageRequest.of(view-1, 45);
		Page<Product> productPage = productRepository.findAll(pageable);
		List<Product> productList = productPage.getContent();
		Map<String,Object> responseBody = new HashMap<>();
		boolean hasNext=productPage.getTotalPages()==view?false:true;
		responseBody.put("data", productList);
		responseBody.put("hasNext", hasNext);
		return responseBody;
	}
	
	@Override
	public Map<String,Object> filter(int view, String category,double minPrice,double maxPrice,int quantity) {
		Pageable pageable = PageRequest.of(view-1, 45);
		Page<Product> productPage = productRepository.find(category,minPrice,maxPrice,quantity,pageable);
		Map<String,Object> responseBody = new HashMap<>();
		boolean hasNext=productPage.getTotalPages()!=view;
		responseBody.put("data", productPage.getContent());
		responseBody.put("hasNext", hasNext);
		return responseBody;
	}
}
