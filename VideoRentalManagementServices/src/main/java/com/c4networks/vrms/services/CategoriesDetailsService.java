package com.c4networks.vrms.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.services.dao.CategoriesDAO;

public class CategoriesDetailsService {
	private static final Logger logger = Logger.getLogger(CategoriesDetailsService.class.getName());
	
	public List<Categories> getCategories(){
		logger.info("in getCategories() of CategoriesDetailsService");
		List<Categories> categoriesList;
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		categoriesList = categoriesDAO.findAll();
		logger.info("Categories list size :"+categoriesList.size());
		
		return categoriesList;
	}

}
