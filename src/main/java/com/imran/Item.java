package com.imran;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "Item")
@Component
public class Item {
	
	String name;
	
	double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public boolean equals(Object obj)
	   {
		    if(obj==null) return false;
		    
		    if(obj.getClass().getName()!=this.getClass().getName())
		    	return false;
		    
		    
		    Item item=null;
		    
		    if(obj instanceof Item)
		    {
		    	item=(Item)obj;
		    }
		    
		   if(item.getName().equals(this.getName())) return true;
		    
		    else return false;
		    
	   }
	
	
	@Override
	public int hashCode()
	{
		return 1;
	}

	
	
   
}
