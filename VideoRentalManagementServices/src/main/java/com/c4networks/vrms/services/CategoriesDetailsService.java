package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.Categories;

public interface CategoriesDetailsService {

	public List<Categories> getCategories();
	
	public Categories getCategoriesById(Integer catId);
	
}
