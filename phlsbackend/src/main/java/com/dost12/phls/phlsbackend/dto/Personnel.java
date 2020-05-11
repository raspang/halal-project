package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "personnel")
public class Personnel  implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "incharge_for")
	private String incharge;	
	
	@Column(name = "position")
	private String position = PersonnelType.ANALYST.getUserProfileType();
	
	@Column(name = "is_active")
	private Boolean active;
	
	@Transient
	private String name;
	
	@Transient
	private String name2;
	
	
	public Personnel() {
		this.active = true;
	}
	
	

	public String getName() {
		return lastName+", "+firstName+" "+middleName;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	

	public String getIncharge() {
		return incharge;
	}



	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}



	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}



	public String getName2() {
		String middle = middleName.length() > 0 ? String.valueOf(middleName.charAt(0)) : "";
		return  firstName+" "+middle+". "+lastName;
	}



	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	
	
}
