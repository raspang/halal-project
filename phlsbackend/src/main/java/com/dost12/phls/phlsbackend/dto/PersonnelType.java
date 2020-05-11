package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;

public enum PersonnelType implements Serializable{
	ANALYST("ANALYST"),
	MANAGER("MANAGER"),
	DIRECTOR("DIRECTOR");
	
	String userProfileType;
	
	private PersonnelType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
