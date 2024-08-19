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
	private String rentalId;
	private AgentCustomerDetails agentCustomerDetails;
	private CompanyDetail companyDetails;
	private MovieDetails movieDetails;
	private Date rentalDate;
	private Date expectedReturnDate;
	private Date actualReturnDate;
	private Integer lateCharges;
	private Integer charges;
	private Integer effectiveCharges;
	private String status;
	private String comments;
	private UserDetails createdBy;
	private Date createdDate;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;

	public RentalDetails() {

	}

	public String getRentalId() {
		return rentalId;
	}

	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}

	public AgentCustomerDetails getAgentCustomerDetails() {
		return agentCustomerDetails;
	}

	public void setAgentCustomerDetails(AgentCustomerDetails agentCustomerDetails) {
		this.agentCustomerDetails = agentCustomerDetails;
	}

	public CompanyDetail getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(CompanyDetail companyDetails) {
		this.companyDetails = companyDetails;
	}

	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Date getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public Integer getLateCharges() {
		return lateCharges;
	}

	public void setLateCharges(Integer lateCharges) {
		this.lateCharges = lateCharges;
	}

	public Integer getCharges() {
		return charges;
	}

	public void setCharges(Integer charges) {
		this.charges = charges;
	}

	public Integer getEffectiveCharges() {
		return effectiveCharges;
	}

	public void setEffectiveCharges(Integer effectiveCharges) {
		this.effectiveCharges = effectiveCharges;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public UserDetails getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDetails createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserDetails getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(UserDetails lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}