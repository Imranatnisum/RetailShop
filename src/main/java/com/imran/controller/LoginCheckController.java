package com.imran.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.Customer;
import com.imran.Item;
import com.imran.service.ItemPriceService;
import com.imran.service.LoginpayService;
import com.imran.service.RegisterService;

@Controller
public class LoginCheckController {
	
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	ItemPriceService itemPriceService;
	
	@Autowired
	LoginpayService loginpayService;
	
	@RequestMapping(value="/logincheck", method=RequestMethod.GET)
	public String loginController(Model model, @RequestParam(value="email") String email)
	{
		
		Customer customer=registerService.getCustomer(email);
		
		
		List<Item> cartList=customer.getCartList();
		
		
		Double sumCartPrice=0.0;
		
		for(Item item:cartList)
		{
			sumCartPrice +=item.getPrice();
			   
		}
		
		model.addAttribute("customer", customer);
		
		model.addAttribute("sumCartPrice", sumCartPrice);
		
		
		
		return "logincheckout";
		
		
	}
	
	
	
	@RequestMapping(value="/loginpaycheck", method=RequestMethod.GET)
	public String loginPatController(Model model, @RequestParam(value="checkbox",required = false) String[] itemNames,@RequestParam(value="email") String email)
	{
		
		
		
		
		if(itemNames==null||itemNames.length==0)
		{
			
			Customer customer=registerService.getCustomer(email);
			
			List<Item> cartList=customer.getCartList();
			
			
			Double sumCartPrice=0.0;
			
			for(Item item:cartList)
			{
				sumCartPrice +=item.getPrice();
				   
			}
			
			model.addAttribute("customer", customer);
			
			model.addAttribute("sumCartPrice", sumCartPrice);
			
			
			
			return "logincheckoutempty";
		}
		
		Customer customer=registerService.getCustomer(email);
		
		List<Item> itemList=new ArrayList<Item>();
		
		 double topay=0.0;
		
		  for(String itemName:itemNames)
		  {
			  Item item=itemPriceService.findItemByName(itemName);
			  
			  topay +=item.getPrice();
		
			  
			  
			  itemList.add(item);
			   
		  }
		  
		    customer.setItemList(itemList);
		    
		    
		    
		    loginpayService.saveCustomer(customer);
		    
		    
		  model.addAttribute("customer", customer);
		  
		  model.addAttribute("topay", topay);
		  
		  
		   
		   
		  
		
		
		
		  return "pay";
		
		
	}

}
