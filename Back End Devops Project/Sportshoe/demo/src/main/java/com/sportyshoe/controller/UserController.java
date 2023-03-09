package com.sportyshoe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoe.entity.User;
import com.sportyshoe.model.LoginModel;
import com.sportyshoe.model.RegisterModel;
import com.sportyshoe.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register")
	@ResponseBody
	public ResponseEntity<String> register(@RequestBody RegisterModel registerModel, HttpServletRequest httpRequest) {
		User user = new User(registerModel.getPhone(), registerModel.getPassword());
		if (userService.register(user)) {
			httpRequest.getSession().setAttribute("user", user);
			return new ResponseEntity<String>("User got registered", HttpStatus.OK);
		}
		return new ResponseEntity<String>("User already registered with the same phone.", HttpStatus.OK);
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody LoginModel loginModel, HttpServletRequest httpRequest) {
		if (httpRequest.getSession().getAttribute("user") == null) {
			User user = new User(loginModel.getPhone(), loginModel.getPassword());
			System.out.println("user " + user.getuPhone());
			if (userService.login(user)) {
				httpRequest.getSession().setAttribute("user", user);
				return new ResponseEntity<String>("Logged In.", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Incorrect password", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<String>("Already logged In.", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/logout")
	@ResponseBody
	public ResponseEntity<String> logout(HttpServletRequest httpRequest) {
		if (httpRequest.getSession().getAttribute("user") == null) {
			return new ResponseEntity<String>("Already logged out!", HttpStatus.OK);
		}
		httpRequest.getSession().removeAttribute("user");
		return new ResponseEntity<String>("Log out successful.", HttpStatus.OK);
	}

	
}
