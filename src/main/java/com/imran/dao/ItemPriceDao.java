package com.imran.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imran.Item;
import com.imran.ItemRepository;


@Repository
public class ItemPriceDao {
	
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item itemByName(String name)
	{
		
		Item item=itemRepository.findItemByName(name);
		
		return item;
		  
	}

}
