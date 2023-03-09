package com.mymovieplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.entity.Movie;
import com.mymovieplan.repository.MovieRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	public boolean addMovie(Movie movie) {
		try {
			movieRepo.save(movie);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Movie getMovieById(Integer mId) {
		return movieRepo.findById(mId).orElse(null);
	}
	
	public List<Movie> get(){
		return movieRepo.findAll();
	}
}
