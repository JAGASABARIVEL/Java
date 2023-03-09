package com.medicare.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderTable")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart oDetails;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Cart oDetails) {
		super();
		this.oDetails = oDetails;
	}

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Cart getoDetails() {
		return oDetails;
	}

	public void setoDetails(Cart oDetails) {
		this.oDetails = oDetails;
	}
	
	
}
