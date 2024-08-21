package com.c4networks.vrms.ui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.UserDetails;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;
import com.opensymphony.xwork2.ActionSupport;

public class CategoriesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CategoriesAction.class.getName());
	private static final String ADDCATEGORY = "addcategory";
	private static final String DEFINECATEGORY = "definecategory";

	private String categoryName;
	private String categoryDescription;
	private Integer activePrice;
	private Integer initialPrice;
	private String status;
	private Integer bonus;

	public String viewCategories() {
		logger.info("In viewCategories() of CategoriesAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		List<Categories> categoriesList = VideoRentalManagementClient.getInstance()
				.getAllCategoriesForUser(userDetails.getCompanyDetails().getCompanyOID());
		logger.info("list size:" + categoriesList.size());
		session.setAttribute("categoriesList", categoriesList);

		return SUCCESS;
	}

	@SkipValidation
	public String defineCategory() {
		logger.info("In defineCategory() of CategoriesAction");

		return ADDCATEGORY;
	}

	public String addCategory() {
		String RESULT = SUCCESS;
		logger.info("In addCategory() of CategoryAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		Categories bean = new Categories();
		bean.setCategoryName(this.categoryName.trim());
		bean.setCategoryDesc(this.categoryDescription.trim());
		bean.setActivePrice(this.activePrice);
		bean.setInitialPrice(this.activePrice);
		bean.setStatus("ACTIVE");
		bean.setBonus(this.bonus);

		Integer result = VideoRentalManagementClient.getInstance().addCategory(bean, userDetails);
		if (result == 1) {
			this.addActionMessage("Category creation successfull !..");
			RESULT = SUCCESS;
		} else {
			this.addActionError("Category creation failed...");
			RESULT = DEFINECATEGORY;
		}
		return RESULT;

	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Integer getActivePrice() {
		return activePrice;
	}

	public void setActivePrice(Integer activePrice) {
		this.activePrice = activePrice;
	}

	public Integer getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Integer initialPrice) {
		this.initialPrice = initialPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

}
