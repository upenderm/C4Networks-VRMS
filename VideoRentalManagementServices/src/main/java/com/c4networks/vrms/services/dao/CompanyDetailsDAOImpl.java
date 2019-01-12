package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.CompanyDetail;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class CompanyDetailsDAOImpl extends BaseHibernateDAO implements CompanyDetailsDAO {
	private static final Log log = LogFactory.getLog(CategoriesDAOImpl.class);
	// property constants
	public static final String COMPANY_NAME = "companyName";
	public static final String COMPANY_DESC = "companyDesc";
	public static final String STATE = "state";
	public static final String REGISTERED_NUM = "registeredNum";

	@Override
	public void saveCompanyDetails(CompanyDetail companyDetail) {
		log.debug("saving CompanyDetail instance");
		try {
			getSession().save(companyDetail);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void deleteCompanyDetails(CompanyDetail companyDetail) {
		log.debug("deleting CompanyDetail instance");
		try {
			getSession().delete(companyDetail);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public CompanyDetail findByCompanyDetailsId(String companyId) {
		log.debug("getting CompanyDetail instance with id: " + companyId);
		try {
			CompanyDetail instance = (CompanyDetail) getSession().get("com.c4networks.vrms.vo.CompanyDetail",
					companyId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyDetail> findByProperty(String propertyName, Object value) {
		log.debug("finding CompanyDetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CompanyDetail as model where model." + propertyName + "= ?";
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
	public List<CompanyDetail> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding CompanyDetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CompanyDetail as model where model." + propertyName + "= ? and model."
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

	public List<CompanyDetail> findByCompanyName(Object companyName) {
		return findByProperty(COMPANY_NAME, companyName);
	}

	public List<CompanyDetail> findByCompanyDesc(Object companyDesc) {
		return findByProperty(COMPANY_DESC, companyDesc);
	}

	public List<CompanyDetail> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<CompanyDetail> findByRegisteredNum(Object registeredNum) {
		return findByProperty(REGISTERED_NUM, registeredNum);
	}

	@SuppressWarnings("unchecked")
	public List<CompanyDetail> findAll() {
		log.debug("finding all CompanyDetail instances");
		try {
			String queryString = "from CompanyDetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyDetail merge(CompanyDetail detachedInstance) {
		log.debug("merging CompanyDetail instance");
		try {
			CompanyDetail result = (CompanyDetail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}