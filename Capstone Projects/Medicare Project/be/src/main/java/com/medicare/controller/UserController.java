package com.medicare.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.entity.Customer;
import com.medicare.entity.User;
import com.medicare.model.LoginModel;
import com.medicare.model.Register;
import com.medicare.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody LoginModel userModel, HttpServletRequest httpServlet) {

		if (httpServlet.getSession().getAttribute("user") != null) {
			return new ResponseEntity<>("Already logged In", HttpStatus.OK);
		}
		System.out.println("User Name " + userModel.getPhone());
		System.out.println("Password  " + userModel.getPassword());

		Integer user_id = userServiceImpl.isLoginSuccess(userModel.getPhone(), userModel.getPassword());
		if (user_id != -1) {
			System.out.println("\n\nSession Attribute \n\n" + httpServlet.getSession().getAttribute("user_id"));
			httpServlet.getSession().setAttribute("user_id", user_id);
			httpServlet.getSession().setAttribute("user", userServiceImpl.findByUserId(user_id));
			System.out.println("user_id " + user_id);
			User user = (User) httpServlet.getSession().getAttribute("user");
			System.out.println("user " + user.getCustomer().getcName());
			return new ResponseEntity<>("Logged In", HttpStatus.OK);
		}
		return new ResponseEntity<>("Incorrect Credentials", HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> register(@RequestBody Register register, HttpServletRequest httpServlet) {
		User user = new User(register.getuName(), register.getuPhone(), register.getuPassword(), false, true, null);

		boolean registerUser = userServiceImpl.registerUser(user);
		if (registerUser) {
			Integer user_id = userServiceImpl.isLoginSuccess(register.getuPhone() , register.getuPassword());
			httpServlet.getSession().setAttribute("user_id", user_id);
			httpServlet.getSession().setAttribute("user", userServiceImpl.findByUserId(user_id));
			LoginModel loginModel = new LoginModel();
			loginModel.setPhone(user.getuPhone());
			return new ResponseEntity<>("Phone " + loginModel.getPhone().toString() + " " + "got registered",
					HttpStatus.OK);
		}
		return new ResponseEntity<>("Registration is not successful", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/logout")
	@ResponseBody
	public ResponseEntity<String> logout(HttpServletRequest httpServlet) {
		if (httpServlet.getSession().getAttribute("user") != null) {
			httpServlet.getSession().removeAttribute("user_id");
			httpServlet.getSession().removeAttribute("user");
			return new ResponseEntity<>("Logout Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Already logged out or you have not logged in before!",
					HttpStatus.UNAUTHORIZED);
		}
	}
}
