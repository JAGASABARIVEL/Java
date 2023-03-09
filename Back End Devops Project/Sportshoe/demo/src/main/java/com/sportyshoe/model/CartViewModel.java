package com.sportyshoe.model;

public class CartViewModel {

	private Long cPhone;
	
	private String pName;
	
	private Integer pPrice;
	
	private Integer pQty;

	
	public CartViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CartViewModel(Long cPhone, String pName, Integer pPrice, Integer pQty) {
		super();
		this.cPhone = cPhone;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}


	public Long getcPhone() {
		return cPhone;
	}

	public void setcPhone(Long cPhone) {
		this.cPhone = cPhone;
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

	public Integer getpQty() {
		return pQty;
	}

	public void setpQty(Integer pQty) {
		this.pQty = pQty;
	}
	
	
}
