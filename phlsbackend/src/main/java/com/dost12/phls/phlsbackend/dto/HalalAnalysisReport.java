package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "halal_analysis_report")
public class HalalAnalysisReport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name ="created_on")
	private LocalDate createdOn;	
	
	@Column(name ="updated_on")
	private LocalDate updatedOn;
	
	@Column(name = "is_active")	
	private Boolean active;
	
	private String code;
	
	@Column(name ="test_method")
	private String testMethod;
	
	private String result;
	
	private String unit;
	
	private int mark;
	
	@DateTimeFormat(pattern="mm/dd/yyyy") 
	@Column(name ="date_submitted")
	private LocalDate dateSubmitted;	
	
	@DateTimeFormat(pattern="mm/dd/yyyy") 
	@Column(name ="started_date_analyzed")
	private LocalDate fromDateAnalyzed;	

	@DateTimeFormat(pattern="mm/dd/yyyy") 
	@Column(name ="end_date_analyzed")
	private LocalDate toDateAnalyzed;

	@DateTimeFormat(pattern="mm/dd/yyyy") 
	@Column(name ="date_reported")
	private LocalDate dateReported;
	
	@ManyToOne
	@JoinColumn(name = "halal_param_id", nullable=false)
	private HalalParameter halalParameter;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="analyst_by_id", nullable=false)
	private Personnel analyst;
	
	
	@OneToOne
	@JoinColumn(name="updated_by_id")
	private Userlab updatedBy;
	
	@Transient
	private int halalParameterId;
	
	@Transient
	private int analystId;
	
	@Transient
	private  String createdOnStr;
	@Transient
	public String updatedOnStr;

	@Transient
	private String dateSubmittedStr;	
	@Transient
	private String fromDateAnalyzedStr;	
	@Transient
	private String toDateAnalyzedStr;
	@Transient
	private String dateReportedStr;
	
	public HalalAnalysisReport() {
		super();
		active = true;
		createdOn = LocalDate.now();
		updatedOn = LocalDate.now();
		this.code = "HL-" + UUID.randomUUID().toString().substring(26).toUpperCase();
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

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public HalalParameter getHalalParameter() {
		return halalParameter;
	}

	public void setHalalParameter(HalalParameter halalParameter) {
		this.halalParameter = halalParameter;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getHalalParameterId() {
		return halalParameterId;
	}

	public void setHalalParameterId(int halalParameterId) {
		this.halalParameterId = halalParameterId;
	}
	
	

	public String getTestMethod() {
		return testMethod;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public Userlab getUpdatedBy() {
		return updatedBy;
	}




	public void setUpdatedBy(Userlab updatedBy) {
		this.updatedBy = updatedBy;
	}




	public LocalDate getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(LocalDate dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public LocalDate getFromDateAnalyzed() {
		return fromDateAnalyzed;
	}

	public void setFromDateAnalyzed(LocalDate fromDateAnalyzed) {
		this.fromDateAnalyzed = fromDateAnalyzed;
	}

	public LocalDate getToDateAnalyzed() {
		return toDateAnalyzed;
	}

	public void setToDateAnalyzed(LocalDate toDateAnalyzed) {
		this.toDateAnalyzed = toDateAnalyzed;
	}

	public LocalDate getDateReported() {
		return dateReported;
	}

	public void setDateReported(LocalDate dateReported) {
		this.dateReported = dateReported;
	}
	
	

	public String getDateSubmittedStr() {
		if(dateSubmitted != null)
			return dateSubmitted.toString();
		return dateSubmittedStr;
	}




	public void setDateSubmittedStr(String dateSubmittedStr) {
		this.dateSubmittedStr = dateSubmittedStr;
	}




	public String getFromDateAnalyzedStr() {
		if(fromDateAnalyzed != null)
			return fromDateAnalyzed.toString();
		return fromDateAnalyzedStr;
	}




	public void setFromDateAnalyzedStr(String fromDateAnalyzedStr) {
		this.fromDateAnalyzedStr = fromDateAnalyzedStr;
	}




	public String getToDateAnalyzedStr() {
		if(toDateAnalyzed != null)
			return toDateAnalyzed.toString();
		return toDateAnalyzedStr;
	}




	public void setToDateAnalyzedStr(String toDateAnalyzedStr) {
		this.toDateAnalyzedStr = toDateAnalyzedStr;
	}




	public int getAnalystId() {
		return analystId;
	}




	public void setAnalystId(int analystId) {
		this.analystId = analystId;
	}




	public String getDateReportedStr() {
		if(dateReported != null)
			return dateReported.toString();
		return dateReportedStr;
	}




	public void setDateReportedStr(String dateReportedStr) {
		this.dateReportedStr = dateReportedStr;
	}




	public Personnel getAnalyst() {
		return analyst;
	}




	public void setAnalyst(Personnel analyst) {
		this.analyst = analyst;
	}




	@Override
	public String toString() {
		return "HalalAnalysisReport [id=" + id + ", createdOn=" + createdOn + ", updateOn=" + updatedOn + ", active="
				+ active + ", mark=" + mark + ", halalParameter=" + halalParameter + ", product=" + product
				+ ", halalParameterId=" + halalParameterId + "]";
	}

	
	
}
