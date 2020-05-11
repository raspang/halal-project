package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "on_site_assessment")
public class OnsiteAssessment implements Serializable{
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
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name="created_on")
	@JsonIgnore
	private LocalDate createdOn;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name="updated_on")
	@JsonIgnore
	private LocalDate updateOn;
	
	@Column(name="is_active")
	@JsonIgnore
	private Boolean active;	

	@OneToOne
	@JoinColumn(name="supplier_id")	
	private Supplier supplier;	

	@Transient
	private int supplierId;
	
	@OneToOne
	@JoinColumn(name="certification_id")	
	private Certification certification;
	
	@Transient
	private int certificationId;
	

	@Column(name="status")
	private int status;
	
	@Column(name="status_description")
	private String statusDescription;
	
	
	@DateTimeFormat(pattern="mm/dd/yyyy") 
	@Column(name="validity")
	@JsonIgnore
	private LocalDate valid;
	
	@Transient
	private String validStr;
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "onsiteAssessment", cascade = CascadeType.ALL)
	private List<CertificationDetail> certificationDetails;
	

	
	public OnsiteAssessment() {
		super();
		active = true;
		createdOn = LocalDate.now();
		updateOn = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(LocalDate updateOn) {
		this.updateOn = updateOn;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}

	public LocalDate getValid() {
		return valid;
	}

	public void setValid(LocalDate valid) {
		this.valid = valid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	} 
	
	public String getUpdateOnStr() {
		return updateOn.toString();
	}
	
	public String getCreatedOnStr() {
		return createdOn.toString();
	}

	public List<CertificationDetail> getCertificationDetails() {
		return certificationDetails;
	}

	public void setCertificationDetails(List<CertificationDetail> certificationDetails) {
		this.certificationDetails = certificationDetails;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getValidStr() {
		if(valid != null)
			return valid.toString();
		return validStr;
	}

	public void setValidStr(String validStr) {
		this.validStr = validStr;
	}
	
	
}
