package com.medicare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.entity.Product;
import com.medicare.entity.User;
import com.medicare.model.ProductModel;
import com.medicare.service.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/products")
@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public ResponseEntity<String> addProduct(@RequestBody ProductModel productModel){
		System.out.println("productModel.getCategory() : " + productModel.getpCategory() + productModel.getpPrice());
		Product product = new Product(productModel.getpName(), 
				productModel.getpImage(),
				productModel.getpBrand(),
				productModel.getpDesc(),
				productModel.getpPrice(),
				productModel.getQuantity(),
			    null, null);
		productServiceImpl.addProduct(product, productModel.getpCategory());
		
		
		return new ResponseEntity<String>("Product added successfully!", HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/get")
	@ResponseBody
	public ResponseEntity<List<ProductModel>> getProducts(){
		
		List<Product> products = productServiceImpl.getProducts();
		List<ProductModel> productModels = new ArrayList<ProductModel>();
		for (Product product : products) {
			System.out.println("getpName() : " + product.getpName());
			productModels.add(new ProductModel(
					product.getpId(),
					product.getpName(),
					product.getpImage(),
					product.getpBrand(),
					product.getpDesc(),
					product.getpPrice(),
					product.getPcategory().getcName(),
					product.getpAvailableQuantity()		
					));
		}
		
		return new ResponseEntity<List<ProductModel>>(productModels, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search/{search}")
	@ResponseBody
	public ResponseEntity<List<ProductModel>> searchProducts(@RequestBody @PathVariable String search){
		
		Product product = productServiceImpl.getProduct(search);
		List<ProductModel> productModels = new ArrayList<ProductModel>();		
		productModels.add(new ProductModel(
				product.getpId(),
				product.getpName(),
				product.getpImage(),
				product.getpBrand(),
				product.getpDesc(),
				product.getpPrice(),
				product.getPcategory().getcName(),
				product.getpAvailableQuantity()		
				));
		return new ResponseEntity<List<ProductModel>>(productModels, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{pId}")
	@ResponseBody
	public ResponseEntity<ProductModel> getProduct(@RequestBody @PathVariable Integer pId){
		
		Product product = productServiceImpl.getProductById(pId);
		ProductModel productModels = new ProductModel(
				product.getpId(),
				product.getpName(),
				product.getpImage(),
				product.getpBrand(),
				product.getpDesc(),
				product.getpPrice(),
				product.getPcategory().getcName(),
				product.getpAvailableQuantity()		
				);
		return new ResponseEntity<ProductModel>(productModels, HttpStatus.OK);
	}
}
