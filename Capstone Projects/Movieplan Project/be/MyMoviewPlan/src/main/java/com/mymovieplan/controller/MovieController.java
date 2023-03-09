package com.mymovieplan.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.entity.Movie;
import com.mymovieplan.repository.MovieModel;
import com.mymovieplan.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public ResponseEntity<String> addMovie(@RequestBody MovieModel movieModel){
		
		Movie movie = new Movie(movieModel.getmName(),
				movieModel.getmImage(), 
				movieModel.getTickets(),
				movieModel.getPrice(),
				null,
				null);
		if (movieService.addMovie(movie)) {
			return new ResponseEntity<String>("Movie got added successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movie could not be added!", HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/get")
	public ResponseEntity<List<MovieModel>> get(){
		
		List<MovieModel> MovieList = new ArrayList<>();
		List<Movie> movielist = movieService.get();
		for (Movie movie : movielist) {
			MovieList.add(
					new MovieModel(movie.getmId(),
							movie.getmName(),
							movie.getmImage(),
							movie.getTickets(),
							movie.getPrice())
					);
		}
		return new ResponseEntity<List<MovieModel>>(MovieList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/{pId}")
	public ResponseEntity<MovieModel> get(@PathVariable Integer pId){
		
		MovieModel movieModel;
		Movie movie = movieService.getMovieById(pId);
		
		movieModel = new MovieModel(				
				movie.getmId(),
							movie.getmName(),
							movie.getmImage(),
							movie.getTickets(),
							movie.getPrice()
					);
		return new ResponseEntity<MovieModel>(movieModel, HttpStatus.OK);
	}
}
