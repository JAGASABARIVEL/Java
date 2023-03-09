package com.sportyshoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoe.entity.Category;
import com.sportyshoe.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public boolean addCatgory(Category category) {
		try {
		categoryRepo.save(category);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Category findCategoryByName(String cName) {
		return categoryRepo.findBycName(cName);
	}
}
