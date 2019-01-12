package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.UserSecurity;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class UserSecurityDAOImpl extends BaseHibernateDAO implements UserSecurityDAO {

	private static final Log log = LogFactory.getLog(UserSecurityDAOImpl.class);
	public static final String STATUS = "status";

	public void saveUserSecurity(UserSecurity userSecurity) {
		log.debug("saving UserSecurity userSecurity");
		try {
			getSession().save(userSecurity);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteUserSecurity(UserSecurity userSecurity) {
		log.debug("deleting UserSecurity instance");
		try {
			getSession().delete(userSecurity);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserSecurity findUserSecurityByUserName(String userName) {
		log.debug("getting UserSecurity instance with id: " + userName);
		try {
			UserSecurity instance = (UserSecurity) getSession().get("com.c4networks.vrms.vo.UserSecurity", userName);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserSecurity> findByProperty(String propertyName, Object value) {
		log.debug("finding UserSecurity instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from UserSecurity as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserSecurity> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding UserSecurity instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from UserSecurity as model where model." + propertyName + "= ? and model." + propertyName2
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

	public List<UserSecurity> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	@SuppressWarnings("unchecked")
	public List<UserSecurity> findAll() {
		log.debug("finding all UserSecurity instances");
		try {
			String queryString = "from UserSecurity";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserSecurity merge(UserSecurity userSecurity) {
		log.debug("merging UserSecurity userSecurity");
		try {
			UserSecurity result = (UserSecurity) getSession().merge(userSecurity);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}