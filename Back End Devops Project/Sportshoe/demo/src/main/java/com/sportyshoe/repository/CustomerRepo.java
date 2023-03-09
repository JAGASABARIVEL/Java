package com.sportyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoe.entity.Customer;
import com.sportyshoe.entity.User;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
public Customer findBycUser(User cUser);
}
