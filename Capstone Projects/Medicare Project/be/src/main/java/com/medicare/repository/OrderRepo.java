package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
