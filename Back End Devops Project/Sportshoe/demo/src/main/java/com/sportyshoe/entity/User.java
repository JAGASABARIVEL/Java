package com.sportyshoe.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserTable", uniqueConstraints = {
	            @UniqueConstraint(columnNames={"uPhone"})
	            })
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	
	private Long uPhone;
	
	private String uPassword;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer_id;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long uPhone, String uPassword) {
		super();
		this.uPhone = uPhone;
		this.uPassword = uPassword;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Long getuPhone() {
		return uPhone;
	}

	public void setuPhone(Long uPhone) {
		this.uPhone = uPhone;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
