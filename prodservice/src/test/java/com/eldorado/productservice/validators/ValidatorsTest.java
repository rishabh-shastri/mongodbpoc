package com.eldorado.productservice.validators;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.eldorado.productservice.entities.Product;
import com.eldorado.productservice.entities.Rating;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.InvalidEntryException;

public class ValidatorsTest {

	
	@Test
	public void InvalidProductTitle() {
		String name = ""; // Empty Product Name
		assertThrows(EmptyFieldException.class, () -> Validators.validateProductTitle(name));
	}

	@Test
	public void InvalidProductDesc() {
		String desc = "";
		assertThrows(EmptyFieldException.class, () -> Validators.validateProductDesc(desc));
	}

	@Test
	public void InvalidProductQuantity() {
		Integer quantity = -1;
		assertThrows(InvalidEntryException.class, () -> Validators.validateProductQuantity(quantity));
	}

	@Test
	public void InvalidProductPrice() {
		Double price = -1.0;
		assertThrows(InvalidEntryException.class, () -> Validators.validateProductPrice(price));
	}

	@Test
	public void InvalidProductCategory() {
		String category = "";
		assertThrows(EmptyFieldException.class, () -> Validators.validateProductCategory(category));// Testing with
																								// assertThrows
	}

	@Test
	public void InvalidProductImageLinks() {
		String link = "http://www.example.com/ %26here.html";
		assertThrows(InvalidEntryException.class, () -> Validators.validateProductImageLinks(link));// Testing with
																								// assertThrows
	}

	@Test
	public void InvalidProductVideoLinks() {
		String link = "http://www.example.com/ %26here.html";
		assertThrows(InvalidEntryException.class, () -> Validators.validateProductVideoLinks(link));// Testing with
																								// assertThrows
	}

	@Test
	public void InvalidProductPdfLinks() {
		String link = "http://www.example.com/ %26here.html";
		assertThrows(InvalidEntryException.class, () -> Validators.validateProductPdfLink(link));// Testing with assertThrows
	}
	
	@Test
	public void InvalidProductDetails() {
		List<String> imageLinksList = new ArrayList<>();
		imageLinksList.add("https://cdn.britannica.com/17/83817-050-67C814CD/Mount-Everest.jpg"); // Adding an invalid Image URL

		List<String> videoLinksList = new ArrayList<>();
		videoLinksList.add("https://www.youtube.com/watch?v=lFP3-4b1NYg"); // Adding an invalid Video URL

		Product product = new Product("p1", "v1", "add87@", "Xyz",1.0, "Accessories", 1,
				"http://www.example.com/ %26here.html",videoLinksList,imageLinksList);
		assertThrows(InvalidEntryException.class, () -> Validators.validateProductDetails(product)); // Testing with
																									// assertThrows
	}
	
	@Test
	public void InvalidRatingDetails() {

		Rating rating = new Rating("p1","u1",-1);
		assertThrows(InvalidEntryException.class, () -> Validators.validateRatingDetails(rating)); // Testing with
																									// assertThrows
	}
	
	@Test
	public void invalidUserId() {
		String userId = ""; // Empty Product Name
		assertThrows(EmptyFieldException.class, () -> Validators.validateUserId(userId));
	}
	
	@Test
	public void invalidRatingId() {
		String ratingId = ""; // Empty Product Name
		assertThrows(EmptyFieldException.class, () -> Validators.validateRatingId(ratingId));
	}
	
	@Test
	public void invalidProductId() {
		String productId = ""; // Empty Product Name
		assertThrows(EmptyFieldException.class, () -> Validators.validateProductId(productId));
	}
	
	@Test
	public void invalidRate() {
		Integer rate = 6; // Empty Product Name
		assertThrows(InvalidEntryException.class, () -> Validators.validateRate(rate));
	}
	
	@Test
	public void invalidVariationId() {
		String variationId = ""; // Empty Product Name
		assertThrows(EmptyFieldException.class, () -> Validators.validateVariationId(variationId));
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void validProductDetails(){
		List<String> imageLinksList = new ArrayList<>();
		imageLinksList.add("https://cdn.britannica.com/17/83817-050-67C814CD/Mount-Everest.jpg"); // Adding an invalid Image URL

		List<String> videoLinksList = new ArrayList<>();
		videoLinksList.add("https://www.youtube.com/watch?v=lFP3-4b1NYg"); // Adding an invalid Video URL

		Product product = new Product("p1", "v1", "add87@", "",1.0, "Accessories", 1,
				"http://www.example.com/ %26here.html",videoLinksList,imageLinksList);
		Exception exception = assertThrows(EmptyFieldException.class,()->Validators.validateProductDetails(product)); //Testing with assertThrows
		String expectedMessage = "Desc Field";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage)); //Testing if Exception thrown is Matching Expected Exception Thrown 
	}
	
	@Test
	public void validProductTitle(){
		String name = ""; //Empty Product Name
		Exception exception = assertThrows(EmptyFieldException.class,()->Validators.validateProductTitle(name));//Testing with assertThrows
		String expectedMessage = "Title Field";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}
	
		
	@Test
	public void validProductDescription(){
		String desc = "";
		Exception exception = assertThrows(EmptyFieldException.class,()->Validators.validateProductDesc(desc));//Testing with assertThrows
		String expectedMessage = "Desc Field";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}
	@Test
	public void validProductQuantity(){
		Integer quantity = -1;
		Exception exception = assertThrows(InvalidEntryException.class,()->Validators.validateProductQuantity(quantity));//Testing with assertThrows
		String expectedMessage = "Product Quantity";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}
	@Test
	public void validProductPrice(){
		Double price = -1.0;
		Exception exception = assertThrows(InvalidEntryException.class,()->Validators.validateProductPrice(price));//Testing with assertThrows
		String expectedMessage = "Product Price";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}
	
	@Test
	public void validProductImageLinks(){
		String link = "http://www.example.com/ %26here.html";
		Exception exception = assertThrows(InvalidEntryException.class,()->Validators.validateProductImageLinks(link));//Testing with assertThrows
		String expectedMessage = "Image Links";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}

	@Test
	public void validProductVideoLinks(){
		String link = "http://www.example.com/ %26here.html";
		Exception exception = assertThrows(InvalidEntryException.class,()->Validators.validateProductVideoLinks(link));//Testing with assertThrows
		String expectedMessage = "Video Links";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}

	@Test
	public void validProductPdfLinks(){
		String link = "http://www.example.com/ %26here.html";
		Exception exception = assertThrows(InvalidEntryException.class,()->Validators.validateProductPdfLink(link));//Testing with assertThrows
		String expectedMessage = "Pdf Links";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}
	
	@Test
	public void validProductCategory() {
		String category="";
		Exception exception = assertThrows(EmptyFieldException.class,()->Validators.validateProductCategory(category));//Testing with assertThrows
		String expectedMessage = "Product Category ";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));//Testing if Exception thrown is Matching Expected Exception Thrown
	}
	
	
}
