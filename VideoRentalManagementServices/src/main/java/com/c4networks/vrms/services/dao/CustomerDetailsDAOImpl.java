package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.CustomerDetails;

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
	public static final String AADHAAR = "aadhaar";

	public void saveCustomerDetail(CustomerDetails transientInstance) {
		log.debug("saving CustomerDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteCustomerDetail(CustomerDetails persistentInstance) {
		log.debug("deleting CustomerDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomerDetails findByCustomerId(String id) {
		log.debug("getting CustomerDetails instance with id: " + id);
		try {
			CustomerDetails instance = (CustomerDetails) getSession().get("com.c4networks.vrms.vo.CustomerDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CustomerDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding CustomerDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerDetails as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CustomerDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding CustomerDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerDetails as model where model.agentCode." + propertyName + "= ? and model.companyDetails."
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

	public List<CustomerDetails> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<CustomerDetails> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<CustomerDetails> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<CustomerDetails> findByAadhaar(Object aadhaar) {
		return findByProperty(AADHAAR, aadhaar);
	}

	public List<CustomerDetails> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<CustomerDetails> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<CustomerDetails> findByCreatedBy(Object createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List<CustomerDetails> findByLastModifiedBy(Object lastModifiedBy) {
		return findByProperty(LAST_MODIFIED_BY, lastModifiedBy);
	}

	public List<CustomerDetails> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	@SuppressWarnings("unchecked")
	public List<CustomerDetails> findAll() {
		log.debug("finding all CustomerDetails instances");
		try {
			String queryString = "from CustomerDetails customerDetails where customerDetails.customerId != 1";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CustomerDetails merge(CustomerDetails detachedInstance) {
		log.debug("merging CustomerDetails instance");
		try {
			CustomerDetails result = (CustomerDetails) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getMaxVrmsReference() {
		log.debug("finding CustomerDetails instance");
		try {
			String queryString = "select max(Id)from CustomerDetails customerDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}