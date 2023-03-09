package com.sportyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoe.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	public Category findBycName(String cName);
}
