package com.sportyshoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoe.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
public User findByuPhone(Long uPhone);
}
