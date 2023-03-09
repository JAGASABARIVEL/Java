package com.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.entity.Category;
import com.medicare.model.CategoryModel;
import com.medicare.service.CategoryServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/categories")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public ResponseEntity<String> addProduct(@RequestBody CategoryModel categoryModel){
		
		Category category = new Category(categoryModel.getName());
		categoryService.addCategory(category);
		
		return new ResponseEntity<String>("Category added successfully!", HttpStatus.OK);
		
	}
}
