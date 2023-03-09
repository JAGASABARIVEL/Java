package com.sportyshoe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoe.entity.Customer;
import com.sportyshoe.entity.Product;
import com.sportyshoe.entity.User;
import com.sportyshoe.model.AddToCartModel;
import com.sportyshoe.model.CartViewModel;
import com.sportyshoe.service.CustomerService;
import com.sportyshoe.service.ProductService;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@RequestMapping(value = "/add")
	public ResponseEntity<String> addToCart(@RequestBody AddToCartModel addToCartModel,
			HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		System.out.println("customer " + user.getuPhone());

		System.out.println("user " + user.getuPhone());
		if (user != null) {
			Product product = productService.getProductById(addToCartModel.getpId());
			if (product == null) {
				return new ResponseEntity<String>("No products selected!", HttpStatus.OK);
			} else {
				Customer customer = customerService.findCustomerByUserId(user);
				product.setPurchaseQuantity(addToCartModel.getpQty());
				if (customer != null) {
					product.setpQuantitty(product.getpQuantitty() - product.getPurchaseQuantity());
					customer.setProduct(product);
					if (customerService.addToCart(customer, product)) {
						return new ResponseEntity<String>("Product added to cart!", HttpStatus.OK);
					}
					return new ResponseEntity<String>("Error in adding product to cart!", HttpStatus.OK);
				}
				return new ResponseEntity<String>("Customer record not found!", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<String>("Please log in before you purchase!", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/view")
	public ResponseEntity<List<CartViewModel>> viewCart(HttpServletRequest httpServletRequest) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user != null) {
			List<CartViewModel> cartViewModels = new ArrayList<CartViewModel>();
			cartViewModels = customerService.viewCart(user, cartViewModels);
			return new ResponseEntity<>(cartViewModels, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
