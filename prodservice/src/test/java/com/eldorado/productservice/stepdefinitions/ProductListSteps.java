package com.eldorado.productservice.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListSteps {
	

	User user;
	boolean result;
	@Given("User Is Valid User")
	public void user_is_valid_user() {
		User user = new User(true);
	}

	@When("User Just Logged In")
	public void user_just_logged_in() {
		user.loggedIn(true);
	}
	
	@When("GET request is received")
	public void get_request_is_received() {
	    result = user.requestPage(true);
	}

	@Then("Product List response is send for the request")
	public void product_list_response_is_send_for_the_request() {
	    assertEquals(result,true);
	}

	@Given("User is on the product list page")
	public void user_is_on_the_product_list_page() {
		user.viewProductListPage(true);
	}

	@When("User click a product from product list page")
	public void user_click_a_product_from_product_list_page() {
	    result=user.clickOnProduct(true);
	}
	@Then("GET Request for product detail is received")
	public void get_request_for_product_detail_is_received() {
		assertTrue(result);
	}

	@Then("Product details response is send")
	public void product_details_response_is_send() {
		assertTrue(result);
	}

	@When("User click on paginate button")
	public void user_click_on_paginate_button() {
		result=user.clickOnPaginateButton(true);
	}

	@Then("GET request for the next page is received")
	public void get_request_for_the_next_page_is_received() {
	    assertTrue(result);
	}

	@Then("Product List response is send")
	public void product_list_response_is_send() {
		assertTrue(result);
	}
	
}
