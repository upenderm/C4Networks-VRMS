package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.Categories;

/**
 * 
 * @author M Upender
 *
 */

public interface CategoriesDAO {

	public void saveCategory(Categories categories);

	public void deleteCategory(Categories categories);

	public Categories findByCategoryId(String categoryId);

	public List<Categories> findByProperty(String propertyName, String value);

	public List<Categories> findByProperty(String propertyName, String value, String propertyName2, String value2);

	public List<Categories> findByProperty(String propertyName, String value, String propertyName2, String value2,
			String propertyName3, String value3);

	public List<Categories> findAll();

}
