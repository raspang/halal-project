package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "order_total")
	private double orderTotal;
	
	@ManyToOne
	private Address shipping;
	
	@ManyToOne
	private Address billing;
	
	
	@OneToMany(mappedBy="orderDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@Column(name = "order_count")
	private int orderCount;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Transient
	private String orderDateStr;
	
	@Transient
	private String nameStr;
	
	
	
	
	public OrderDetail() {
		super();
		
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getNameStr() {
		return user.getLastName()+", "+user.getFirstName();
	}
	public void setNameStr(String nameStr) {
		this.nameStr = nameStr;
	}
	public String getOrderDateStr() {
		if(orderDate != null)
		return formatter.format(orderDate);
		return orderDateStr;
	}
	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Address getShipping() {
		return shipping;
	}
	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	} 
	
}
