package com.c4networks.vrms.services.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.c4networks.vrms.services.hibernate.BaseHibernateDAO;
import com.c4networks.vrms.vo.Movies;

/**
 * Data access object (DAO) for domain model class Movies.
 * 
 * @see com.vrm.hibernate.Movies
 * @author MyEclipse Persistence Tools
 */

@Repository
public class MoviesDAOImpl extends BaseHibernateDAO implements MoviesDAO{
	private static final Log log = LogFactory.getLog(MoviesDAOImpl.class);
	// property constants
	public static final String MOVIE_NAME = "movieName";
	public static final String MOVIE_DESC = "movieDesc";

	public void save(Movies transientInstance) {
		log.debug("saving Movies instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movies persistentInstance) {
		log.debug("deleting Movies instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movies findById(java.lang.Integer id) {
		log.debug("getting Movies instance with id: " + id);
		try {
			Movies instance = (Movies) getSession().get(
					"com.c4networks.vrms.vo.Movies", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movies instance) {
		log.debug("finding Movies instance by example");
		try {
			List results = getSession().createCriteria(
					"com.c4networks.vrms.vo.Movies").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Movies instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movies as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieName(Object movieName) {
		return findByProperty(MOVIE_NAME, movieName);
	}

	public List findByMovieDesc(Object movieDesc) {
		return findByProperty(MOVIE_DESC, movieDesc);
	}

	public List<Movies> findAll() {
		log.debug("finding all Movies instances");
		try {
			String queryString = "from Movies";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movies merge(Movies detachedInstance) {
		log.debug("merging Movies instance");
		try {
			Movies result = (Movies) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movies instance) {
		log.debug("attaching dirty Movies instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movies instance) {
		log.debug("attaching clean Movies instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}