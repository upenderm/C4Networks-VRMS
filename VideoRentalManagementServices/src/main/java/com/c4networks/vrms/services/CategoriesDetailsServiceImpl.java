package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CategoriesDAO;
import com.c4networks.vrms.vo.Categories;

@Service
public class CategoriesDetailsServiceImpl implements CategoriesDetailsService {
	private static final Logger logger = Logger.getLogger(CategoriesDetailsServiceImpl.class.getName());

	@Autowired
	private CategoriesDAO categoriesDAO;

	public List<Categories> getAllCategoriesForUser(String agentCode, String companyId) {
		logger.info("in getCategories() of CategoriesDetailsService");
		List<Categories> categoriesList = new ArrayList<>();
		try {
			categoriesList = categoriesDAO.findByProperty("agentCode.userId", agentCode, "companyDetails.companyId", companyId);
			logger.info("Categories list size :" + categoriesList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriesList;
	}

	@Override
	public Categories getCategoriesById(String categoryId) {
		logger.info("CustomerDetailsServiceImpl.getCustomerById");
		Categories categories = new Categories();
		try {
			categories = categoriesDAO.findByCategoryId(categoryId);
			logger.info("categories is ::" + categories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

}
