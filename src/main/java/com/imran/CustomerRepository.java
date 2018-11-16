package com.imran;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer,String> {
	
	
	/*public Book findBookById(int id);
	
	*/
	
	
	@Query(value="{}", fields="{eamil : 1, _id : 0}")
	List<Customer> findEmailAndExcludeId();
	
	
	public Customer findCustomerByEmail(String email);
	

}
