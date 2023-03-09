package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	public Category findBycName(String name);
}
