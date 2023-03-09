package com.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.entity.Cart;
import com.medicare.entity.Customer;
import com.medicare.entity.Product;
import com.medicare.repository.CartRepo;
import com.medicare.repository.CustomerRepo;
import com.medicare.repository.ProductRepo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ProductRepo productRepo;

	public void addToCart(Customer customer, Cart cart) {
		cartRepo.save(cart);
		customerRepo.save(customer);
	}

	public Cart getCart(Integer cId) {
		return cartRepo.findBycId(cId);
	}

	public Cart getCartByCustomerId(Integer cId) {
		List<Cart> carts = cartRepo.findAll();
		if (carts != null) {
			for (Cart cart : carts) {
				if (cart.getCustomer() != null && cart.getCustomer().getcId().equals(cId)) {
					return cart;
				}
			}
		}
		return null;
	}
}
