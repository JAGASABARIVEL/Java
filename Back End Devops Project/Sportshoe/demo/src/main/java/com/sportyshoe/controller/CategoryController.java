package com.sportyshoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoe.entity.Category;
import com.sportyshoe.model.CategoryModel;
import com.sportyshoe.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public ResponseEntity<String> addCategory(@RequestBody CategoryModel categoryModel){
		
		Category category = new Category(categoryModel.getcName());
		if (categoryService.addCatgory(category)) {
			return new ResponseEntity<>("Category added successfully.", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Please add unique category.", HttpStatus.OK);
	}
}
