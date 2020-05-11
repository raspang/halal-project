package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ingredient")
public class Ingredient  implements Serializable{

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
	private boolean active;
	
	private String name;
	private Boolean critical;
	private String description;
	
	@Transient
	private String nameDesc;
	
	
	
	public Ingredient() {
		super();
		active = true;
		critical = false;
		createdOn = new Date();
		updateOn = new Date();
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getCritical() {
		return critical;
	}
	public void setCritical(Boolean critical) {
		this.critical = critical;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getNameDesc() {
		if(!critical)
			return name+" - Safe";
		return name;
	}
	public void setNameDesc(String nameDesc) {
		this.nameDesc = nameDesc;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", createdOn=" + createdOn + ", updateOn=" + updateOn + ", active=" + active
				+ ", name=" + name + ", critical=" + critical + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
	
	
}
