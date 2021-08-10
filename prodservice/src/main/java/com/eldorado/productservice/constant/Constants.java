package com.eldorado.productservice.constant;

public class Constants {

	// Message To User
	public static final String confirmUserError = "Error";
	public static final String confirmUserSuccess = "Success";
	public static final String deleteProductMsg = "Product deleted successfully";
	public static final String productAddedMsg = "Product added successfully";
	public static final String notDeleteProductMsg = "Product not deleted";

	// Product Details
	public static final String productAddedSuccessfully = "Product Added Successfully";
	public static final String productDetailsNotReceived = "Product Details Not Recieved";
	public static final String productDetails = "Product Details Fetched";
	public static final String noProductWithThisId = "No Product Found with such ID";

	// Product Rating
	public static final String ratingAddedSuccessfully = "Rating Added Successfully";
	public static final String ratingUpdatedSuccessfully = "Rating Updated Successfully";
	public static final String ratingPresent = "Rating of this user is present";
	public static final String noRatingOfUser = "User hasn't rate this product yet!";

	// REGEX
	public static final String imageRegex = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)";
	public static final String videoRegex = "^((?:https?:)?\\/\\/)?((?:www|m)\\.)?((?:youtube\\.com|youtu.be))(\\/(?:[\\w-]+\\?v=|embed\\/|v\\/)?)([\\w-]+)(\\S+)?$";
	public static final String pdfRegex = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:pdf)";

	// Exception
	public static final String emptyField = "Empty Field Exception";
	public static final String productNotFound = "No such product exists.";

	// Swagger
	public static final String title = "Spring Boot REST API";
	public static final String description ="Spring Boot REST API for EL DORADO App";
	public static final String version = "1.0";
	public static final String termsOfServiceUrl = "Terms of service";
	public static final String license = "Apache License Version 2.2";
	public static final String licenseUrl = "https://www.eldorado.com";

}
