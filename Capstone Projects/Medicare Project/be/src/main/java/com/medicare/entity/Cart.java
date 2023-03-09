package com.medicare.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	@OneToOne(mappedBy = "cart")
	private Customer customer;

//	@OneToMany(mappedBy = "pcart", cascade = CascadeType.ALL)
//	private List<Product> products = new ArrayList<>();
	
	@OneToOne(mappedBy="oDetails")
	private Order order;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Customer customer/*, Product products*/) {
		super();
		this.customer = customer;
//		this.products.add(products);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*
	 * public List<Product> getProducts() { return products; }
	 * 
	 * public void setProducts(Product products) { this.products.add(products); }
	 */

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}
	
	

}
