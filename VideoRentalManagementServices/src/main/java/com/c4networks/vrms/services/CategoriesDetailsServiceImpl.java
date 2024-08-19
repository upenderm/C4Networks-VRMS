package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CategoriesDAO;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.AlphaNumerciRandomGenerator;
import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.UserDetails;

@Service
public class CategoriesDetailsServiceImpl implements CategoriesDetailsService {
	private static final Logger logger = Logger.getLogger(CategoriesDetailsServiceImpl.class.getName());

	@Autowired
	private CategoriesDAO categoriesDAO;

	public List<Categories> getAllCategoriesForUser(String companyId) {
		logger.info("in getCategories() of CategoriesDetailsService");
		List<Categories> categoriesList = new ArrayList<>();
		try {
			categoriesList = categoriesDAO.findByProperty("companyDetails.companyOID", companyId);
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

	@Override
	public Integer addCategory(Categories category, UserDetails userDetails) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			Categories bean = new Categories();
			bean.setCategoryId(AlphaNumerciRandomGenerator.generateAlphaNumericSeqForCategoryID());
			bean.setCategoryName(category.getCategoryName().trim());
			bean.setCategoryDesc(category.getCategoryDesc().trim());
			bean.setActivePrice(category.getActivePrice());
			bean.setInitialPrice(category.getInitialPrice());
			bean.setBonus(category.getBonus());
			bean.setStatus(category.getStatus());
			bean.setCompanyDetails(userDetails.getCompanyDetails());
			bean.setCreatedBy(userDetails);
			bean.setCreatedDate(new Date());
			bean.setLastModifiedBy(userDetails);
			bean.setLastModifiedDate(new Date());
			categoriesDAO.saveCategory(bean);
			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Integer deleteCategory(Categories category) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			categoriesDAO.deleteCategory(category);

			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
