package com.medicare.model;

public class CartModel {

	private Integer cId;

	private String cName;
	
	private Long cPhone;
	
	private String cAddress;
	
    private String pName;
	
	private String pImage;
	
	private String pBrand;
	
	private String pDesc;
	
	private Integer pPrice;

	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartModel(Integer cId, String cName, Long cPhone, String cAddress, String pName, String pImage,
			String pBrand, String pDesc, Integer pPrice) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.pName = pName;
		this.pImage = pImage;
		this.pBrand = pBrand;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
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

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	
}
