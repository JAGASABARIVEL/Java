package com.mymovieplan.model;

public class CartViewModel {

	private Integer mId;
	
	private String mName;
	
	private String mImage;
	
	private Integer price;

	
	public CartViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CartViewModel(Integer mId, String mName, String mImage, Integer price) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mImage = mImage;
		this.price = price;
	}


	public Integer getmId() {
		return mId;
	}

	public void setcId(Integer mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mImage) {
		this.mImage = mImage;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}