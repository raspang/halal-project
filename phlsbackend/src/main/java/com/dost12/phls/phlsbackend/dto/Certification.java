package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="certification")
public class Certification implements Serializable {

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
	
	@Column(name="halal_certificate_no")
	private String halalCertificateNo;
	
	private String title;
	
	private String description;
	
	private boolean local;
	
	private String address;
	
	@Column(name="is_active")
	private boolean isActive;
	@Transient
	private String display;
	
	

/*	@Transient
	@OneToOne(mappedBy = "certification", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private OnsiteAssessment onsiteAssessment;*/
	
/*	@Transient
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "certification", cascade = CascadeType.ALL)
	private List<CertificationDetail> certificationDetails;*/

	public Certification() {
		super();
		this.halalCertificateNo = "HC-" + UUID.randomUUID().toString().substring(30).toUpperCase();	
		isActive = true;
		address = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getHalalCertificateNo() {
		return halalCertificateNo;
	}

	public void setHalalCertificateNo(String halalCertificateNo) {
		this.halalCertificateNo = halalCertificateNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

/*	public OnsiteAssessment getOnsiteAssessment() {
		return onsiteAssessment;
	}

	public void setOnsiteAssessment(OnsiteAssessment onsiteAssessment) {
		this.onsiteAssessment = onsiteAssessment;
	}*/
	
	

/*	public List<CertificationDetail> getCertificationDetails() {
		return certificationDetails;
	}

	public void setCertificationDetails(List<CertificationDetail> certificationDetails) {
		this.certificationDetails = certificationDetails;
	}*/
	

	public String getDisplay() {
		return halalCertificateNo+" - "+title;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((halalCertificateNo == null) ? 0 : halalCertificateNo.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Certification other = (Certification) obj;
		if (halalCertificateNo == null) {
			if (other.halalCertificateNo != null)
				return false;
		} else if (!halalCertificateNo.equals(other.halalCertificateNo))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
