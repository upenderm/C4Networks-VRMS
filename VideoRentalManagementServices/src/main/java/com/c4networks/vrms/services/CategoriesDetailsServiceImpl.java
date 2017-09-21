package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CategoriesDAO;
import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.CustomerDetails;

@Service
public class CategoriesDetailsServiceImpl implements CategoriesDetailsService {
	private static final Logger logger = Logger.getLogger(CategoriesDetailsServiceImpl.class.getName());

	@Autowired
	private CategoriesDAO categoriesDAO;

	public List<Categories> getCategories() {
		logger.info("in getCategories() of CategoriesDetailsService");
		List<Categories> categoriesList = new ArrayList<>();
		try {
			categoriesList = categoriesDAO.findAll();
			logger.info("Categories list size :" + categoriesList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriesList;
	}

	@Override
	public Categories getCategoriesById(Integer catId) {
		logger.info("CustomerDetailsServiceImpl.getCustomerById");
		Categories categories = new Categories();
		try {
			categories = categoriesDAO.findById(catId);
			logger.info("categories is ::" + categories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

}
