package com.dost12.phls.model;

import java.io.Serializable;

import com.dost12.phls.phlsbackend.dto.Address;
import com.dost12.phls.phlsbackend.dto.User;
import com.dost12.phls.phlsbackend.dto.Userlab;

public class RegisterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Userlab userlab;
	private Address billing;
	
	public Userlab getUserlab() {
		return userlab;
	}
	public void setUserlab(Userlab userlab) {
		this.userlab = userlab;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
		
}
