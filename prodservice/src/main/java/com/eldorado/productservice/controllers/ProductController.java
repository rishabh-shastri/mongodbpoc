package com.eldorado.productservice.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eldorado.productservice.config.LoggingConfig;
import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.InvalidEntryException;
import com.eldorado.productservice.services.ProductService;

/**
 * Product Controller Handles the incoming request
 * @param <K>
 * @param <V>
 **/

@Configuration
@CrossOrigin(origins = "${frontend.connection}", maxAge = 3600)
@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	ProductService productService;


	// log4j Logger object for logging in
	Logger log = LoggingConfig.getLog();

	@PostMapping("/admin/product")
	public Product addProduct(@RequestBody Product product) throws EmptyFieldException, InvalidEntryException {
		return productService.addProductService(product);
	}


	@GetMapping("customer/products")
	public Map<String, Object> getProductList(@RequestParam int view) {
		return productService.getProductList(view);
	}
	
	@GetMapping("customer/products/filter")
	@ResponseBody
	public Map<String,Object> filter(@RequestParam int view,@RequestParam String category, @RequestParam double minPrice, @RequestParam double maxPrice, @RequestParam int quantity){
		return productService.filter(view, category, minPrice, maxPrice,quantity);
	}
}
