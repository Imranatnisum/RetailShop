package com.imran.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imran.Customer;
import com.imran.CustomerRepository;


@Repository
public class LoginPayDao {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public String saveCustomer(Customer customer)
	{
		
		Customer customertemp=customerRepository.save(customer);
		
		if(customertemp==customer)
		{
			return "saved"; 
		}
		
	
		 return "not saved";
		
		
	}
	
	

}
