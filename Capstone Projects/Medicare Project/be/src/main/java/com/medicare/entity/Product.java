package com.medicare.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	
	private String pName;
	
	@Column(length = 12000)
	private String pImage;
	
	private String pBrand;
	
	private String pDesc;
	
	private Integer pPrice;
	
	private Integer pAvailableQuantity;
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="cart_id") private Cart pcart;
	 */
	
	@ManyToOne(cascade = {CascadeType.PERSIST,
			CascadeType.DETACH,
			CascadeType.REFRESH,
			CascadeType.REMOVE})
	@JoinColumn(name="category_id")
	private Category pcategory;
	
	
	
	@ManyToMany(mappedBy = "prod")
	private List<Customer> pcustomers = new ArrayList<Customer>();
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String pName, String pImage, String pBrand, String pDesc, Integer pPrice,
			Integer pAvailableQuantity,
			Category pcategory, Customer pcustomers) {
		super();
		this.pName = pName;
		this.pImage = pImage;
		this.pBrand = pBrand;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pAvailableQuantity = pAvailableQuantity;
		this.pcategory = pcategory;
		this.pcustomers.add(pcustomers);
	}
	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
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

	public Integer getpAvailableQuantity() {
		return pAvailableQuantity;
	}

	public void setpAvailableQuantity(Integer pAvailableQuantity) {
		this.pAvailableQuantity = pAvailableQuantity;
	}

	/*
	 * public Cart getPcart() { return pcart; }
	 * 
	 * public void setPcart(Cart pcart) { this.pcart = pcart; }
	 */

	public Category getPcategory() {
		return pcategory;
	}

	public void setPcategory(Category pcategory) {
		this.pcategory = pcategory;
	}

	public List<Customer> getPcustomers() {
		return pcustomers;
	}

	public void setPcustomers(Customer pcustomers) {
		this.pcustomers.add(pcustomers);
	}

	
	
	
}
