package com.imran;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "Customer")
@Component
public class Customer implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String name;
	
private String email;
	
	private char[] password;
	
	
	
	
	
	private List<Item> cartList;
	
	private List<Item> itemList;
	
	
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	private boolean logged;
	
	
	private Address address;
	
	

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public List<Item> getCartList() {
		return cartList;
	}

	public void setCartList(List<Item> cartList) {
		this.cartList = cartList;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	
	
	

}
