package com.eldorado.productservice.stepdefinitions;


public class User
{
	boolean valid;
	
	User(boolean valid)
	{
		this.valid = valid;
	}
	
	public boolean accessDetailPage(boolean acc) 
	{
		if(this.valid && acc)return acc;
		else return false;
	}
	
	public boolean clickOnProductVariant(boolean click) 
	{
		return click; 
	}
	
	public boolean clickOnImageOrVideo(boolean click) 
	{
		return click; 
	}
	
	public boolean hoverOnYourRating(boolean click) 
	{
		return click; 
	}	
	
	public boolean clickOnPdfLink(boolean click) 
	{
		return click; 
	}
	
	public boolean requestPage(boolean click) {
		return click;
	}
	
	public boolean loggedIn(boolean click) {
		return click;
	}
	
	public boolean viewProductListPage(boolean click) {
		return click;
	}

	public boolean clickOnProduct(boolean click) {
		return click;
	}

	public boolean clickOnPaginateButton(boolean click) {
		return click;
	}
	
}