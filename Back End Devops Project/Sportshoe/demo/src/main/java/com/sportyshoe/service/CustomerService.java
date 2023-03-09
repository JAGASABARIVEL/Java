package com.sportyshoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoe.entity.Customer;
import com.sportyshoe.entity.Product;
import com.sportyshoe.entity.User;
import com.sportyshoe.model.CartViewModel;
import com.sportyshoe.repository.CustomerRepo;
import com.sportyshoe.repository.ProductRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public Customer findCustomerByUserId(User user) {
		for (Customer customer : customerRepo.findAll()) {
			if (customer.getcUser().getuPhone().equals(user.getuPhone())) {
				return customer;
			}
		}
		return null;
	}
	
	public boolean addToCart(Customer customer, Product product) {
		try {
			customerRepo.save(customer);
			product.setCustomer(customer);
			productRepo.save(product);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<CartViewModel> viewCart(User user, List<CartViewModel> cartViewModels){
		Customer customer = findCustomerByUserId(user);
		if (customer != null) {
			for(Product product : customer.getProduct()) {
				CartViewModel cartViewModel = new CartViewModel(customer.getcUser().getuPhone(), 
						product.getpName(), 
						product.getpPrice(), 
						product.getpQuantitty());
				cartViewModels.add(cartViewModel);
			}
		}
		return cartViewModels;
	}
}
