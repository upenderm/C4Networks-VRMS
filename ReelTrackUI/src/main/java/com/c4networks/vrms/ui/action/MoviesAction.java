package com.c4networks.vrms.ui.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.UserDetails;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;
import com.opensymphony.xwork2.ActionSupport;

public class MoviesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MoviesAction.class.getName());
	private final String ADDMOVIE = "addmovie";
	private final String DEFINEMOVIE = "definemovie";

	private String movieName;
	private String movieDesc;
	private String categoryId;
	private Integer availableCopies;

	@SkipValidation
	public String viewMoviesList() {
		logger.info("In viewMoviesList() of MoviesAction");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		List<MovieDetails> moviesList = VideoRentalManagementClient.getInstance().getMoviesList(userDetails.getCompanyDetails().getCompanyOID());
		logger.info("list size:" + moviesList.size());
		session.setAttribute("moviesList", moviesList);

		return SUCCESS;
	}

	public String addMovie() {
		String RESULT = SUCCESS;
		logger.info("In addMovie() of MoviesAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		MovieDetails bean = new MovieDetails();
		bean.setMovieName(this.getMovieName().trim());
		bean.setMovieDesc(this.getMovieDesc().trim());
		bean.setAvailableCopies(this.getAvailableCopies());
		//		CategoriesDAO categoriesDAO = new CategoriesDAO();
		//		Categories categories = categoriesDAO.findById(action.getCategories());
		//		bean.setCategories(categories);
		//		CustomerDetailsDAO customerDetailsDAO = new CustomerDetailsDAO();
		//		CustomerDetails customerDetails = customerDetailsDAO.findById(1);
		//		bean.setCustomerDetailsByCreatedBy(customerDetails);
		//		bean.setCreatedDate(new Date());
		//		bean.setCustomerDetailsByLastModifiedBy(customerDetails);
		//		bean.setLastModifiedDate(new Date());
		Integer result = VideoRentalManagementClient.getInstance().addMovie(bean, categoryId, userDetails);
		if (result == 1) {
			this.addActionMessage("Movie creation successfull !..");
			RESULT = ADDMOVIE;
		} else {
			this.addActionError("Movie creation failed...");
			RESULT = DEFINEMOVIE;
		}
		return RESULT;

	}

	@SkipValidation
	public String defineMovie() {
		logger.info("In defineMovie() of MoviesAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		Map<String, String> categoriesMap = new HashMap<>();
		List<Categories> categoriesList = VideoRentalManagementClient.getInstance()
				.getAllCategoriesForUser(userDetails.getCompanyDetails().getCompanyOID());
		Iterator<Categories> iter = categoriesList.iterator();
		while (iter.hasNext()) {
			Categories bean = iter.next();
			categoriesMap.put(bean.getCategoryId(), bean.getCategoryName());
		}
		session.setAttribute("categoriesMap", categoriesMap);

		return DEFINEMOVIE;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
