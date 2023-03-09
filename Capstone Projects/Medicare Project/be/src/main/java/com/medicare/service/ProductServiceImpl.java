package com.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.entity.Category;
import com.medicare.entity.Product;
import com.medicare.repository.ProductRepo;

@Service 
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	public void addProduct(Product product, String category) {
		Category categoryEntity = categoryServiceImpl.findCategory(category);
		product.setPcategory(categoryEntity);
		categoryEntity.setProducts(product);
		categoryServiceImpl.addCategory(categoryEntity);
		productRepo.save(product);
	}
	
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	public Product getProduct(String productName){
		return productRepo.findBypName(productName);
	}
	
	public Product getProductById(Integer pId) {
		return productRepo.findBypId(pId);
	}
}
