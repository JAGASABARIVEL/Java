package com.medicare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name="UserTable", 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"uPhone"})
    )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	
	private String uName;
	
	private Long uPhone;
	
	private String uPassword;
	
	private boolean isAdmin;
	
	private boolean isLoggedIn;
	
	@OneToOne(mappedBy = "cUser")
	private Customer customer;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(String uName, Long uPhone, String uPassword, boolean isAdmin, boolean isLoggedIn, Customer customer) {
		super();
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPassword = uPassword;
		this.isAdmin = isAdmin;
		this.isLoggedIn = isLoggedIn;
		this.customer = customer;
	}



	public Long getuPhone() {
		return uPhone;
	}



	public void setuPhone(Long uPhone) {
		this.uPhone = uPhone;
	}



	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
