package com.c4networks.vrms.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.services.dao.CategoriesDAO;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.services.dao.CustomerDetailsDAO;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.vo.Movies;
import com.c4networks.vrms.services.dao.MoviesDAO;

public class MoviesService {

	private static final Logger logger = Logger.getLogger(CustomerDetailsService.class.getName());
	
	public List<Movies> getMoviesList() {
		logger.info("in getMoviesList() of MoviesService");
		List<Movies> moviesList;
		MoviesDAO moviesDAO = new MoviesDAO();
		moviesList = moviesDAO.findAll();
		logger.info("Movies List size :"+moviesList.size());
		
		return moviesList;
	}

	public Integer addMovie(Movies action) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			MoviesDAO dao = new MoviesDAO();
		
			Movies bean = new Movies();
			bean.setMovieName(action.getMovieName().trim());
			bean.setMovieDesc(action.getMovieDesc().trim());
			bean.setCopies(action.getCopies());
			CategoriesDAO categoriesDAO = new CategoriesDAO();
			Categories categories = categoriesDAO.findById(action.getCategories().getCategoryId());
			bean.setCategories(categories);
			CustomerDetailsDAO customerDetailsDAO = new CustomerDetailsDAO();
			CustomerDetails customerDetails = customerDetailsDAO.findById(1);
			bean.setCustomerDetailsByCreatedBy(customerDetails);
			bean.setCreatedDate(new Date());
			bean.setCustomerDetailsByLastModifiedBy(customerDetails);
			bean.setLastModifiedDate(new Date());
			
			dao.save(bean);
			transaction.commit();
			if(transaction.wasCommitted()){
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public Integer getAvailableMovieCopiesById(Integer movieId) {
		MoviesDAO dao = new MoviesDAO();
		Movies bean = dao.findById(movieId);
		return bean.getCopies();
	}

}
