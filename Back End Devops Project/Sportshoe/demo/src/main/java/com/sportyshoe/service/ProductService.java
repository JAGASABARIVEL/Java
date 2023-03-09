package com.sportyshoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoe.entity.Category;
import com.sportyshoe.entity.Product;
import com.sportyshoe.repository.CategoryRepo;
import com.sportyshoe.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	public boolean addProduct(Product product) {
		try {
			productRepo.save(product);
			Category category = product.getCategory();
			category.setcProducts(product);
			categoryRepo.save(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Product getProductById(Integer pId) {
		return productRepo.findById(pId).orElse(null);
	}
}
