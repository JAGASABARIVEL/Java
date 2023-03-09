package com.medicare.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	private String cName;
	
	private Long cPhone;
	
	private String cCurrentShippingAddress;
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cuser_id")
	private User cUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,
			CascadeType.DETACH,
			CascadeType.REFRESH,
			CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinTable(
			name="prod",
			joinColumns = @JoinColumn(name="cust_id"),
			inverseJoinColumns = @JoinColumn(name="prod_id"))
	private List<Product> prod = new ArrayList<>();
	
	private boolean isAdmin;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(String cName, Long cPhone, String cCurrentShippingAddress,
			Cart cart, Product products, boolean isAdmin, User cUser) {
		super();
		this.cName = cName;
		this.cPhone = cPhone;
		this.cCurrentShippingAddress = cCurrentShippingAddress;
		this.cart = cart;
		this.prod.add(products);
		this.isAdmin = isAdmin;
		this.cUser = cUser;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = this.cUser.isAdmin();
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

	public Long getcPhone() {
		return cPhone;
	}

	public void setcPhone(Long cPhone) {
		this.cPhone = cPhone;
	}

	public String getcCurrentShippingAddress() {
		return cCurrentShippingAddress;
	}

	public void setcCurrentShippingAddress(String cCurrentShippingAddress) {
		this.cCurrentShippingAddress = cCurrentShippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Product> getProducts() {
		return prod;
	}

	public void setProducts(Product products) {
		this.prod.add(products);
	}


	public User getcUser() {
		return cUser;
	}


	public void setcUser(User cUser) {
		this.cUser = cUser;
	}
	
	
}
