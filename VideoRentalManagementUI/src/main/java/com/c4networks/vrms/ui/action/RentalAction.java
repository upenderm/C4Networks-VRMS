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
import com.c4networks.vrms.vo.Movies;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;
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

	private Integer movieName;
	private Integer customerName;
	private String expectedReturnDate;
	private Integer rentalEditId;
	private String comments;
	private Integer amount;
	private String[] finalData;
	private Boolean bonusCheck;

	public String defineRental() {
		logger.info("In defineRental() of RentalAction");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		Map<Integer, String> customerMap = new HashMap<Integer, String>();
		Map<Integer, String> moviesMap = new HashMap<Integer, String>();

		List<CustomerDetails> customersList = VideoRentalManagementClient.getInstance().getAllCustomers();
		logger.info("customer list size :" + customersList.size());
		List<Movies> moviesList = VideoRentalManagementClient.getInstance().getMoviesList();
		logger.info("movies list size :" + moviesList.size());

		Iterator<CustomerDetails> customerIter = customersList.iterator();
		while (customerIter.hasNext()) {
			CustomerDetails bean = customerIter.next();
			customerMap.put(bean.getCustomerId(), bean.getVrmsId() + " - " + bean.getFirstName());
		}
		Iterator<Movies> moviesIter = moviesList.iterator();
		while (moviesIter.hasNext()) {
			Movies bean = moviesIter.next();
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
		RentalDetails bean = new RentalDetails();

		Integer result = VideoRentalManagementClient.getInstance().addRental(bean, this.getCustomerName(),
				this.getMovieName(), this.getExpectedReturnDate());

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
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer result = VideoRentalManagementClient.getInstance()
				.getAvailableMovieCopiesById(Integer.parseInt(request.getParameter("movieId")));

		out.write(result.toString());

		return null;
	}

	public String viewActiveRentals() {
		logger.info("In viewActiveRentals of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<RentalDetails> rentalsActiveList = VideoRentalManagementClient.getInstance().getActiveRentalsList();
		logger.info("list size:" + rentalsActiveList.size());
		session.setAttribute("rentalsList", rentalsActiveList);

		return SUCCESS;
	}

	public String viewRentals() {
		logger.info("In viewRentals of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<RentalDetails> rentalsList = VideoRentalManagementClient.getInstance().getRentalsList();
		logger.info("list size:" + rentalsList.size());
		session.setAttribute("rentalsList", rentalsList);

		return SUCCESS;
	}

	public String closeRentalPage() {
		logger.info("In closeRentalPage() of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map<Integer, String> customerMap = new HashMap<Integer, String>();
		List<CustomerDetails> customersList = VideoRentalManagementClient.getInstance().getAllCustomers();
		logger.info("customer list size :" + customersList.size());
		Iterator<CustomerDetails> customerIter = customersList.iterator();
		while (customerIter.hasNext()) {
			CustomerDetails bean = customerIter.next();
			customerMap.put(bean.getCustomerId(), bean.getVrmsId() + " - " + bean.getFirstName());
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
				.viewBonusByCustomerById(Integer.parseInt(request.getParameter("customerId")));
		logger.info("bonus points :" + result);
		out.write(result.toString());

		return null;
	}

	public String viewRentalsByCustomer() {
		logger.info("In viewRentalsByCustomer() of RentalAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String str = request.getParameter("customerId");
		List<RentalDetails> list = new ArrayList<RentalDetails>();
		list = VideoRentalManagementClient.getInstance().getRentalsByCustomerId(Integer.parseInt(str));
		session.setAttribute("specificCustomerRentals", list);
		return RENTALCHILDPAGE;

	}

	public String closeRental() {
		logger.info("In closeRental() of RentalAction");
		RentalDetails bean = new RentalDetails();
		Integer result = VideoRentalManagementClient.getInstance().closeRental(bean, this.getBonusCheck());
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
		finalData = VideoRentalManagementClient.getInstance().rentalFinalize(rentalEditId);
		logger.info("Update status is :" + finalData);

		return RENTALFINALIZE;
	}

	public Integer getMovieName() {
		return movieName;
	}

	public void setMovieName(Integer movieName) {
		this.movieName = movieName;
	}

	public Integer getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Integer customerName) {
		this.customerName = customerName;
	}

	public String getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(String expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Integer getRentalEditId() {
		return rentalEditId;
	}

	public void setRentalEditId(Integer rentalEditId) {
		this.rentalEditId = rentalEditId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String[] getFinalData() {
		return finalData;
	}

	public void setFinalData(String[] finalData) {
		this.finalData = finalData;
	}

	public Boolean getBonusCheck() {
		return bonusCheck;
	}

	public void setBonusCheck(Boolean bonusCheck) {
		this.bonusCheck = bonusCheck;
	}

}
