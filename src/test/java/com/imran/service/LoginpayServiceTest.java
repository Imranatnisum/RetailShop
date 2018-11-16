package com.imran.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.imran.Customer;
import com.imran.CustomerRepository;
import com.imran.RetailShopApplication;
import com.imran.dao.LoginPayDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetailShopApplication.class)
@WebAppConfiguration
public class LoginpayServiceTest {
	
	
	@Autowired
	LoginpayService loginpayService;
	
	 
	@Mock
	LoginPayDao loginPayDao;
	
	
	
	@Test
	public void saveCustomerTest()throws Exception
	{
		
		  Customer customer=new Customer();
		
		 when(loginPayDao.saveCustomer(customer)).thenReturn("saved");
		 
		 
		String status= loginpayService.saveCustomer(customer);
		
		assertEquals(status,"saved");
		
	}

}
