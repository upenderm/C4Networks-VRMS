package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.RentalDetails;

/**
 * Data access object (DAO) for domain model class RentalDetails.
 * 
 * @see com.vrm.hibernate.RentalDetails
 * @author MyEclipse Persistence Tools
 */

@Repository
public class RentalDetailsDAOImpl extends BaseHibernateDAO implements RentalDetailsDAO{
	private static final Log log = LogFactory.getLog(RentalDetailsDAOImpl.class);
	// property constants
	public static final String RENTAL_ID = "rentalId";
	public static final String BONUS_POINTS = "bonusPoints";
	public static final String BONUS_STATUS = "bonusStatus";
	public static final String LATE_CHARGES = "lateCharges";
	public static final String RENTAL_STATUS = "rentalStatus";
	public static final String COMMENTS = "comments";

	public void save(RentalDetails transientInstance) {
		log.debug("saving RentalDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RentalDetails persistentInstance) {
		log.debug("deleting RentalDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RentalDetails findById(java.lang.Integer id) {
		log.debug("getting RentalDetails instance with id: " + id);
		try {
			RentalDetails instance = (RentalDetails) getSession().get(
					"com.c4networks.vrms.vo.RentalDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RentalDetails instance) {
		log.debug("finding RentalDetails instance by example");
		try {
			List results = getSession().createCriteria(
					"com.c4networks.vrms.vo.RentalDetails").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<RentalDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding RentalDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RentalDetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<RentalDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding RentalDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RentalDetails as model where model."
					+ propertyName + "= ? and model." + propertyName2 + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVrsId(Object rentalId) {
		return findByProperty(RENTAL_ID, rentalId);
	}

	public List findByBonusPoints(Object bonusPoints) {
		return findByProperty(BONUS_POINTS, bonusPoints);
	}

	public List findByBonusStatus(Object bonusStatus) {
		return findByProperty(BONUS_STATUS, bonusStatus);
	}

	public List findByLateCharges(Object lateCharges) {
		return findByProperty(LATE_CHARGES, lateCharges);
	}
	
	public List findByRentalStatus(Object rentalStatus) {
		return findByProperty(RENTAL_STATUS, rentalStatus);
	}
	
	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

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
			RentalDetails result = (RentalDetails) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RentalDetails instance) {
		log.debug("attaching dirty RentalDetails instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RentalDetails instance) {
		log.debug("attaching clean RentalDetails instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
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