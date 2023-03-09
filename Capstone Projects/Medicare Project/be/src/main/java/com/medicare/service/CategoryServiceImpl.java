package com.medicare.service;

import org.springframework.stereotype.Service;

import com.medicare.entity.Category;
import com.medicare.entity.Product;
import com.medicare.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepo categoryRepo;

	CategoryServiceImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public Category findCategory(String name) {
		return categoryRepo.findBycName(name);
	}
}
