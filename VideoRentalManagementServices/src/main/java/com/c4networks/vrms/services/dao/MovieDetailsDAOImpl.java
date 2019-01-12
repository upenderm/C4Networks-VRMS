package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.MovieDetails;

/**
 * 
 * @author M Upender
 *
 */

@Repository
public class MovieDetailsDAOImpl extends BaseHibernateDAO implements MovieDetailsDAO {
	private static final Log log = LogFactory.getLog(MovieDetailsDAOImpl.class);
	// property constants
	public static final String MOVIE_NAME = "movieName";
	public static final String AGENT_CODE = "agentCode";
	public static final String COMPANY_ID = "companyId";

	@Override
	public void saveMovieDetail(MovieDetails movieDetail) {
		log.debug("saving MovieDetails instance");
		try {
			getSession().save(movieDetail);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void deleteMovieDetail(MovieDetails movieDetail) {
		log.debug("deleting MovieDetails instance");
		try {
			getSession().delete(movieDetail);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public MovieDetails findByMovieId(String movieId) {
		log.debug("getting MovieDetails instance with id: " + movieId);
		try {
			MovieDetails instance = (MovieDetails) getSession().get("com.c4networks.vrms.vo.MovieDetails", movieId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieDetails> findByProperty(String propertyName, Object value) {
		log.debug("finding MovieDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from MovieDetails as model where model." + propertyName + "= ?";
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
	public List<MovieDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2) {
		log.debug("finding MovieDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from MovieDetails as model where model." + propertyName + "= ? and model."
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2, String propertyName3, Object value3) {
		log.debug("finding MovieDetails instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from MovieDetails as model where model." + propertyName + "= ? and model."
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

	public List<MovieDetails> findByMovieName(Object movieName) {
		return findByProperty(MOVIE_NAME, movieName);
	}

	public List<MovieDetails> findByAgentCode(Object agentCode) {
		return findByProperty(AGENT_CODE, agentCode);
	}

	public List<MovieDetails> findByCompanyId(Object companyId) {
		return findByProperty(COMPANY_ID, companyId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieDetails> findAll() {
		log.debug("finding all MovieDetails instances");
		try {
			String queryString = "from MovieDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieDetails merge(MovieDetails detachedInstance) {
		log.debug("merging MovieDetails instance");
		try {
			MovieDetails result = (MovieDetails) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}