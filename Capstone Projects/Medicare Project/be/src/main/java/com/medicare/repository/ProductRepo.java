package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	public Product findBypName(String pname);
	public Product findBypId(Integer pId);
}
