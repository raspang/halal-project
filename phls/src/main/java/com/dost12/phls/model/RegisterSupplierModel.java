package com.dost12.phls.model;

import java.io.Serializable;

import com.dost12.phls.phlsbackend.dto.Address;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;

public class RegisterSupplierModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Supplier supplier;
	private User user;
	private Address billing;

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
		
}
