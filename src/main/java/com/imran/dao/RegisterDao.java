package com.imran.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.imran.Customer;
import com.imran.CustomerRepository;


@Repository
public class RegisterDao {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	public String register(Customer customer)
	{
		
		
		
		Query auery=new Query();
		
		
		auery.fields().include("email");
		List<Customer> custEmailList=mongoTemplate.find(auery, Customer.class); 
		
		
		
		for(Customer custemp:custEmailList)
		{
			
			    if(customer.getEmail().equals(custemp.getEmail()))
			    {
			    	     return "exist";
			    }
			    
		}
		
		
		
		customerRepository.save(customer);
		
		
		return "saved";
		
		
		
		
	}
	
	
	public String login(String email,char pass[])
	{
		
		
		
		Query auery=new Query();
		
		
		auery.fields().include("email").include("password");
		
		List<Customer> custEmailList=mongoTemplate.find(auery, Customer.class); 
		
		
		
		for(Customer custemp:custEmailList)
		{
			
			    if(email.equals(custemp.getEmail()) && Arrays.equals(pass, custemp.getPassword()))
			    {
			     	custemp.setLogged(true);
			    	     
			    	     return "ok";
			    }
			    
			    
			    
		}
		
		
		
		return "wrong";
		
		
		
		
	}
	
	
	public Customer getCustomer(String email)
	{
		
		
          Customer customer=customerRepository.findCustomerByEmail(email);
		
		return customer;
		
		
		
	}


}
