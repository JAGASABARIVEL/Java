package com.sportyshoe.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	private String cName;
	
	@OneToOne(mappedBy = "customer_id")
	private User cUser;
	
	@ManyToMany
	@JoinTable(name = "product", 
	          joinColumns = @JoinColumn(name="customer_id"), 
	          inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> product;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String cName, User cUser, Product product) {
		super();
		this.cName = cName;
		this.cUser = cUser;
		this.product.add(product);
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public User getcUser() {
		return cUser;
	}

	public void setcUser(User cUser) {
		this.cUser = cUser;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product.add(product);
	}

	
	
	
}
