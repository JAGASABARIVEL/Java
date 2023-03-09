package com.medicare.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.entity.Cart;
import com.medicare.entity.Customer;
import com.medicare.entity.Product;
import com.medicare.entity.User;
import com.medicare.model.CartModel;
import com.medicare.model.GetModel;
import com.medicare.service.CartServiceImpl;
import com.medicare.service.ProductServiceImpl;
import com.medicare.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/cart")
@RestController
public class CartController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/add/{user_phone}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addToCart(@PathVariable Long user_phone, @RequestBody GetModel pId, HttpServletRequest httpServletRequest){
		
		Integer user_id = userServiceImpl.getUserById(user_phone);
		User user = userServiceImpl.findByUserId(user_id);
		System.out.println("user " + user);
		
		Product product = productServiceImpl.getProductById(pId.getmId());
		System.out.println("pId.getmId() " + pId.getmId());
		System.out.println("pId.getmName() " + pId.getmName());
		Customer customer = user.getCustomer();
		Cart cart = customer.getCart();
	
		if (product != null && product.getpAvailableQuantity() == 0) {
			return new ResponseEntity<String>("Product out of stock!", HttpStatus.OK);
		}
		if (cart == null) {
			product.setpAvailableQuantity(product.getpAvailableQuantity() - 1);
			customer.setProducts(product);
			cart = new Cart(customer);
			customer.setCart(cart);
			cartServiceImpl.addToCart(customer, cart);
		}
		else if (cart != null && product != null) {
			product.setpAvailableQuantity(product.getpAvailableQuantity() - 1);
			customer.setProducts(product);
			cart.setCustomer(customer);
			customer.setCart(cart);
			cartServiceImpl.addToCart(customer, cart);
		}
		else {
			return new ResponseEntity<String>("No product selected!", HttpStatus.BAD_REQUEST);
		}
		
		
		return new ResponseEntity<String>("Product added to cart successfully!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{user_phone}")
	@ResponseBody
	public ResponseEntity<List<CartModel>> getFromCart(@PathVariable Long user_phone, HttpServletRequest httpServletRequest){
		Integer user_id = userServiceImpl.getUserById(user_phone);
		User user = userServiceImpl.findByUserId(user_id);
		System.out.println("user " + user);
		
		Customer customer = user.getCustomer();
		Cart cart = cartServiceImpl.getCart(customer.getcId());
		List<CartModel> cartModels = new ArrayList<CartModel>();
		for (Product product : customer.getProducts()) {
			System.out.println("product " + product.getpName());
			CartModel cartModel = new CartModel(
					cart.getcId(), 
					cart.getCustomer().getcName(), 
					cart.getCustomer().getcPhone(), 
					cart.getCustomer().getcCurrentShippingAddress(), 
					product.getpName(), 
					product.getpImage(),
					product.getpBrand(), 
					product.getpDesc(), 
					product.getpPrice()
					);
			cartModels.add(cartModel);
		}
		
		return new ResponseEntity<List<CartModel>>(cartModels, HttpStatus.OK);
	}
	
	}