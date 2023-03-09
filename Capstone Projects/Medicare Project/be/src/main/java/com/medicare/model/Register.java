package com.medicare.model;

public class Register {
	
	private String uName;
	
	private Long uPhone;
	
	private String uPassword;
	
	private boolean isAdmin;
	
	private boolean isLoggedIn;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(Integer uId, String uName, Long uPhone, String uPassword, boolean isAdmin, boolean isLoggedIn) {
		super();
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPassword = uPassword;
		this.isAdmin = isAdmin;
		this.isLoggedIn = isLoggedIn;
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
	
	
}
