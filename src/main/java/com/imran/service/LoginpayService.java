package com.imran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.Customer;
import com.imran.CustomerRepository;
import com.imran.dao.LoginPayDao;

@Service
public class LoginpayService {
	
	
	
	
	 
	@Autowired
	LoginPayDao loginPayDao;
	
	
	public String saveCustomer(Customer customer)
	{
		
	
		String status=loginPayDao.saveCustomer(customer);		
		return status;
	}
	
	

}
