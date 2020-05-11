package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;

public enum ApplicationRegistrationType implements Serializable{

	FOOD_SERVICE("Food Service"),
	PRODUCT_SERVICE("Product Service");
	
	String typeOfAppSerivce;

	private ApplicationRegistrationType(String typeOfAppSerivce) {
		this.typeOfAppSerivce = typeOfAppSerivce;
	}

	public String getTypeOfAppSerivce() {
		return typeOfAppSerivce;
	}

	public void setTypeOfAppSerivce(String typeOfAppSerivce) {
		this.typeOfAppSerivce = typeOfAppSerivce;
	}
	
	
	}
