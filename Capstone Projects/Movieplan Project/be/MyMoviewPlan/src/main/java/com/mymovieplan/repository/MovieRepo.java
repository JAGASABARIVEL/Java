package com.mymovieplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieplan.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
