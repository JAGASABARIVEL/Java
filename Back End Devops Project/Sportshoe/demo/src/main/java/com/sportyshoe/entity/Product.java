package com.sportyshoe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ProductTable")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	
	private String pName;
	
	private Integer pPrice;
	
	private Integer pQuantitty;
	
	private Integer purchaseQuantity = 0;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToMany(mappedBy = "product")
	private List<Customer> customer = new ArrayList<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String pName, Integer pPrice, Integer pQuantitty, Category category, Customer customer) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
		this.pQuantitty = pQuantitty;
		this.category = category;
		this.customer.add(customer);
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	public Integer getpQuantitty() {
		return pQuantitty;
	}

	public void setpQuantitty(Integer pQuantitty) {
		this.pQuantitty = pQuantitty;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer.add(customer);
	}

	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	
}

