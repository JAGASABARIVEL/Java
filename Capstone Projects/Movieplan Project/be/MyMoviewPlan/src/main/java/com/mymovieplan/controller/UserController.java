package com.mymovieplan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.entity.Users;
import com.mymovieplan.model.LoginModel;
import com.mymovieplan.model.RegisterModel;
import com.mymovieplan.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/register")
	public ResponseEntity<String> register(@RequestBody RegisterModel registerModel,
			HttpServletRequest request) {

		Users users = new Users(registerModel.getuName(), 
				registerModel.getuPhone(), 
				registerModel.getuPassword(),
				null);
		if (userService.register(users)) {
			request.getSession().setAttribute("user", users);
			return new ResponseEntity<>("Registration successful!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Registration not successful!", HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody LoginModel loginModel,
			HttpServletRequest request){
		if (request.getSession().getAttribute("user") != null) {
			return new ResponseEntity<>("Login successful!", HttpStatus.OK);
		}
		if (userService.login(loginModel.getuPhone(), loginModel.getuPassword())) {
			Users users = userService.getUserByPhone(loginModel.getuPhone());
			request.getSession().setAttribute("user", users);
			return new ResponseEntity<>("Login successful!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Authentication failure!", HttpStatus.OK);
	}
}
