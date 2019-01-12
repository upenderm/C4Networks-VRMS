package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Upender M
 * 
 */

@XmlType(name = "RentalDetails", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "RentalDetails")
public class RentalDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date actualReturnDate;
	private String comments;
	private String companyCode;
	private Date expectedReturnDate;
	private Integer charges;
	private Integer lateCharges;
	private Integer effectiveCharges;
	private Date rentalDate;
	private String rentalId;
	private String status;
	private CustomerDetails customerDetails;
	private MovieDetails movieDetails;
	private CompanyDetail companyDetails;
	private UserDetails agentCode;

	public RentalDetails() {
	}

	public RentalDetails(Date actualReturnDate, UserDetails agentCode, Integer charges, String comments, String companyCode,
			CustomerDetails customerDetails, Date expectedReturnDate, Integer lateCharges, MovieDetails movieId, Date rentalDate,
			String rentalId, String status) {
		super();
		this.actualReturnDate = actualReturnDate;
		this.agentCode = agentCode;
		this.charges = charges;
		this.comments = comments;
		this.companyCode = companyCode;
		this.customerDetails = customerDetails;
		this.expectedReturnDate = expectedReturnDate;
		this.lateCharges = lateCharges;
		this.movieDetails = movieId;
		this.rentalDate = rentalDate;
		this.rentalId = rentalId;
		this.status = status;
	}

	public Date getActualReturnDate() {
		return this.actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public UserDetails getAgentCode() {
		return this.agentCode;
	}

	public void setAgentCode(UserDetails agentCode) {
		this.agentCode = agentCode;
	}

	public Integer getCharges() {
		return this.charges;
	}

	public void setCharges(Integer charges) {
		this.charges = charges;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Date getExpectedReturnDate() {
		return this.expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Integer getLateCharges() {
		return this.lateCharges;
	}

	public void setLateCharges(Integer lateCharges) {
		this.lateCharges = lateCharges;
	}

	public Date getRentalDate() {
		return this.rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getRentalId() {
		return this.rentalId;
	}

	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the movieDetail
	 */
	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	/**
	 * @param movieDetail
	 *            the movieDetail to set
	 */
	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}

	/**
	 * @return the effectiveCharges
	 */
	public Integer getEffectiveCharges() {
		return effectiveCharges;
	}

	/**
	 * @param effectiveCharges the effectiveCharges to set
	 */
	public void setEffectiveCharges(Integer effectiveCharges) {
		this.effectiveCharges = effectiveCharges;
	}

	/**
	 * @return the customerDetails
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	/**
	 * @return the companyDetails
	 */
	public CompanyDetail getCompanyDetails() {
		return companyDetails;
	}

	/**
	 * @param companyDetails the companyDetails to set
	 */
	public void setCompanyDetails(CompanyDetail companyDetails) {
		this.companyDetails = companyDetails;
	}

}