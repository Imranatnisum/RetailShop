




package com.imran.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.imran.RetailShopApplication;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetailShopApplication.class)
@WebAppConfiguration
public class RegisterControllerTest {
	
	
	@Autowired
	  private WebApplicationContext webContext;
	  private MockMvc mockMvc;
	   
	  
	  
	  @Before
	  public void setupMockMvc() {
	    mockMvc = MockMvcBuilders
	        .webAppContextSetup(webContext)
	        .build();
	    
	  }
	  
	  
	  @Test
	  public void loginPageTest() throws Exception
	  {
		  
		  mockMvc.perform(post("/login")
			       .contentType(MediaType.APPLICATION_FORM_URLENCODED)
			       .param("email", "ahmad@gmail.com")
			       .param("password", "abc"))     
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("customer"))
			.andExpect(view().name("login"));

		  
	  }

}
