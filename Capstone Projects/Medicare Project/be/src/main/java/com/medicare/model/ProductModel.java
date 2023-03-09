package com.medicare.model;

public class ProductModel {
	
	private Integer pId;
	
	private String pName;
	
	private String pImage;
	
	private String pBrand;
	
	private String pDesc;
	
	private String pCategory;
	
	private Integer pPrice;
	
	private Integer quantity;
	

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductModel(Integer pId, String pName, String pImage, String pBrand, String pDesc, Integer pPrice, String pCategory, Integer quantity) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pImage = pImage;
		this.pBrand = pBrand;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pCategory = pCategory;
		this.quantity = quantity;
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

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	
	
	
}
