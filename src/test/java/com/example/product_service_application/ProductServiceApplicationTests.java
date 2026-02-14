package com.example.product_service_application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {

	@Container //Defines docker container
	// runs a real mongodb
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");


	@Test
	void contextLoads() {
	}

}
