package com.dost12.phls.model;

import java.io.Serializable;
import java.util.List;

import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.User;

public class AssessmentModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private OnsiteAddress address;
	private OnsiteAssessment onsiteAssessment;
	private List<Product> products;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OnsiteAddress getAddress() {
		return address;
	}
	public void setAddress(OnsiteAddress address) {
		this.address = address;
	}
	public OnsiteAssessment getOnsiteAssessment() {
		return onsiteAssessment;
	}
	public void setOnsiteAssessment(OnsiteAssessment onsiteAssessment) {
		this.onsiteAssessment = onsiteAssessment;
	}
	
	
	
	
}
