package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.UserDetails;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class UserDetailsDAOImpl extends BaseHibernateDAO implements UserDetailsDAO {

	private static final Log log = LogFactory.getLog(UserDetailsDAOImpl.class);
	public static final String USER_NAME = "userName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String MOBILE = "mobile";
	public static final String CREATED_BY = "createdBy";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String STATUS = "status";
	public static final String DOCUMENT_ID = "documentID";
	public static final String ROLE_ID = "roleId";
	public static final String AGENT_CODE = "agentCode";

	public void saveUserDetails(UserDetails transientInstance) {
		log.debug("saving UserDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteUserDetails(UserDetails persistentInstance) {
		log.debug("deleting UserDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserDetails findByUserId(String id) {
		log.debug("getting UserDetails instance with id: " + id);
		try {
			UserDetails instance = (UserDetails) getSession().get("com.c4networks.vrms.vo.UserDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding UserDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from UserDetails as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding UserDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from UserDetails as model where model." + propertyName + "= ? and model.= "
					+ propertyName2 + "?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public UserDetails findByUserName(String userName) {
		return findByProperty(USER_NAME, userName).get(0);
	}

	public List<UserDetails> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<UserDetails> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<UserDetails> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<UserDetails> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<UserDetails> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<UserDetails> findByCreatedBy(String createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List<UserDetails> findByLastModifiedBy(String lastModifiedBy) {
		return findByProperty(LAST_MODIFIED_BY, lastModifiedBy);
	}

	public List<UserDetails> findByStatus(String status) {
		return findByProperty(STATUS, status);
	}

	public List<UserDetails> findByDocumentID(String documentID) {
		return findByProperty(DOCUMENT_ID, documentID);
	}

	public List<UserDetails> findByRoleId(String roleId) {
		return findByProperty(ROLE_ID, roleId);
	}

	public List<UserDetails> findByAgentCode(String agentCode) {
		return findByProperty(AGENT_CODE, agentCode);
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> findAll() {
		log.debug("finding all UserDetails instances");
		try {
			String queryString = "from UserDetails userDetails where userDetails.userId != 1";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserDetails merge(UserDetails detachedInstance) {
		log.debug("merging UserDetails instance");
		try {
			UserDetails result = (UserDetails) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getMaxVrmsReference() {
		log.debug("finding UserDetails instance");
		try {
			String queryString = "select max(Id)from UserDetails userDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}