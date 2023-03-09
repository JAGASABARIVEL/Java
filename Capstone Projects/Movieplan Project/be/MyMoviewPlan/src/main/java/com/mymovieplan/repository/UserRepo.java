package com.mymovieplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieplan.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	public Users findByuPhone(Long uPhone);
}
