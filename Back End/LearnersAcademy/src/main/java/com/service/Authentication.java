package com.service;

import com.dao.UserDao;
import com.entity.User;

public class Authentication {
	
	public static boolean validate(User user) {
		UserDao userDao = new UserDao();
	    User vuser = userDao.fetchApi(user);
		if (vuser.getPassword().equals(vuser.getPassword())) {
			return true;
		}
		return false;
	}
}
