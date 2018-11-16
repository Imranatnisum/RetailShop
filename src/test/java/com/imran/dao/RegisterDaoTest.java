package com.imran.dao;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.imran.Customer;
import com.imran.CustomerRepository;
import com.imran.RetailShopApplication;
import com.imran.dao.LoginPayDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetailShopApplication.class)
@WebAppConfiguration
public class RegisterDaoTest {
	
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	MongoTemplate mongoTemplate;
	
	@Autowired
	RegisterDao registerDao;
	
	@Test
	public void registerTest()throws Exception
	{
		
		
		Customer customer=new Customer();
		
		customer.setEmail("abc@gmail.com");
		
		List<Customer> custList=new ArrayList<Customer>();
		
		
		custList.add(customer);
		
		Query query=new Query();
		
		
		when(mongoTemplate.find(query, Customer.class)).thenReturn(custList);
		
		
	//	Customer customer1=new Customer();
		
	//	customer1.setEmail("xyz@gmail.com");
		
		String status=registerDao.register(customer);
		
		
		assertEquals("exist",status);
		
		
		
		
		
		  
		
	}

}
