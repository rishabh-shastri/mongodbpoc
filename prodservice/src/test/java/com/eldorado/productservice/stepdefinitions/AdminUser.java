package com.eldorado.productservice.stepdefinitions;

public class AdminUser
{
	boolean isValid;
	boolean isAdmin;
	
	AdminUser(boolean valid,boolean admin)
	{
		this.isValid = valid;
		this.isAdmin = admin;
	}
	
	public boolean accessDetailPage(boolean acc) 
	{
		if(this.isValid && this.isAdmin && acc)return acc;
		else return false;
	}
	
	public boolean clickOnEditProduct(boolean click) 
	{
		return click; 
	}
	
	public boolean clickOnDeleteProduct(boolean click) 
	{
		return click; 
	}
	
	public boolean savingEditConfirmation(boolean click) 
	{
		return click; 
	}
	
	public boolean savingDeleteConfirmation(boolean click) 
	{
		return click; 
	}
}