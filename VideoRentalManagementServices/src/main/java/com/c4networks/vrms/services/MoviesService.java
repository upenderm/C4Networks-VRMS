package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.UserDetails;

public interface MoviesService {

	public List<MovieDetails> getMoviesList(String agentCode, String companyId);

	public Integer addMovie(MovieDetails movie, String categoryId, UserDetails userDetails);

	public Integer getAvailableMovieCopiesById(String movieId, String userId, String companyId);
	
}
