package com.mymovieplan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.entity.Cart;
import com.mymovieplan.entity.Movie;
import com.mymovieplan.entity.Users;
import com.mymovieplan.model.CartModel;
import com.mymovieplan.model.CartViewModel;
import com.mymovieplan.service.CartService;
import com.mymovieplan.service.MovieService;
import com.mymovieplan.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/add/{phone}")
	public ResponseEntity<String> addToCart(@PathVariable Long phone, @RequestBody CartModel cartModel, HttpServletRequest request) {

		
		Users users = userService.getUserByPhone(phone);
		if (users != null) {
			Movie movie = movieService.getMovieById(cartModel.getmId());
			if (movie != null) {
				if (cartService.addMovie(users, movie)) {
					return new ResponseEntity<String>("Movie added successfully!", HttpStatus.OK);
				}
				return new ResponseEntity<String>("Movie could not be booked!", HttpStatus.OK);
			}
			return new ResponseEntity<String>("Movie is not selected!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Please login before booking a ticket!", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/get/{phone}")
	public ResponseEntity<List<CartViewModel>> viewCart(@PathVariable Long phone, HttpServletRequest request) {
		Users users = userService.getUserByPhone(phone);
		if (users != null) {
			List<CartViewModel> cartModels = new ArrayList<>();
			Cart cart = cartService.getCart(users);
			if (cart != null) {
				for (Movie movie : cart.getMovie_id()) {
					cartModels.add(
							new CartViewModel(
									cart.getcId(), movie.getmName(), movie.getmImage(), movie.getPrice()));
				}
				return new ResponseEntity<List<CartViewModel>>(cartModels, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
