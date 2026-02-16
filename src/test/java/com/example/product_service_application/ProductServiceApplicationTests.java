package com.example.product_service_application;

import com.example.product_service_application.dto.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
//@RequiredArgsConstructor
class ProductServiceApplicationTests {

	@Container //Defines docker container
	// runs a real mongodb
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private  MockMvc mockMvc;

	ObjectMapper mapper = new ObjectMapper();

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		String connectionString = mongoDBContainer.getConnectionString();
		System.out.println(connectionString);
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getConnectionString);
	}



	@Test
	void shouldCreateProduct() throws Exception {
		var requestBody = getProductRequest();
		var requestBodyString = mapper.writeValueAsString(requestBody);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyString))
				.andExpect(status().isCreated());


	}




	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("Iphone 13")
				.description("Description for Iphone 13")
				.price(BigDecimal.valueOf(1220))
				.build();
	}

}
