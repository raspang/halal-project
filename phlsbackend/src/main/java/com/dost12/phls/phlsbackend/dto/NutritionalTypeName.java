package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;

public enum NutritionalTypeName implements Serializable {
	
	CALORIES("Calories"),
	CALORIES_FAT("Calories from Fat"),
	TOTAL_FAT("Total Fat"),

	SODIUM("Sodium"),

	TOTAL_CARBOHYDRATES("Total Carbohydrates"),

	PROTEIN("Protein"),
	SUGAR("Sugar"),
	VITAMIN_C("Vitamin C");


	String nutritionalTypeName;

	private NutritionalTypeName(String nutritionalTypeName){
			this.nutritionalTypeName = nutritionalTypeName;
	}

	public String getNutritionalTypeName() {
		return nutritionalTypeName;
	}




}
