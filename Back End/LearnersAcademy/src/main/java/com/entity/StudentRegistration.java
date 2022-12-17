package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer stId;
	
	String name;

	
	
	public StudentRegistration() {
	}


	public StudentRegistration(String name) {
		super();
		this.name = name;
	}

	
	public Integer getStId() {
		return stId;
	}


	public void setStId(Integer stId) {
		this.stId = stId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}