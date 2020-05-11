package com.dost12.phls.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Shipment;

public class ProductModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Product product;
    private List<IngredientDetail> ingredientDetails;
    private List<Ingredient> ingredients;
	private List<Shipment> shipments;
	private List<Certification> certifications;


	public ProductModel() {
		super();
		ingredientDetails = new ArrayList<>();
		shipments = new ArrayList<>(); 
		certifications = new ArrayList<>();
		ingredientDetails = new ArrayList<>();
		ingredients = new ArrayList<>();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<IngredientDetail> getIngredientDetails() {
		return ingredientDetails;
	}

	public void setIngredientDetails(List<IngredientDetail> ingredientDetails) {
		this.ingredientDetails = ingredientDetails;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
