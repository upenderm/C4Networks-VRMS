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
import com.c4networks.vrms.services.dao.MovieDetailsDAO;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.AlphaNumerciRandomGenerator;
import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.UserDetails;

@Service
public class MoviesServiceImpl implements MoviesService {
	private static final Logger logger = Logger.getLogger(MoviesServiceImpl.class.getName());

	@Autowired
	private MovieDetailsDAO moviesDAO;

	@Autowired
	private CategoriesDAO categoriesDAO;

	@Override
	public List<MovieDetails> getMoviesList(String companyId) {
		logger.info("in getMoviesList() of MoviesServiceImpl");
		List<MovieDetails> moviesList = new ArrayList<>();
		try {
			moviesList = moviesDAO.findByProperty("companyDetails.companyOID", companyId);
			logger.info("Movies List size :" + moviesList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	@Override
	public Integer addMovie(MovieDetails movie, String categoryId, UserDetails userDetails) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			MovieDetails bean = new MovieDetails();
			bean.setMovieId(AlphaNumerciRandomGenerator.generateAlphaNumericSeqForMovieID());
			bean.setMovieName(movie.getMovieName().trim());
			bean.setMovieDesc(movie.getMovieDesc().trim());
			bean.setAgentCode(userDetails);
			bean.setCompanyDetails(userDetails.getCompanyDetails());
			bean.setCreatedBy(userDetails);
			bean.setCreatedDate(new Date());
			bean.setLastModifiedBy(userDetails);
			bean.setLastModifiedDate(new Date());
			bean.setStatus("ACTIVE");
			bean.setTotalCopies(movie.getTotalCopies());
			bean.setAvailableCopies(movie.getAvailableCopies());
			Categories categories = categoriesDAO.findByCategoryId(categoryId);
			bean.setCategories(categories);
			moviesDAO.saveMovieDetail(bean);
			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Integer getAvailableMovieCopiesById(String movieId, String userId, String companyId) {
		Integer result = 0;
		try {
			List<MovieDetails> bean = moviesDAO.findByProperty("movieId", movieId, "agentCode.userId", userId, "companyDetails.companyId", companyId);
			result = (bean.get(0)==null)?0:bean.get(0).getAvailableCopies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
