package com.medicare.model;

public class GetModel {

	Integer mId;
	
	String mName;

	public GetModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetModel(Integer mId, String mName) {
		super();
		this.mId = mId;
		this.mName = mName;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}
	
	
}
