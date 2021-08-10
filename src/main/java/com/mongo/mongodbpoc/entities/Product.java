package com.mongo.mongodbpoc.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_details")
public class Product {
	
	@Id
	private String Id;
	private String name;
	private String category;
	private int age;

}
