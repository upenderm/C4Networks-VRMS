package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.Categories;

public interface CategoriesDAO {

	public void save(Categories transientInstance);

	public void delete(Categories persistentInstance);

	public Categories findById(java.lang.Integer id);

	public List<Categories> findByExample(Categories instance);

	public List<Categories> findByProperty(String propertyName, Object value);

	public List<Categories> findAll();
	
}
