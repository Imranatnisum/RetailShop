package com.imran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.Item;
import com.imran.dao.ItemPriceDao;


@Service
public class ItemPriceService {
	
	
	@Autowired
	ItemPriceDao itemPriceDao;
	
	
	public Item findItemByName(String name)
	{
		 
		Item item=itemPriceDao.itemByName(name);
		
		
		return item;
		
		
	}
	
	public List<Item> findItems()
	{
		return itemPriceDao.findItems();
	}

}
