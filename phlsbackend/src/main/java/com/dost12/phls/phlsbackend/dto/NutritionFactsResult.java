package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "nutrition_facts_result")
public class NutritionFactsResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "created_on")	
	private LocalDate createdOn;
	
	@Column(name = "updated_on")
	private LocalDate updatedOn;
	
	@Column(name = "is_active")	
	private Boolean active;
	
	@Column(name = "reference_no")	
	private String referenceNo;
	
	@DateTimeFormat(pattern="mm/dd/yyyy") 
	@Column(name ="date_of_evaluation")
	private LocalDate dateEvaluation;		
	
	@DateTimeFormat(pattern="mm/dd/yyyy")
	@Column(name ="date_of_reported")
	private LocalDate dateReported;		
	
/*	@ManyToOne
	@JoinColumn(name = "nutrition_facts_param_id", nullable=false)
	private NutritionFactsParameter nutritionFactsParameter;

	private String value;*/
	
	@Column(name = "serving_size")	
	private String servingSize;
	

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "nutrition_facts_result_parameter", 
             joinColumns = { @JoinColumn(name = "nutrition_facts_result_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "parameter_id") })
	private Set<NutritionFactsParameter> nutritionFactsParameters = new HashSet<NutritionFactsParameter>();
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable=false)
	private Product product;

	@ManyToOne
	@JoinColumn(name="analyst_by_id", nullable=false)
	private Personnel analyst;
	
	@OneToOne
	@JoinColumn(name="updated_by_id")
	private Userlab updatedBy;
	

//	@Transient
//	private int nutritionFactsParameterId;
	
	@Transient
	private String createdOnStr;
	
	@Transient
	private String updatedOnStr;
	
	@Transient
	private String dateEvaluationStr;
	
	@Transient
	private String dateReportedStr;
	
	@Transient
	private int analystId;
	
	public NutritionFactsResult() {
		super();
		active = true;
		createdOn = LocalDate.now();
		updatedOn = LocalDate.now();
		dateEvaluation = LocalDate.now();
		dateReported = LocalDate.now();
		this.referenceNo = "PL-" + UUID.randomUUID().toString().substring(26).toUpperCase();
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

/*	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public NutritionFactsParameter getNutritionFactsParameter() {
		return nutritionFactsParameter;
	}

	public void setNutritionFactsParameter(NutritionFactsParameter nutritionFactsParameter) {
		this.nutritionFactsParameter = nutritionFactsParameter;
	}*/


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

//	public int getNutritionFactsParameterId() {
//		return nutritionFactsParameterId;
//	}
//
//	public void setNutritionFactsParameterId(int nutritionFactsParameterId) {
//		this.nutritionFactsParameterId = nutritionFactsParameterId;
//	}



	public LocalDate getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(LocalDate dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public LocalDate getDateReported() {
		return dateReported;
	}

	public void setDateReported(LocalDate dateReported) {
		this.dateReported = dateReported;
	}



	public Personnel getAnalyst() {
		return analyst;
	}

	public void setAnalyst(Personnel analyst) {
		this.analyst = analyst;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public String getCreatedOnStr() {
		if(createdOn != null)
			return createdOn.toString();
		return createdOnStr;
	}

	public void setCreatedOnStr(String createdOnStr) {
		this.createdOnStr = createdOnStr;
	}



	public String getUpdatedOnStr() {
		if(updatedOn != null)
			return updatedOn.toString();
		return updatedOnStr;
	}

	public void setUpdatedOnStr(String updatedOnStr) {
		this.updatedOnStr = updatedOnStr;
	}

	public String getDateEvaluationStr() {
		if(dateEvaluation != null)
			return dateEvaluation.toString();
		return dateEvaluationStr;
	}

	public void setDateEvaluationStr(String dateEvaluationStr) {
		this.dateEvaluationStr = dateEvaluationStr;
	}

	public String getDateReportedStr() {
		if(dateReported != null)
			return dateReported.toString();
		return dateReportedStr;
	}

	public void setDateReportedStr(String dateReportedStr) {
		this.dateReportedStr = dateReportedStr;
	}

	public Userlab getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Userlab updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getAnalystId() {
		return analystId;
	}

	public void setAnalystId(int analystId) {
		this.analystId = analystId;
	}

	public Set<NutritionFactsParameter> getNutritionFactsParameters() {
		return nutritionFactsParameters;
	}

	public void setNutritionFactsParameters(Set<NutritionFactsParameter> nutritionFactsParameters) {
		this.nutritionFactsParameters = nutritionFactsParameters;
	}

}
