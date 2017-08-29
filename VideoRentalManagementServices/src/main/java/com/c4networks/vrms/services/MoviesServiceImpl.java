package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CategoriesDAO;
import com.c4networks.vrms.services.dao.CustomerDetailsDAO;
import com.c4networks.vrms.services.dao.MoviesDAO;
import com.c4networks.vrms.services.dao.MoviesDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.Movies;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesDAO moviesDAO;

	@Autowired
	private CategoriesDAO categoriesDAO;

	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;

	private static final Logger logger = Logger.getLogger(CustomerDetailsServiceImpl.class.getName());

	public List<Movies> getMoviesList() {
		logger.info("in getMoviesList() of MoviesService");
		List<Movies> moviesList = new ArrayList<>();
		try {
			moviesList = moviesDAO.findAll();
			logger.info("Movies List size :" + moviesList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	public Integer addMovie(Movies movie) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			Movies bean = new Movies();
			bean.setMovieName(movie.getMovieName().trim());
			bean.setMovieDesc(movie.getMovieDesc().trim());
			bean.setCopies(movie.getCopies());
			Categories categories = categoriesDAO.findById(movie.getCategories().getCategoryId());
			bean.setCategories(categories);
			CustomerDetails customerDetails = customerDetailsDAO.findById(1);
			bean.setCustomerDetailsByCreatedBy(customerDetails);
			bean.setCreatedDate(new Date());
			bean.setCustomerDetailsByLastModifiedBy(customerDetails);
			bean.setLastModifiedDate(new Date());

			moviesDAO.save(bean);
			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public Integer getAvailableMovieCopiesById(Integer movieId) {
		Integer result = 0;
		try {
			Movies bean = moviesDAO.findById(movieId);
			result = bean.getCopies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
