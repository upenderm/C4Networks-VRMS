package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.CustomerBonus;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class CustomerBonusDAOImpl extends BaseHibernateDAO implements CustomerBonusDAO {
	
	private static final Log log = LogFactory.getLog(CustomerBonusDAOImpl.class);
	public static final String BONUS_POINTS = "bonusPoints";
	public static final String BONUS_VERSION = "bonusVersion";

	@Override
	public void saveCustomerBonus(CustomerBonus transientInstance) {
		log.debug("saving CustomerBonus instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void deleteCustomerBonus(CustomerBonus persistentInstance) {
		log.debug("deleting CustomerBonus instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public CustomerBonus findBonusByCustomerId(String customerId) {
		log.debug("getting CustomerBonus instance with customer id: " + customerId);
		try {
			CustomerBonus instance = (CustomerBonus) getSession().get("com.c4networks.vrms.vo.CustomerBonus",
					customerId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerBonus> findByProperty(String propertyName, Object value) {
		log.debug("finding CustomerBonus instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerBonus as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerBonus> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding CustomerBonus instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerBonus as model where model." + propertyName + "= ? and model."
					+ propertyName2 + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			re.printStackTrace();
			throw re;
		}
	}

	public List<CustomerBonus> findByPoints(Integer bonusPoints) {
		return findByProperty(BONUS_POINTS, bonusPoints);
	}

	public List<CustomerBonus> findByBonusVersion(Integer bonusVersion) {
		return findByProperty(BONUS_VERSION, bonusVersion);
	}

	@SuppressWarnings("unchecked")
	public List<CustomerBonus> findAll() {
		log.debug("finding all CustomerBonus instances");
		try {
			String queryString = "from CustomerBonus";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CustomerBonus merge(CustomerBonus detachedInstance) {
		log.debug("merging CustomerBonus instance");
		try {
			CustomerBonus result = (CustomerBonus) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}