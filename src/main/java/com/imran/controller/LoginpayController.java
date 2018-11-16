package com.imran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.Customer;
import com.imran.Item;
import com.imran.service.LoginpayService;
import com.imran.service.RegisterService;

@Controller
public class LoginpayController {
	
	@Autowired
	RegisterService registerService;
	
	@Autowired 
	LoginpayService loginpayService;
	
	@RequestMapping("/loginpay")
	public String  loginpay(@RequestParam(value="email") String email,Model model)
	{
		
		
		
		Customer customer=registerService.getCustomer(email);
		
		
		List<Item>  cartList=customer.getCartList();
		
		
		List<Item>  itemList=customer.getItemList();
		
		
		cartList.removeAll(itemList);
		
		 model.addAttribute("customer", customer);
		 
		 model.addAttribute("itemList", itemList);
		
		List<Item>  toRemoveList=null;
		
		customer.setItemList(toRemoveList);
	    
		
		loginpayService.saveCustomer(customer);
		
		
		
		 
		 
		
		
		
		return "paysuccess";
		
	}

}
