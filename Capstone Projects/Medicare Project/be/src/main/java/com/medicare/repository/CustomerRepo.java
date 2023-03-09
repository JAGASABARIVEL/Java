package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
