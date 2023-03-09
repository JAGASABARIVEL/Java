package com.mymovieplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.entity.Users;
import com.mymovieplan.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public boolean register(Users user) {
		try {
			userRepo.save(user);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean login(Long uPhone, String uPassword) {
		Users users = userRepo.findByuPhone(uPhone);
		if (users != null) {
			return users.getuPhone().equals(uPhone);
		}
		return false;
	}
	
	public Users getUserByPhone(Long uPhone) {
		return userRepo.findByuPhone(uPhone);
	}
}
