package com.imran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.Item;
import com.imran.service.ItemPriceService;


@Controller
public class HomeProductCheckController {
	
	
	@Autowired
	ItemPriceService itemPriceService;
	
	
	@RequestMapping(value="/homeproduct",method=RequestMethod.GET)
	public String homeUser(Model model,@RequestParam(value="item") String item)
	{
		
		
		
		 
		 
		 model.addAttribute("item", item);
		 
		 
		 
		  
		
		return "LoginPageItem";
	}

}
