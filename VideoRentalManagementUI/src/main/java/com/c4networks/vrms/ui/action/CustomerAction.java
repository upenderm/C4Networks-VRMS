package com.c4networks.vrms.ui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CustomerAction.class.getName());
	private final String ADDCUSTOMER = "addcustomer";
	private final String DEFINECUSTOMER = "definecustomer";
	private final String HISTORY = "history";

	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phone;
	private String mobile;
	private Integer customerId;

	@SkipValidation
	public String viewCustomerList() {
		logger.info("In viewCustomerList() of CustomerAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println(VideoRentalManagementClient.getInstance());
		List<CustomerDetails> customersList = VideoRentalManagementClient.getInstance().getAllCustomers();
		logger.info("list size:" + customersList.size());
		session.setAttribute("customersList", customersList);
		return SUCCESS;
	}

	@SkipValidation
	public String defineCustomer() {
		logger.info("In defineCustomer() of CustomerAction");

		return DEFINECUSTOMER;
	}

	public String addCustomer() {
		String RESULT = SUCCESS;
		logger.info("In addCustomer() of CustomerAction");
		CustomerDetails bean = new CustomerDetails();
		Integer result = VideoRentalManagementClient.getInstance().addCustomer(bean);
		if (result == 1) {
			this.addActionMessage("User creation successfull !..");
			RESULT = ADDCUSTOMER;
		} else {
			this.addActionError("User creation failed...");
			RESULT = DEFINECUSTOMER;
		}
		return RESULT;
	}

	@SkipValidation
	public String viewRentalHistory() {
		logger.info("In viewRentalHistory() of CustomerAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<RentalDetails> rentalHistoryList = VideoRentalManagementClient.getInstance().viewRentalHistoryByCustomerId(customerId);
		session.setAttribute("rentalHistoryList", rentalHistoryList);
		return HISTORY;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
