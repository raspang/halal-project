package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "certification_detail")
public class CertificationDetail  implements Serializable{
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
	
	@Column(name="update_on")
	private Date updateOn;
	
	@Column(name="is_active")
	private Boolean active;	

	@OneToOne 
	@JoinColumn(name="certificate_id")	
	private Certification certification;
	
	@OneToOne 
	@JoinColumn(name="onsite_id")		
	private OnsiteAssessment onsiteAssessment;
	
	@Column(name="valid_until")
	private Date valid; 


	
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}

	public OnsiteAssessment getOnsiteAssessment() {
		return onsiteAssessment;
	}

	public void setOnsiteAssessment(OnsiteAssessment onsiteAssessment) {
		this.onsiteAssessment = onsiteAssessment;
	}

	public Date getValid() {
		return valid;
	}

	public void setValid(Date valid) {
		this.valid = valid;
	}

	
}
