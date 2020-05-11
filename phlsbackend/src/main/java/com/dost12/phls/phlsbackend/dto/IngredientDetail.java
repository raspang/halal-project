package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingredient_detail")
public class IngredientDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Private fields
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="created_on")
	private Date createdOn;
	
	
	@Column(name="updated_on")
	private Date updateOn;

	@Column(name="is_active")
	private Boolean active;
	
	private Boolean mark;

	@Column(name="mark_description")
	private String markDescription;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_id")
	
/*	@Column(name = "ingredient_id")
	@JsonIgnore*/
	private Ingredient ingredient;
	
	@Transient
	private int ingredientId;
	
	@Transient
	private int productId;
	
	
/*	@Transient
	private Ingredient ingredientObj;*/
	
	@Transient
	private String ingredientName;

	public IngredientDetail() {
		super();
		active = true;
		mark = false;
		createdOn = new Date();
		updateOn = new Date();
		markDescription = ""; 
		productId = 0;
		ingredientId = 0;
		
	}

	
	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}


	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getMark() {
		return mark;
	}

	public void setMark(Boolean mark) {
		this.mark = mark;
	}

	public String getMarkDescription() {
		return markDescription;
	}

	public void setMarkDescription(String markDescription) {
		this.markDescription = markDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getIngredientId() {
		return ingredientId;
	}


	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

/*	public Integer getIngredient() {
		return ingredient;
	}

	public void setIngredient(Integer ingredient) {
		this.ingredient = ingredient;
	}*/

/*	public Ingredient getIngredientObj() {
		return ingredientObj;
	}

	public void setIngredientObj(Ingredient ingredientObj) {
		this.ingredientObj = ingredientObj;
	}*/
	

	
}
