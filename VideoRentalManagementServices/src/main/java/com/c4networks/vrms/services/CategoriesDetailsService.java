package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.UserDetails;

public interface CategoriesDetailsService {

	public List<Categories> getAllCategoriesForUser(String companyId);
	
	public Categories getCategoriesById(String categoryId);
	
	public Integer addCategory(Categories category, UserDetails userDetails);
	
	public Integer deleteCategory(Categories category);
	
}
