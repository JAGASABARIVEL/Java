package com.sportyshoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoe.entity.Category;
import com.sportyshoe.entity.Product;
import com.sportyshoe.model.ProductModel;
import com.sportyshoe.service.CategoryService;
import com.sportyshoe.service.ProductService;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductModel productModel){
		Category category = categoryService.findCategoryByName(productModel.getpCategory());
		Product product = new Product(
				productModel.getpName(),
				productModel.getpPrice(),
				productModel.getpQuantitty(),
				category,
				null
				);
		if (productService.addProduct(product)) {
			return new ResponseEntity<String>("Product added!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Could not add the product.", HttpStatus.OK);
	}
}
