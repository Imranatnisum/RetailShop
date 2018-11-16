package com.imran;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ItemRepository extends MongoRepository<Item,String> {
	
	
	public Item findItemByName(String name);
	
	
	

}
