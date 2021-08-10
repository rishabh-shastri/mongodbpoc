package com.eldorado.productservice.stepdefinitions;


import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RatingSteps {

	User user;
	boolean result;
	
	@Given("I login as valid user to Eldorado")
	public void i_login_as_valid_user_to_eldorado() {
		user = new User(true);
	}
	
	@When("I access product detail page for rating")
	public void i_access_product_detail_page_for_rating() {
		result = user.accessDetailPage(true);
	}

	
	@And("I hover on your rating")
	public void i_hover_on_your_rating() 
	{
		result = result && user.hoverOnYourRating(true);
	}
	
	@Then("I can give rating to a product")
	public void i_can_give_rating_to_a_product() {
		assertEquals(true,result);
	}

	@Then("I can edit rating of a product")
	public void i_can_edit_rating_of_a_product() {
		assertEquals(true,result);
	}

	@Then("I can view average rating to a product")
	public void i_can_view_average_rating_to_a_product() {
		assertEquals(true,result);
	}	
	
}

