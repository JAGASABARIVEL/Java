package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubjectRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	
	private String name;

	public SubjectRegistration() {
	}

	public SubjectRegistration(String name) {
		this.name = name;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
