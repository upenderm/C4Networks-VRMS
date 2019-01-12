package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.Categories;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class CategoriesDAOImpl extends BaseHibernateDAO implements CategoriesDAO {
	private static final Log log = LogFactory.getLog(CategoriesDAOImpl.class);
	// property constants
	public static final String CATEGORY_NAME = "categoryName";
	public static final String CATEGORY_DESC = "categoryDesc";
	public static final String STATUS = "status";
	public static final String PRICE = "price";

	public void saveCategory(Categories transientInstance) {
		log.debug("saving Categories instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteCategory(Categories persistentInstance) {
		log.debug("deleting Categories instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categories findByCategoryId(String categoryId) {
		log.debug("getting Categories instance with id: " + categoryId);
		try {
			Categories instance = (Categories) getSession().get("com.c4networks.vrms.vo.Categories", categoryId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categories> findByProperty(String propertyName, String value) {
		log.debug("finding Categories instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Categories as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categories> findByProperty(String propertyName, String value, String propertyName2, String value2) {
		log.debug("finding Categories instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Categories as model where model." + propertyName + "= ? and model." + propertyName2
					+ "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categories> findByProperty(String propertyName, String value, String propertyName2, String value2,
			String propertyName3, String value3) {
		log.debug("finding Categories instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Categories as model where model." + propertyName + "= ? and model." + propertyName2
					+ "= ? and model." + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, value2);
			queryObject.setParameter(2, value3);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Categories> findByCategoryName(String categoryName) {
		return findByProperty(CATEGORY_NAME, categoryName);
	}

	public List<Categories> findByCategoryDesc(String categoryDesc) {
		return findByProperty(CATEGORY_DESC, categoryDesc);
	}

	public List<Categories> findByStatus(String status) {
		return findByProperty(STATUS, status);
	}

	public List<Categories> findByPrice(String price) {
		return findByProperty(PRICE, price);
	}

	@SuppressWarnings("unchecked")
	public List<Categories> findAll() {
		log.debug("finding all Categories instances");
		try {
			String queryString = "from Categories";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Categories merge(Categories detachedInstance) {
		log.debug("merging Categories instance");
		try {
			Categories result = (Categories) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}