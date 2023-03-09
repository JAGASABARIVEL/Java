package com.sportyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoe.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
