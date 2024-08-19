package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.RentalDetails;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class RentalDetailsDAOImpl extends BaseHibernateDAO implements RentalDetailsDAO {
	private static final Log log = LogFactory.getLog(RentalDetailsDAOImpl.class);
	// property constants
	public static final String RENTAL_ID = "rentalId";
	public static final String CUSTOMER_ID = "customerId";
	public static final String AGENT_CODE = "agentCode";
	public static final String COMPANY_ID = "companyId";
	public static final String STATUS = "status";
	public static final String MOVIE_ID = "movieId";

	public void saveRentalDetails(RentalDetails rentalDetails) {
		log.debug("saving RentalDetails instance");
		try {
			getSession().save(rentalDetails);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void deleteRentalDetails(RentalDetails rentalDetails) {
		log.debug("deleting RentalDetails instance");
		try {
			getSession().delete(rentalDetails);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RentalDetails findByRentalId(String rentalId) {
		log.debug("getting RentalDetails instance with id: " + rentalId);
		try {
			RentalDetails instance = (RentalDetails) getSession().get("com.c4networks.vrms.vo.RentalDetails", rentalId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RentalDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding RentalDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RentalDetails as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RentalDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding RentalDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RentalDetails as model where model." + propertyName + "= ? and model."
					+ propertyName2 + "= ?";
//			getSession().refresh(RentalDetails.class);
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
	public List<RentalDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2,
			String propertyName3, Object value3) {
		log.debug("finding RentalDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RentalDetails as model where model." + propertyName + "= ? and model."
					+ propertyName2 + "= ? and model." + propertyName3 + "= ?";
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

	public List<RentalDetails> findByRentalId(Object rentalId) {
		return findByProperty(RENTAL_ID, rentalId);
	}

	public List<RentalDetails> findByCustomerId(Object customerId) {
		return findByProperty(CUSTOMER_ID, customerId);
	}

	public List<RentalDetails> findByAgentCode(Object agentCode) {
		return findByProperty(AGENT_CODE, agentCode);
	}

	public List<RentalDetails> findByCompanyId(Object CompanyId) {
		return findByProperty(COMPANY_ID, CompanyId);
	}

	public List<RentalDetails> findByRentalStatus(Object rentalStatus) {
		return findByProperty(STATUS, rentalStatus);
	}

	public List<RentalDetails> findByMovieId(Object movieId) {
		return findByProperty(MOVIE_ID, movieId);
	}

	@SuppressWarnings("unchecked")
	public List<RentalDetails> findAll() {
		log.debug("finding all RentalDetails instances");
		try {
			String queryString = "from RentalDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RentalDetails merge(RentalDetails detachedInstance) {
		log.debug("merging RentalDetails instance");
		try {
			RentalDetails result = (RentalDetails) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getMaxRentalReference() {
		log.debug("finding RentalDetails instance");
		try {
			String queryString = "select max(rentalId)from RentalDetails rentalDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}