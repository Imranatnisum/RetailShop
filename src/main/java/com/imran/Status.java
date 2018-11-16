package com.imran;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

//@Document(collection = "Status")
//@Component
@Component
public class Status {
	
	private String cid;
	
	private boolean status;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
