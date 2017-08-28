package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.CustomerDetails;

/**
 * Data access object (DAO) for domain model class CustomerDetails.
 * 
 * @see com.vrm.hibernate.CustomerDetails
 * @author MyEclipse Persistence Tools
 */

@Repository
public class CustomerDetailsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CustomerDetailsDAO.class);
	// property constants
	public static final String VRMSID = "vrmsId";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String MOBILE = "mobile";
	public static final String CREATED_BY = "createdBy";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String STATUS = "status";

	public void save(CustomerDetails transientInstance) {
		log.debug("saving CustomerDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CustomerDetails persistentInstance) {
		log.debug("deleting CustomerDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomerDetails findById(java.lang.Integer id) {
		log.debug("getting CustomerDetails instance with id: " + id);
		try {
			CustomerDetails instance = (CustomerDetails) getSession().get(
					"com.vrm.hibernate.CustomerDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CustomerDetails> findByExample(CustomerDetails instance) {
		log.debug("finding CustomerDetails instance by example");
		try {
			List<CustomerDetails> results = getSession().createCriteria(
					"com.vrm.hibernate.CustomerDetails").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<CustomerDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding CustomerDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerDetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CustomerDetails> findByVrmsId(Object vrmsId) {
		return findByProperty(VRMSID, vrmsId);
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

	public List<CustomerDetails> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
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
			CustomerDetails result = (CustomerDetails) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CustomerDetails instance) {
		log.debug("attaching dirty CustomerDetails instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustomerDetails instance) {
		log.debug("attaching clean CustomerDetails instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<String> getMaxVrmsReference() {
		log.debug("finding CustomerDetails instance");
		try {
			String queryString = "select max(vrmsId)from CustomerDetails customerDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}