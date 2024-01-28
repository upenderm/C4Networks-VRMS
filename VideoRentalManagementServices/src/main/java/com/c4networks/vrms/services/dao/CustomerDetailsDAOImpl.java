package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.AgentCustomerDetails;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class CustomerDetailsDAOImpl extends BaseHibernateDAO implements CustomerDetailsDAO {
	private static final Log log = LogFactory.getLog(CustomerDetailsDAOImpl.class);
	// property constants
	public static final String CUSTOMERID = "customerId";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String MOBILE = "mobile";
	public static final String CREATED_BY = "createdBy";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String STATUS = "status";
	public static final String DOCUMENT_ID = "documentID";

	public void saveCustomerDetail(AgentCustomerDetails transientInstance) {
		log.debug("saving AgentCustomerDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteCustomerDetail(AgentCustomerDetails persistentInstance) {
		log.debug("deleting AgentCustomerDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AgentCustomerDetails findByCustomerId(String id) {
		log.debug("getting AgentCustomerDetails instance with id: " + id);
		try {
			AgentCustomerDetails instance = (AgentCustomerDetails) getSession().get("com.c4networks.vrms.vo.AgentCustomerDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AgentCustomerDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding AgentCustomerDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from AgentCustomerDetails as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AgentCustomerDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding AgentCustomerDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from AgentCustomerDetails as model where model.agentCode." + propertyName + "= ? and model.companyDetails."
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

	public List<AgentCustomerDetails> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<AgentCustomerDetails> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<AgentCustomerDetails> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<AgentCustomerDetails> findByDocumentID(Object documentID) {
		return findByProperty(DOCUMENT_ID, documentID);
	}

	public List<AgentCustomerDetails> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<AgentCustomerDetails> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<AgentCustomerDetails> findByCreatedBy(Object createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List<AgentCustomerDetails> findByLastModifiedBy(Object lastModifiedBy) {
		return findByProperty(LAST_MODIFIED_BY, lastModifiedBy);
	}

	public List<AgentCustomerDetails> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	@SuppressWarnings("unchecked")
	public List<AgentCustomerDetails> findAll() {
		log.debug("finding all AgentCustomerDetails instances");
		try {
			String queryString = "from AgentCustomerDetails agentCustomerDetails where agentCustomerDetails.customerId != 1";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AgentCustomerDetails merge(AgentCustomerDetails detachedInstance) {
		log.debug("merging AgentCustomerDetails instance");
		try {
			AgentCustomerDetails result = (AgentCustomerDetails) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getMaxVrmsReference() {
		log.debug("finding AgentCustomerDetails instance");
		try {
			String queryString = "select max(Id)from AgentCustomerDetails agentCustomerDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}