package com.mymovieplan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mymovieplan.enums.Roles;

@Entity
@Table(name="UsersTable")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	
	private String uName;
	
	private Long uPhone;
	
	private String uPassword;
	
	@OneToOne(mappedBy = "id_user")
	private Cart cart;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String uName, Long uPhone, String uPassword, Cart cart) {
		super();
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPassword = uPassword;
		this.cart = cart;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	
	
	
}
