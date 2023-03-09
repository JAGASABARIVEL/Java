package com.mymovieplan.repository;

import java.time.LocalDate;

public class MovieModel {

	private Integer mId;
	
	private String mName;
	
	private String mImage;
	
	private Integer tickets;
	
	private Integer price;
	
	private LocalDate localDate;

	public MovieModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public MovieModel(Integer mId, String mName, String mImage, Integer tickets, Integer price) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mImage = mImage;
		this.tickets = tickets;
		this.price = price;
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
	
	
}
