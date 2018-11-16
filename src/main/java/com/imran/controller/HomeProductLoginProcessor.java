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
import com.imran.CustomerRepository;
import com.imran.Item;
import com.imran.service.ItemPriceService;
import com.imran.service.LoginpayService;
import com.imran.service.RegisterService;


@Controller
public class HomeProductLoginProcessor {
	
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	ItemPriceService itemPriceService;
	
	@Autowired
	LoginpayService loginpayService;
	
	@RequestMapping(value="/loginprocessor",method=RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="email") String email, 
			@RequestParam(value="password") String password,
			@RequestParam(value="toItem") String toItem 
			
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
               
               
               Item item=itemPriceService.findItemByName(toItem);
               
               
               /*Item item1=new Item();
               
               item1.setName("one");
               
               item1.setPrice(1);

          Item item2=new Item();
               
               item2.setName("two");
               
               item2.setPrice(2);
               
               
               List<Item> cart=new ArrayList<Item>();
               
               cart.add(item1);
               
               cart.add(item2);
               
               
             customer.setCartList(cart);*/
              
               if(customer.getCartList()!=null)
               {  customer.getCartList().add(item);
               
               
               }
               
               else
               {
            	   
            	   List<Item> cart=new ArrayList<Item>();
            	     
            	      cart.add(item);
            	      
            	      customer.setCartList(cart);
               }
             
             customer.setLogged(true);
              
             loginpayService.saveCustomer(customer);
               
               
               model.addAttribute("customer", customer);
               
               
            
               
               
			   
			   return "loginhome";
			}
		   
		   else return "login";
		
		
		  
		
	}
	

}
