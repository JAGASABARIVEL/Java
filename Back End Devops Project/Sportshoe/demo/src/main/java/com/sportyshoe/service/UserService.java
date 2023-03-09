package com.sportyshoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoe.entity.Customer;
import com.sportyshoe.entity.User;
import com.sportyshoe.repository.CustomerRepo;
import com.sportyshoe.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private CustomerRepo customerRepo;

	public boolean register(User user) {

		try {
			repo.save(user);
			Customer customer = new Customer();
			customer.setcUser(user);
			user.setCustomer_id(customer);
			customerRepo.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean login(User luser) {
		User user = repo.findByuPhone(luser.getuPhone());
		if (user == null) {
			return false;
		}
		else if(user.getuPassword().equals(luser.getuPassword())) {
			return true;
		}
		return false;
	}
}
