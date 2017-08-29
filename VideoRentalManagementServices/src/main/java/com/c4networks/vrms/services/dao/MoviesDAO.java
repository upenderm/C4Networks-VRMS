package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.Movies;

public interface MoviesDAO {
	
	public void save(Movies transientInstance);

	public void delete(Movies persistentInstance);

	public Movies findById(java.lang.Integer id);

	public List<Movies> findByExample(Movies instance);

	public List<Movies> findByProperty(String propertyName, Object value);

	public List<Movies> findAll();
}