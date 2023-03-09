package com.sportyshoe.model;

public class RegisterModel {

	private Long phone;
	
	private String password;

	public RegisterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterModel(Long phone, String password) {
		super();
		this.phone = phone;
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
