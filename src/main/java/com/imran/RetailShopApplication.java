package com.imran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@SpringBootApplication
public class RetailShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailShopApplication.class, args);
	}
	
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "test");
	}

	 @Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}
}
