package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.Categories;

public interface CategoriesDetailsService {

	public List<Categories> getAllCategoriesForUser(String agentCode, String companyId);
	
	public Categories getCategoriesById(String categoryId);
	
}
