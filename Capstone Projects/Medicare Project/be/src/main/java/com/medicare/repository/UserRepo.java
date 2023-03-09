package com.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	List<User> findByuPhone(Long uPhone);
	public User findByuId(Integer uId);
}
