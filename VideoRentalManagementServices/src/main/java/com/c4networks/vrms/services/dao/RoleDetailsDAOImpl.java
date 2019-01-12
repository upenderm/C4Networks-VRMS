package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.RoleDetail;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class RoleDetailsDAOImpl extends BaseHibernateDAO implements RoleDetailsDAO {

	private static final Log log = LogFactory.getLog(RoleDetailsDAOImpl.class);
	public static final String ROLE_NAME = "roleName";

	public void saveRoleDetail(RoleDetail transientInstance) {
		log.debug("saving RoleDetail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteRoleDetail(RoleDetail persistentInstance) {
		log.debug("deleting RoleDetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleDetail findByRoleDetailId(String roleDetailId) {
		log.debug("getting RoleDetail instance with id: " + roleDetailId);
		try {
			RoleDetail instance = (RoleDetail) getSession().get("com.c4networks.vrms.vo.RoleDetail", roleDetailId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RoleDetail> findByProperty(String propertyName, Object value) {
		log.debug("finding RoleDetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RoleDetail as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RoleDetail> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding RoleDetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RoleDetail as model where model." + propertyName + "= ? and model."
					+ propertyName2 + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<RoleDetail> findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	@SuppressWarnings("unchecked")
	public List<RoleDetail> findAll() {
		log.debug("finding all RoleDetail instances");
		try {
			String queryString = "from RoleDetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleDetail merge(RoleDetail detachedInstance) {
		log.debug("merging RoleDetail instance");
		try {
			RoleDetail result = (RoleDetail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}