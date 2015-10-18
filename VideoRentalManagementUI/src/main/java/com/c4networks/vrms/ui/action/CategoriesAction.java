package com.c4networks.vrms.ui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;
import com.opensymphony.xwork2.ActionSupport;

public class CategoriesAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CategoriesAction.class.getName());
	
	public String execute(){
		logger.info("In execute() of CategoriesAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Categories> categoriesList = VideoRentalManagementClient.getInstance().getCategories();
		logger.info("list size:" + categoriesList.size());
		session.setAttribute("categoriesList", categoriesList);
		
		return SUCCESS;
	}

}
