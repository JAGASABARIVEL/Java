package com.mymovieplan.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mId;
	
	private String mName;
	
	@Column(length = 30000)
	private String mImage;
	
	private Integer tickets;
	
	private Integer price;
	
	private LocalDate localDate;
	
	@ManyToMany(mappedBy = "movie_id")
	private List<Cart> carts = new ArrayList<>();

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String mName, String mImage, Integer tickets, Integer price, LocalDate localDate, Cart carts) {
		super();
		this.mName = mName;
		this.mImage = mImage;
		this.tickets = tickets;
		this.price = price;
		this.localDate = localDate;
		this.carts.add(carts);
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

	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mImage) {
		this.mImage = mImage;
	}

	public Integer getTickets() {
		return tickets;
	}

	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Cart carts) {
		this.carts.add(carts);
	}
	
	
}