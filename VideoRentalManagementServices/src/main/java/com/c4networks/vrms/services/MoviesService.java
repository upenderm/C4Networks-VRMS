package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.Movies;

public interface MoviesService {

	public List<Movies> getMoviesList();

	public Integer addMovie(Movies movie);

	public Integer getAvailableMovieCopiesById(Integer movieId);
}
