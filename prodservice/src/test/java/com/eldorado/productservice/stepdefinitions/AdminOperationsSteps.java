package com.eldorado.productservice.stepdefinitions;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminOperationsSteps {

	AdminUser adminUser;
	boolean result;
	
	@Given("I have login to Eldorado as an Admin")
	public void i_have_login_to_eldorado_as_an_admin() {
		adminUser = new AdminUser(true,true);
	}

	@When("I access product detail page")
	public void i_access_product_detail_page() {
		result = adminUser.accessDetailPage(true);
	}

	@And("I click on edit button")
	public void i_click_on_edit_button() {
		result = result && adminUser.clickOnEditProduct(true);
	}

	@Then("I can edit product")
	public void i_can_edit_product() {
		assertEquals(true,result);
	}

	@And("I get confirmation popup for saving edit")
	public void i_get_confirmation_popup_for_saving_edit() {
		result = result && adminUser.savingEditConfirmation(true);
		assertEquals(true,result);
	}

	@And("I click on delete button")
	public void i_click_on_delete_button() {
		result = result && adminUser.clickOnDeleteProduct(true);
	}

	@Then("I can delete product")
	public void i_can_delete_product() {
		assertEquals(true,result);
	}

	@And("I get confirmation popup for saving delete")
	public void i_get_confirmation_popup_for_saving_delete() {
		result = result && adminUser.savingDeleteConfirmation(true);
		assertEquals(true,result);
	}	
	
}


