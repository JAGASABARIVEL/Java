package com.medicare.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.entity.Customer;
import com.medicare.entity.User;
import com.medicare.repository.CustomerRepo;
import com.medicare.repository.UserRepo;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	public boolean registerUser(User user) {
		if (user.getuPhone() != null) {
			
			Customer customer = new Customer(
					user.getuName(), 
					user.getuPhone(), 
					"", null, null, user.isAdmin(), user
					);
			user.setCustomer(customer);
			customerRepo.save(customer);
			userRepo.save(user);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Integer isLoginSuccess(Long uPhone, String uPassword) {
		if (userRepo.findByuPhone(uPhone).get(0).getuPassword().equals(uPassword)) {
			System.out.println("Password is Valid");
			return getUserById(uPhone);
		}
		else {
			System.out.println("Incorrect Password");
			return -1;
		}
	}
	
	public Integer getUserById(Long uPhone) {
		return userRepo.findByuPhone(uPhone).get(0).getuId();
	}
	
	public User findByUserId(Integer uId) {
		return userRepo.findByuId(uId);
	}
}
