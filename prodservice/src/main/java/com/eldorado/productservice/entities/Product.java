package com.eldorado.productservice.entities;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	private String productId;

	private String title;

	private String description;

	private String category;

	private Double price;

	private Integer quantity;

	private String pdfLink;

	private List<String> productImages;

	private List<String> videoLinks;

	private HashMap<String, String> metatag;

	public Product() {

	}

	public Product(String productId, String title, String description, Double price,
			String category, Integer quantity, String pdfLink, List<String> videoLinks, List<String> productImages) {
		super();
		this.productId = productId;
//		this.variationId = variationId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.pdfLink = pdfLink;
		this.videoLinks = videoLinks;
		this.productImages = productImages;
	}

//	public String getVariationId() {
//		return variationId;
//	}
//
//	public void setVariationId(String variationId) {
//		this.variationId = variationId;
//	}
//
//	public String getProductId() {
//		return productId;
//	}
//
//	public void setProductId(String productId) {
//		this.productId = productId;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPdfLink() {
		return pdfLink;
	}

	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}

	public List<String> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<String> productImages) {
		this.productImages = productImages;
	}

	public List<String> getVideoLinks() {
		return videoLinks;
	}

	public void setVideoLinks(List<String> videoLinks) {
		this.videoLinks = videoLinks;
	}

	public HashMap<String, String> getMetatag() {
		return metatag;
	}

	public void setMetatag(HashMap<String, String> metatag) {
		this.metatag = metatag;
	}


	
	

}
