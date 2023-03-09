package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {
	public Cart findBycId(Integer cId);
}
