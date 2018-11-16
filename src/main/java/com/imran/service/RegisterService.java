package com.imran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.Customer;
import com.imran.dao.RegisterDao;


@Service
public class RegisterService {
	
	
	@Autowired
	RegisterDao registerDao;
	
	
	public String register(Customer customer)
	{
		
		
		
		
		
		
		String status=registerDao.register(customer);
		
		
		return status;
	}
	
	
	public String login(String email,char pass[])
	{
		
		
		
		
		
		
		String status=registerDao.login(email,pass);
		
		
		return status;
	}
	
	public Customer getCustomer(String email)
	{
		
		
		
		
		
		
		Customer customer=registerDao.getCustomer(email);
		
		
		return customer;
	}

}
