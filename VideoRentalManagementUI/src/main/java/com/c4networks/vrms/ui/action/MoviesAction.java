package com.c4networks.vrms.ui.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.Movies;
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
	private Integer categories;
	private Integer copies;
	
	public String viewMoviesList(){
		logger.info("In viewMoviesList() of MoviesAction");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Movies> moviesList = VideoRentalManagementClient.getInstance().getMoviesList();
		logger.info("list size:" + moviesList.size());
		session.setAttribute("moviesList", moviesList);
		
		return SUCCESS;
	}
	
	public String addMovie(){
		String RESULT = SUCCESS;
		logger.info("In addMovie() of MoviesAction");
		Movies bean = new Movies();
		Integer result = VideoRentalManagementClient.getInstance().addMovie(bean);
		if (result == 1){
			this.addActionMessage("Movie creation successfull !..");
			RESULT = ADDMOVIE;
		}else{
			this.addActionError("Movie creation failed...");
			RESULT = DEFINEMOVIE;
		}
		return RESULT;
		
	}
	
	public String defineMovie(){
		logger.info("In defineMovie() of MoviesAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map<Integer, String> categoriesMap = new HashMap<Integer, String>();
		List<Categories> categoriesList = VideoRentalManagementClient.getInstance().getCategories();
		Iterator<Categories> iter = categoriesList.iterator();
		while(iter.hasNext()){
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

	public Integer getCategories() {
		return categories;
	}

	public void setCategories(Integer categories) {
		this.categories = categories;
	}

	public Integer getCopies() {
		return copies;
	}

	public void setCopies(Integer copies) {
		this.copies = copies;
	}

}
