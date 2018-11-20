package com.imran.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imran.Address;
import com.imran.Customer;
import com.imran.CustomerRepository;
import com.imran.Item;
import com.imran.service.ItemPriceService;
import com.imran.service.LoginpayService;
import com.imran.service.RegisterService;

@Controller
public class RegisterController {
	
	
	  @Autowired
	  Customer customer;
	  
	  @Autowired
	  Address address;
	  
	  
	  @Autowired
	  RegisterService registerService;
	  
	 @Autowired
	 LoginpayService loginpayService;
	 
	 @Autowired
		ItemPriceService itemPriceService;
	 
	 
	 
	
	
	
	char pass[]=new char[] {'j','k','l'};	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@RequestParam(value="name") String name,
			@RequestParam(value="email") String email, 
			@RequestParam(value="password") String password,
			@RequestParam(value="location") String houseNumber,
			
			@RequestParam(value="city", defaultValue="Hyderabad") String city,
			@RequestParam(value="state", defaultValue="telangan") String state,
			@RequestParam(value="country", defaultValue="india") String country
		
			
			)
	{
		
		
		    address.setCity(city);
		    address.setCountry(country);
		    address.setHouseNumber(houseNumber);
		    address.setState(state);
		   
		    
		   
		    customer.setAddress(address);
		    
		    customer.setEmail(email);
		    
		    char pass[]=new char[password.length()];
		    
		    for(int i=0;i<password.length();i++)
		    {
		    	pass[i]=password.charAt(i);
		    }
		    
		    customer.setPassword(pass);
		    
		    customer.setName(name);
		    
		    
		
		   String status= registerService.register(customer);
		   
		   
		   if(status.equals("saved")) return "success";
		   
		   else return "exist";
		
		
		  
		
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="email") String email, 
			@RequestParam(value="password") String password
			
			)
	{
		
		
		   
		    
		   
		   
		    
		    char pass[]=new char[password.length()];
		    
		    for(int i=0;i<password.length();i++)
		    {
		    	pass[i]=password.charAt(i);
		    }
		    
		   
		    
		    
		
		   String status= registerService.login(email,pass);
		   
		   
		   if(status.equals("ok"))
			{
               Customer customer=registerService.getCustomer(email);
               
               
              /* Item item1=new Item();
               
               item1.setName("one");
               
               item1.setPrice(1);

          Item item2=new Item();
               
               item2.setName("two");
               
               item2.setPrice(2);
               
               
               List<Item> cart=new ArrayList<Item>();
               
               cart.add(item1);
               
               cart.add(item2);
               
               
               if(customer.getCartList()!=null)
               {  customer.getCartList().add(item);
               
               
               }
               
             customer.getCartList().addAll(cart);*/
             
             customer.setLogged(true);
             
     	    List<Item> allItems=itemPriceService.findItems();
             
              
             loginpayService.saveCustomer(customer);
               
               
               model.addAttribute("customer", customer);
               
               model.addAttribute("allitems",allItems);
            
               
               
			   
			   return "loginhome";
			}
		   
		   else return "login";
		
		
		  
		
	}
	
	
	
	
	
	
	
	

}
