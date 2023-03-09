package com.sportyshoe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CatgoryTable",
    uniqueConstraints = @UniqueConstraint(columnNames = "cName"))
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	private String cName;
	
	@OneToMany(mappedBy = "category")
	private List<Product> cProducts = new ArrayList<>();

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String cName) {
		super();
		this.cName = cName;
	}
	
	public Category(String cName, Product cProducts) {
		super();
		this.cName = cName;
		this.cProducts.add(cProducts);
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

	public List<Product> getcProducts() {
		return cProducts;
	}

	public void setcProducts(Product cProducts) {
		this.cProducts.add(cProducts);
	}
	
	
}
