package com.mymovieplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.entity.Cart;
import com.mymovieplan.entity.Movie;
import com.mymovieplan.entity.Users;
import com.mymovieplan.repository.CartRepo;
import com.mymovieplan.repository.MovieRepo;
import com.mymovieplan.repository.UserRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private UserRepo userRepo;

	public boolean addMovie(Users users, Movie movie) {
		try {
			Cart cart = getCart(users);
			
			if (cart != null) {
				System.out.println(cart.getUser_id().getuPhone());
				cart.setUser_id(users);
				cart.setMovie_id(movie);
				cartRepo.save(cart);
				
				movie.setCarts(cart);
				users.setCart(cart);
				movieRepo.save(movie);
				userRepo.save(users);
				
			} else {
				cart = new Cart(users, movie);
				cartRepo.save(cart);
				
				movie.setCarts(cart);
				users.setCart(cart);
				movieRepo.save(movie);
				userRepo.save(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cart getCart(Users users) {
		for (Cart cart : cartRepo.findAll()) {
			if (cart.getUser_id().getuPhone().equals(users.getuPhone())) {
				return cart;
			}
		}
		return null;
	}
}
