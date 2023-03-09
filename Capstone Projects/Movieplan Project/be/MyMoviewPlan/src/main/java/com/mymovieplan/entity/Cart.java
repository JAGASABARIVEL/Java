package com.mymovieplan.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.apache.catalina.User;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users id_user;
	
	@ManyToMany()
	@JoinTable(name = "id_movie", 
	    joinColumns = @JoinColumn(name = "id_cart"),
	    inverseJoinColumns = @JoinColumn(name="id_movie"))
	private Set<Movie> movie_id = new HashSet<Movie>();

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Users user_id, Movie movie_id) {
		super();
		this.id_user = user_id;
		this.movie_id.add(movie_id);
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Users getUser_id() {
		return id_user;
	}

	public void setUser_id(Users user_id) {
		this.id_user = user_id;
	}

	public Set<Movie> getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Movie movie_id) {
		this.movie_id.add(movie_id);
	}
	
	
	
}
