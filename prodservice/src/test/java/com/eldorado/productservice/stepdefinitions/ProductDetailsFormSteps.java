package com.eldorado.productservice.stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsFormSteps
{
	User user;
	boolean result;
		
	@Given("I have login as valid user to Eldorado")
	public void i_have_login_as_valid_user_to_eldorado() {
		user = new User(true);
	}
	@Given("I have login as Invalid user to Eldorado")
	public void i_have_login_as_invalid_user_to_eldorado() {
		user = new User(false);
	}
	@When("I access the product detail page")
	public void i_access_the_product_detail_page() {
		result = user.accessDetailPage(true);
	}
	@Then("I can view product details")
	public void i_can_view_product_details() {
		assertEquals(true,result);
	}
	@Then("I can not view product details")
	public void i_can_not_view_product_details() {
		assertEquals(false,result);
	}
	
	@And("I click on a product's variant")
	public void i_click_on_a_product_variant() 
	{
		result = result && user.clickOnProductVariant(true);
	}
	
	@Then("I can view respective variant details")
	public void i_can_view_respective_variant_details() 
	{
		assertEquals(true,result);
	}
	
	@And("I click on an image or video")
	public void i_click_on_an_image_or_video() 
	{
		result = result && user.clickOnImageOrVideo(true);
	}

	@Then("I can view the respective image or video")
	public void i_can_view_the_respective_image_or_video() 
	{
		assertEquals(true,result);
	}
	
	@And("I click on a pdf link")
	public void i_click_on_a_pdf_link() 
	{
		result = result && user.clickOnPdfLink(true);
	}
	
	@Then("I can view the pdf in the same view")
	public void i_can_view_the_pdf_in_the_same_view() 
	{
		assertEquals(true,result);
	}
	
}
