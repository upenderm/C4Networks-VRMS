package com.c4networks.vrms.ui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.c4networks.vrms.vo.AgentCustomerDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.UserDetails;
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
	private String customerId;
	private String selectItemToHighlight;
	private String addCustomerResult;

	@SkipValidation
	public String viewCustomerList() {
		logger.info("In viewCustomerList() of CustomerAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println("***************"+session.getAttribute("userDetails"));
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		
		System.out.println("*******-----------********"+session.getAttribute("selectItemToHighlight"));
		if(!session.getAttribute("selectItemToHighlight").equals("viewCustomers")) {
			session.setAttribute("selectItemToHighlight", "viewCustomers");
		}
		System.out.println("userDetails in session is :"+userDetails);
		System.out.println(VideoRentalManagementClient.getInstance());
		List<AgentCustomerDetails> customersList = VideoRentalManagementClient.getInstance()
				.getCustomersListForUser(userDetails.getCompanyDetails().getCompanyOID());
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
		logger.info("In addCustomer() of CustomerAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		String RESULT = SUCCESS;
		try {
			AgentCustomerDetails bean = new AgentCustomerDetails();
			bean.setAgCustomerOID("");
			bean.setAgCustomerId("");
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setAddressLine1(address);
			bean.setAddressLine2(address);
			bean.setAddressLine3(address);
			bean.setEmail(email);
			bean.setMobile(mobile);
			bean.setPhone(phone);
			Integer result = VideoRentalManagementClient.getInstance().addCustomer(bean, userDetails);
			if (result == 1) {
				this.addActionMessage("User creation successfull !..");
//				HttpSession session = request.getSession();
				session.setAttribute("selectItemToHighlight", "viewCustomers");
				addCustomerResult = "CREATED";
				RESULT = ADDCUSTOMER;
//				HttpServletResponse response = ServletActionContext.getResponse();
//				response.sendRedirect("http://localhost:8080/VideoRentalManagementUI/customerAction_viewCustomerList.action");
			} else {
				this.addActionError("User creation failed...");
				RESULT = DEFINECUSTOMER;
			}
		} catch (Exception e) {
			logger.info("CustomerAction.addCustomer::An exception occured while adding a customer");
			logger.error(e);
		}
		return RESULT;
	}

	@SkipValidation
	public String viewRentalHistory() {
		logger.info("In viewRentalHistory() of CustomerAction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		List<RentalDetails> rentalHistoryList = VideoRentalManagementClient.getInstance().viewRentalHistoryByCustomerId(
				customerId, userDetails.getCompanyDetails().getCompanyId());
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the selectItemToHighlight
	 */
	public String getSelectItemToHighlight() {
		return selectItemToHighlight;
	}

	/**
	 * @param selectItemToHighlight the selectItemToHighlight to set
	 */
	public void setSelectItemToHighlight(String selectItemToHighlight) {
		this.selectItemToHighlight = selectItemToHighlight;
	}

	public String getAddCustomerResult() {
		return addCustomerResult;
	}

	public void setAddCustomerResult(String addCustomerResult) {
		this.addCustomerResult = addCustomerResult;
	}


}
