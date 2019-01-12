package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.MovieDetails;

/**
 * 
 * @author M Upender
 *
 */

public interface MovieDetailsDAO {

	public void saveMovieDetail(MovieDetails transientInstance);

	public void deleteMovieDetail(MovieDetails persistentInstance);

	public MovieDetails findByMovieId(String movieId);

	public List<MovieDetails> findByProperty(String propertyName, Object value);

	public List<MovieDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2);
	
	public List<MovieDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2, String propertyName3, Object value3);

	public List<MovieDetails> findAll();
}