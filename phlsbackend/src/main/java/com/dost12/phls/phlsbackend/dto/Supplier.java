package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name ="created_on")
	@JsonIgnore
	private LocalDate createdOn;	
	
	@Column(name ="updated_on")
	@JsonIgnore
	private LocalDate updatedOn;	
	
	@NotEmpty
	@Column(name="code", unique=true, nullable=false)
	private String code;

	@Column(name ="is_active")
	private Boolean active;	
	
	@Column(name ="is_enable")
	private Boolean enable;	

	@NotBlank(message = "Please enter name Of Establishment.")	
	@Column(name ="name_of_establishment")
	private String nameOfEstablishment;

	@NotBlank(message = "Please enter the Address")
	@JsonIgnore
	private String addressOfEstablishment;
	
	//private String owner;
	
	@Column(name ="tel_no")
	private String telNo;

	@JsonIgnore
	private String fax;
	
	@Column(name="person_involved")
	@NotBlank(message = "*Person Involved")	
	private String personInvolved; 
	
	private String position;

	@NotBlank(message = "*Please provide an email")	
	private String email;
	
	@JsonIgnore
	private String website;
	
	@Column(name="reason")
	@JsonIgnore
	private String reason;

	@Column(name="num_of_employees")
	@JsonIgnore
	private int numOfEmployees;

	@Column(name="production_area_size")
	@JsonIgnore
	private String productionAreaSize;

	@Column(name="indoor_area")
	@JsonIgnore
	private String indoorArea;

	@Column(name="open_area")
	@JsonIgnore
	private String openArea;

	@Column(name="num_raw_material")
	@JsonIgnore
	private String numOfRawMaterial;

	//
	@Column(name="num_finished_product")
	@JsonIgnore
	private String numProductsWarehouses;
	//
	@Column(name="production_capacity")
	@JsonIgnore
	private String productionCapacity;
	
	@Column(name="production_lines")
	@JsonIgnore
	private String productionLines;
	//
	@Column(name="custom_production")
	@JsonIgnore
	private String customProduction;

	//
	@Column(name="product_brands")
	@JsonIgnore
	private String productBrands;
	
	@Column(name="product_varieties")
	@JsonIgnore
	private String productVarieties;
	
	
	@Column(name="none_halal_products")
	@JsonIgnore
	private String productNotHalal;

	//
	@Column(name="names_of_raw_materials")
	@JsonIgnore
	private String namesOfRawMaterials;	
	
	//
	@Column(name="names_of_suppliers")
	@JsonIgnore
	private String namesOfSuppliers;	
	
	//
	@Column(name="products_process")
	@JsonIgnore
	private String productsProcess;	
	
	
	// eccommerse - account
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	// phls - account
	@OneToOne
	@JoinColumn(name="created_by_id")
	private Userlab createdBy;
	
	
	@Column 
	private String typeOfApplication;
	
	@Transient
	@JsonIgnore
	private MultipartFile file;
	
	@Transient
	@JsonIgnore
	private List<Product> products;
	
	public Supplier() {
		super();
		
		active = true;
		enable = false;
		
		createdOn = LocalDate.now();
		updatedOn = LocalDate.now();
		
		this.code = "SME" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
		this.typeOfApplication = ApplicationRegistrationType.PRODUCT_SERVICE.getTypeOfAppSerivce();

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfEstablishment() {
		return nameOfEstablishment;
	}
	public void setNameOfEstablishment(String nameOfEstablishment) {
		this.nameOfEstablishment = nameOfEstablishment;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}


	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getPersonInvolved() {
		return personInvolved;
	}

	public void setPersonInvolved(String personInvolved) {
		this.personInvolved = personInvolved;
	}


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}



	public String getProductionAreaSize() {
		return productionAreaSize;
	}

	public void setProductionAreaSize(String productionAreaSize) {
		this.productionAreaSize = productionAreaSize;
	}

	public String getIndoorArea() {
		return indoorArea;
	}

	public void setIndoorArea(String indoorArea) {
		this.indoorArea = indoorArea;
	}

	public String getOpenArea() {
		return openArea;
	}

	public void setOpenArea(String openArea) {
		this.openArea = openArea;
	}

	public String getNumOfRawMaterial() {
		return numOfRawMaterial;
	}

	public void setNumOfRawMaterial(String numOfRawMaterial) {
		this.numOfRawMaterial = numOfRawMaterial;
	}

	public String getProductionLines() {
		return productionLines;
	}

	public void setProductionLines(String productionLines) {
		this.productionLines = productionLines;
	}

	public String getProductNotHalal() {
		return productNotHalal;
	}

	public void setProductNotHalal(String productNotHalal) {
		this.productNotHalal = productNotHalal;
	}

	public String getNumProductsWarehouses() {
		return numProductsWarehouses;
	}

	public void setNumProductsWarehouses(String numProductsWarehouses) {
		this.numProductsWarehouses = numProductsWarehouses;
	}

	public String getProductionCapacity() {
		return productionCapacity;
	}

	public void setProductionCapacity(String productionCapacity) {
		this.productionCapacity = productionCapacity;
	}

	public String getCustomProduction() {
		return customProduction;
	}

	public void setCustomProduction(String customProduction) {
		this.customProduction = customProduction;
	}

	public String getProductBrands() {
		return productBrands;
	}

	public void setProductBrands(String productBrands) {
		this.productBrands = productBrands;
	}

	public String getNamesOfRawMaterials() {
		return namesOfRawMaterials;
	}

	public void setNamesOfRawMaterials(String namesOfRawMaterials) {
		this.namesOfRawMaterials = namesOfRawMaterials;
	}

	public String getNamesOfSuppliers() {
		return namesOfSuppliers;
	}

	public void setNamesOfSuppliers(String namesOfSuppliers) {
		this.namesOfSuppliers = namesOfSuppliers;
	}

	public String getProductsProcess() {
		return productsProcess;
	}

	public void setProductsProcess(String productsProcess) {
		this.productsProcess = productsProcess;
	}
	public String getUpdateOnStr() {
		return updatedOn.toString();
	}
	
	public String getCreatedOnStr() {
		return createdOn.toString();
	}

	public Userlab getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Userlab createdBy) {
		this.createdBy = createdBy;
	}

	
	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	
	public String getProductVarieties() {
		return productVarieties;
	}

	public void setProductVarieties(String productVarieties) {
		this.productVarieties = productVarieties;
	}

	public String getCreatedByStr() {
		if(createdBy != null)
			return createdBy.getLastName()+", "+createdBy.getFirstName();
		return "";
	}

	
	public String getAddressOfEstablishment() {
		return addressOfEstablishment;
	}

	public void setAddressOfEstablishment(String addressOfEstablishment) {
		this.addressOfEstablishment = addressOfEstablishment;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
	public String getTypeOfApplication() {
		return typeOfApplication;
	}

	public void setTypeOfApplication(String typeOfApplication) {
		this.typeOfApplication = typeOfApplication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nameOfEstablishment == null) ? 0 : nameOfEstablishment.hashCode());
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
		Supplier other = (Supplier) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nameOfEstablishment == null) {
			if (other.nameOfEstablishment != null)
				return false;
		} else if (!nameOfEstablishment.equals(other.nameOfEstablishment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", active=" + active
				+ ", enable=" + enable + ", nameOfEstablishment=" + nameOfEstablishment + ", addressOfEstablishment="
				+ addressOfEstablishment + ", telNo=" + telNo + ", fax=" + fax + ", personInvolved=" + personInvolved
				+ ", position=" + position + ", email=" + email + ", website=" + website + ", reason=" + reason
				+ ", numOfEmployees=" + numOfEmployees + ", productionAreaSize=" + productionAreaSize + ", indoorArea="
				+ indoorArea + ", openArea=" + openArea + ", numOfRawMaterial=" + numOfRawMaterial
				+ ", numProductsWarehouses=" + numProductsWarehouses + ", productionCapacity=" + productionCapacity
				+ ", productionLines=" + productionLines + ", customProduction=" + customProduction + ", productBrands="
				+ productBrands + ", productVarieties=" + productVarieties + ", productNotHalal=" + productNotHalal
				+ ", namesOfRawMaterials=" + namesOfRawMaterials + ", namesOfSuppliers=" + namesOfSuppliers
				+ ", productsProcess=" + productsProcess + ", user=" + user + ", createdBy=" + createdBy + ", products="
				+ products + "]";
	}




	
	

}
