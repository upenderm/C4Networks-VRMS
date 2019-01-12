package com.c4networks.vrms.ui.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.RentalFinalData;
import com.c4networks.vrms.vo.UserDetails;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RentalAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RentalAction.class.getName());
	private final String DEFINERENTAL = "definerental";
	private final String DEFINECLOSE = "defineclose";
	private final String RENTALCHILDPAGE = "rentalchildpage";
	private final String ADDRENTAL = "addrental";
	private final String RENTALFINALIZE = "rentalfinalize";

	private String movieId;
	private String customerId;
	private String expectedReturnDate;
	private String rentalEditId;
	private String comments;
	private Integer billedAmount;
	private Boolean bonusCheck;

	public String defineRental() {
		logger.info("In defineRental() of RentalAction");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");

		Map<String, String> customerMap = new HashMap<>();
		Map<String, String> moviesMap = new HashMap<>();

		List<CustomerDetails> customersList = VideoRentalManagementClient.getInstance()
				.getCustomersListForUser(userDetails.getUserId(), userDetails.getCompanyDetails().getCompanyId());
		logger.info("customer list size :" + customersList.size());
		List<MovieDetails> moviesList = VideoRentalManagementClient.getInstance().getMoviesList(userDetails.getUserId(),
				userDetails.getCompanyDetails().getCompanyId());
		logger.info("movies list size :" + moviesList.size());

		Iterator<CustomerDetails> customerIter = customersList.iterator();
		while (customerIter.hasNext()) {
			CustomerDetails bean = customerIter.next();
			customerMap.put(bean.getCustomerId(), bean.getFirstName() + " - " + bean.getFirstName());
		}
		Iterator<MovieDetails> moviesIter = moviesList.iterator();
		while (moviesIter.hasNext()) {
			MovieDetails bean = moviesIter.next();
			moviesMap.put(bean.getMovieId(), bean.getMovieName());
		}

		session.setAttribute("moviesMap", moviesMap);
		session.setAttribute("customerMap", customerMap);

		return DEFINERENTAL;
	}

	public String addRental() {
		logger.info("In addRental of RentalAction");
		String RESULT = SUCCESS;
		logger.info("In addCustomer() of CustomerAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");

		RentalDetails bean = new RentalDetails();

		Integer result = VideoRentalManagementClient.getInstance().addRental(bean, this.getCustomerId(), userDetails,
				this.getMovieId(), this.getExpectedReturnDate());

		if (result == 1) {
			this.addActionMessage("Rental creation successfull !..");
			RESULT = ADDRENTAL;
		} else {
			this.addActionError("Rental creation failed...");
			RESULT = DEFINERENTAL;
		}
		return RESULT;
	}

	public String getAvailableCopies() {
		logger.info("In getAvailableCopies() of RentalAction");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		Integer result = VideoRentalManagementClient.getInstance().getAvailableMovieCopiesById(request.getParameter("movieId"), userDetails.getUserId(), userDetails.getCompanyDetails().getCompanyId());

		out.write(result.toString());

		return null;
	}

	public String viewActiveRentals() {
		logger.info("In viewActiveRentals of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");

		List<RentalDetails> rentalsActiveList = VideoRentalManagementClient.getInstance()
				.getActiveRentalsList(userDetails.getUserId(), userDetails.getCompanyDetails().getCompanyId());
		logger.info("list size:" + rentalsActiveList.size());
		session.setAttribute("rentalsList", rentalsActiveList);

		return SUCCESS;
	}

	public String viewAllRentals() {
		logger.info("In viewRentals of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");

		List<RentalDetails> rentalsList = VideoRentalManagementClient.getInstance()
				.getAllRentalsList(userDetails.getUserId(), userDetails.getCompanyDetails().getCompanyId());
		logger.info("list size:" + rentalsList.size());
		session.setAttribute("rentalsList", rentalsList);

		return SUCCESS;
	}

	public String closeRentalPage() {
		logger.info("In closeRentalPage() of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");

		Map<String, String> customerMap = new HashMap<>();
		List<CustomerDetails> customersList = VideoRentalManagementClient.getInstance()
				.getCustomersListForUser(userDetails.getUserId(), userDetails.getCompanyDetails().getCompanyId());
		logger.info("customer list size :" + customersList.size());
		Iterator<CustomerDetails> customerIter = customersList.iterator();
		while (customerIter.hasNext()) {
			CustomerDetails bean = customerIter.next();
			customerMap.put(bean.getCustomerId(), bean.getLastName() + " - " + bean.getFirstName());
		}
		session.setAttribute("customerMap", customerMap);
		return DEFINECLOSE;
	}

	public String viewCustomerBonus() {
		logger.info("In viewCustomerBonus() of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer result = VideoRentalManagementClient.getInstance()
				.viewBonusByCustomerById(request.getParameter("customerId"));
		logger.info("bonus points :" + result);
		out.write(result.toString());

		return null;
	}

	public String viewRentalsByCustomer() {
		logger.info("In viewRentalsByCustomer() of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String str = request.getParameter("customerId");
		List<RentalDetails> list = new ArrayList<>();
		list = VideoRentalManagementClient.getInstance().getRentalsByCustomerId(str);
		session.setAttribute("specificCustomerRentals", list);
		return RENTALCHILDPAGE;

	}

	public String closeRental() {
		logger.info("In closeRental() of RentalAction");
		RentalFinalData finalData = new RentalFinalData();
		finalData.setRentalId(this.rentalEditId);
		finalData.setComments(this.comments);
		finalData.setBilledAmount(this.billedAmount);
		Integer result = VideoRentalManagementClient.getInstance().closeRental(finalData, this.getBonusCheck());
		logger.info("Update status is :" + result);
		if (result == 1) {
			this.addActionMessage("Rental closed.");
		} else {
			this.addActionError("Error while closing the Rental...");
		}
		return DEFINECLOSE;
	}

	public String rentalFinalize() {
		logger.info("In rentalFinalize() of RentalAction");
		RentalFinalData finalData = VideoRentalManagementClient.getInstance().rentalFinalize(rentalEditId);
		logger.info("Update status is :" + finalData);
		ActionContext.getContext().getValueStack().push(finalData);
		return RENTALFINALIZE;
	}

	public String getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(String expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public String getRentalEditId() {
		return rentalEditId;
	}

	public void setRentalEditId(String rentalEditId) {
		this.rentalEditId = rentalEditId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(Integer billedAmount) {
		this.billedAmount = billedAmount;
	}

	public Boolean getBonusCheck() {
		return bonusCheck;
	}

	public void setBonusCheck(Boolean bonusCheck) {
		this.bonusCheck = bonusCheck;
	}

	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId
	 *            the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
