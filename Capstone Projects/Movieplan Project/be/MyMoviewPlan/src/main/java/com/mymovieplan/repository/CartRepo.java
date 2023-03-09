package com.mymovieplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieplan.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
