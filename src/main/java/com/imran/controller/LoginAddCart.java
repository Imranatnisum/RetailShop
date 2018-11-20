package com.imran.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.Customer;
import com.imran.Item;
import com.imran.service.ItemPriceService;
import com.imran.service.LoginpayService;
import com.imran.service.RegisterService;

@Controller
public class LoginAddCart {

	
	
	@Autowired
	RegisterService  registerService;
	
	@Autowired
	ItemPriceService itemPriceService;
	
	@Autowired
	LoginpayService loginpayService;
	
	
	@RequestMapping("/loginAddCart")
	public String loginAddCart(Model model, @RequestParam(value="checkbox") String[] itemNames,@RequestParam(value="email") String email)
	{
		
		
		
		Customer customer=registerService.getCustomer(email);
		
		List<Item> itemList=new ArrayList<Item>();
		
		 double topay=0.0;
		
		  for(String itemName:itemNames)
		  {
			  Item item=itemPriceService.findItemByName(itemName);
			  
			  topay +=item.getPrice();
		 
			  
			  
			  itemList.add(item);
			   
		  }
		  
		  if(customer.getCartList()!=null)
          {  
			  
			  customer.getCartList().addAll(itemList);
          
          
          }
		  
		  else
		  {
			  customer.setCartList(itemList);
		  }
		  
		  		    
		    
		    
		    loginpayService.saveCustomer(customer);
		    
		    List<Item> allItems=itemPriceService.findItems();
		    
		    
		  model.addAttribute("customer", customer);
		
		  
		  
		   return "loginhome";
		   
	
	
}
	
	
}
