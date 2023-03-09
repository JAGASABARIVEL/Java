package com.medicare.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(
        name="Categor", 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"cName"})
    )

public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	private String cName;
	
	@OneToMany(mappedBy = "pcategory", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cName) {
		super();
		this.cName = cName;
	}
	
	public Category(String cName, Product products) {
		super();
		this.cName = cName;
		this.products.add(products);
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products.add(products);
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}
	
	
}