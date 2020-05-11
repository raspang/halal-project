package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "on_site_address")
public class OnsiteAddress implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter address line one!")
	@Column(name = "address_line_one")
	private String addressLineOne;
	
	
	@Column(name = "address_line_two")
	private String addressLineTwo;
	
	@NotBlank(message = "Please enter City!")	
	private String city;
	
	
	@NotBlank(message = "Please enter State!")	
	private String state;
	
	@NotBlank(message = "Please enter country!")	
	private String country;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "supplier_id", nullable=false)
	private int supplierId;

	private Boolean onsite;
	

	@Column(name = "is_active")
	private Boolean active;
	
	
	
	public OnsiteAddress() {
		super();
		active = true;
		onsite = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public Boolean getOnsite() {
		return onsite;
	}

	public void setOnsite(Boolean onsite) {
		this.onsite = onsite;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	
	
}
