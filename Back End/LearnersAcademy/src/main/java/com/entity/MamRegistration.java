package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MamRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mId;
	
	private String name;

	public MamRegistration() {
	}

	public MamRegistration(String name) {
		this.name = name;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
