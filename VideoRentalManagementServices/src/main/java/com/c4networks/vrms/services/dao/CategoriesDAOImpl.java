package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.Categories;

/**
 * Data access object (DAO) for domain model class Categories.
 * 
 * @see com.c4networks.vrms.vo.Categories
 * @author MyEclipse Persistence Tools
 */

@Repository
public class CategoriesDAOImpl extends BaseHibernateDAO implements CategoriesDAO {
	private static final Log log = LogFactory.getLog(CategoriesDAOImpl.class);
	// property constants
	public static final String CATEGORY_NAME = "categoryName";
	public static final String CATEGORY_DESC = "categoryDesc";
	public static final String STATUS = "status";
	public static final String PRICE = "price";

	public void save(Categories transientInstance) {
		log.debug("saving Categories instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Categories persistentInstance) {
		log.debug("deleting Categories instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categories findById(java.lang.Integer id) {
		log.debug("getting Categories instance with id: " + id);
		try {
			Categories instance = (Categories) getSession().get(
					"com.c4networks.vrms.vo.Categories", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Categories> findByExample(Categories instance) {
		log.debug("finding Categories instance by example");
		try {
			
			List<Categories> results = getSession().createCriteria(
					"com.c4networks.vrms.vo.Categories").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Categories> findByProperty(String propertyName, Object value) {
		log.debug("finding Categories instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Categories as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Categories> findByCategoryName(Object categoryName) {
		return findByProperty(CATEGORY_NAME, categoryName);
	}

	public List<Categories> findByCategoryDesc(Object categoryDesc) {
		return findByProperty(CATEGORY_DESC, categoryDesc);
	}

	public List<Categories> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
	public List<Categories> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

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
			Categories result = (Categories) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Categories instance) {
		log.debug("attaching dirty Categories instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Categories instance) {
		log.debug("attaching clean Categories instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}