package com.eldorado.productservice.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.ScanResultPage;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.eldorado.productservice.entities.Product;

class ProductRepositoryImplTest {

	
	// Testing the functionality of getProductList
	@Test
	void getProductListTest() {
		
		DynamoDBScanExpression scanExpressionMock = mock(DynamoDBScanExpression.class);
		DynamoDBMapper dynamoDBMapperMock = mock(DynamoDBMapper.class);
		@SuppressWarnings("unchecked")
		ScanResultPage<Product> scanPageMock = mock(ScanResultPage.class);
		when(dynamoDBMapperMock.scanPage(Product.class, scanExpressionMock)).thenReturn(scanPageMock);
		
		List<Product> productList = new ArrayList<>();
		List<String> videoLinks = new ArrayList<>();
		videoLinks.add("https://www.youtube.com/watch?v=EkJMdoFuTrc");
		List<String> productImages = new ArrayList<>();
		productImages.add("https://cdn.myimaginestore.com/media/catalog/product/cache/7/image/745x/602f0fa2c1f0d1ba5e241f914e856ff9/i/p/iphone-12-2020.jpg");
		productList.add(new Product("pid","vid","iphone 13" ,"Smoother Experience" , 150000.0, "Mobile" , 100, "https://images-eu.ssl-images-amazon.com/images/I/E10sDDhm75S.pdf",videoLinks , productImages));
		Map<String,Object> responseBody=new HashMap<>();
		responseBody.put("data", productList);
		responseBody.put("hasNext", false);
		when(scanPageMock.getResults()).thenReturn(productList);
		when(scanPageMock.getLastEvaluatedKey()).thenReturn(null);
		ProductRepositoryImpl prodRepo = new ProductRepositoryImpl(dynamoDBMapperMock) {
			@Override
			protected DynamoDBScanExpression createDynamoDBScanExpression() {
				return scanExpressionMock;
			}
		};
		assertEquals(prodRepo.findAll(1),responseBody);
	}
	@Test
	void filterTestWithCategoryAll() {
		DynamoDBScanExpression scanExpressionMock = mock(DynamoDBScanExpression.class);
		DynamoDBMapper dynamoDBMapperMock = mock(DynamoDBMapper.class);
		@SuppressWarnings("unchecked")
		ScanResultPage<Product> scanPageMock = mock(ScanResultPage.class);
		when(dynamoDBMapperMock.scanPage(Product.class, scanExpressionMock)).thenReturn(scanPageMock);
		
		List<Product> productList = new ArrayList<>();
		List<String> videoLinks = new ArrayList<>();
		videoLinks.add("https://www.youtube.com/watch?v=EkJMdoFuTrc");
		List<String> productImages = new ArrayList<>();
		productImages.add("https://cdn.myimaginestore.com/media/catalog/product/cache/7/image/745x/602f0fa2c1f0d1ba5e241f914e856ff9/i/p/iphone-12-2020.jpg");
		productList.add(new Product("pid","vid","iphone 13" ,"Smoother Experience" , 150000.0, "All" , 100, "https://images-eu.ssl-images-amazon.com/images/I/E10sDDhm75S.pdf",videoLinks , productImages));
		Map<String,Object> responseBody=new HashMap<>();
		responseBody.put("data", productList);
		responseBody.put("hasNext", false);
		when(scanPageMock.getResults()).thenReturn(productList);
		when(scanPageMock.getLastEvaluatedKey()).thenReturn(null);
		
		ProductRepositoryImpl prodRepo = new ProductRepositoryImpl(dynamoDBMapperMock) {
			@Override
			protected DynamoDBScanExpression createDynamoDBScanFilterExpression(String categoryExpression,HashMap<String,AttributeValue> eav) {
				return scanExpressionMock;
			}
		};
		assertEquals(prodRepo.filter(1, "All", 0, 1000000),responseBody);
	}
	
	@Test
	void filterTestWithCategoryOther() {
		DynamoDBScanExpression scanExpressionMock = mock(DynamoDBScanExpression.class);
		DynamoDBMapper dynamoDBMapperMock = mock(DynamoDBMapper.class);
		@SuppressWarnings("unchecked")
		ScanResultPage<Product> scanPageMock = mock(ScanResultPage.class);
		when(dynamoDBMapperMock.scanPage(Product.class, scanExpressionMock)).thenReturn(scanPageMock);
		
		List<Product> productList = new ArrayList<>();
		List<String> videoLinks = new ArrayList<>();
		videoLinks.add("https://www.youtube.com/watch?v=EkJMdoFuTrc");
		List<String> productImages = new ArrayList<>();
		productImages.add("https://cdn.myimaginestore.com/media/catalog/product/cache/7/image/745x/602f0fa2c1f0d1ba5e241f914e856ff9/i/p/iphone-12-2020.jpg");
		productList.add(new Product("pid","vid","iphone 13" ,"Smoother Experience" , 150000.0, "Mobile" , 100, "https://images-eu.ssl-images-amazon.com/images/I/E10sDDhm75S.pdf",videoLinks , productImages));
		Map<String,Object> responseBody=new HashMap<>();
		responseBody.put("data", productList);
		responseBody.put("hasNext", false);
		when(scanPageMock.getResults()).thenReturn(productList);
		when(scanPageMock.getLastEvaluatedKey()).thenReturn(null);
		ProductRepositoryImpl prodRepo = new ProductRepositoryImpl(dynamoDBMapperMock) {
			@Override
			protected DynamoDBScanExpression createDynamoDBScanFilterExpression(String categoryExpression,HashMap<String,AttributeValue> eav) {
				return scanExpressionMock;
			}
		};
		assertEquals(prodRepo.filter(1, "Mobile", 0, 1000000),responseBody);
	}

}
