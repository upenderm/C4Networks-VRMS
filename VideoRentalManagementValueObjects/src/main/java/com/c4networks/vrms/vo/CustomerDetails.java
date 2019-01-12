package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author M Upender
 * 
 */

@XmlType(name = "CustomerDetails", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "CustomerDetails")
public class CustomerDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aadhaar;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private UserDetails agentCode;
	private String companyId;
	private UserDetails createdBy;
	private Date createdDate;
	private String customerId;
	private String email;
	private String firstName;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;
	private String lastName;
	private String mobile;
	private String phone;
	private byte[] picture;
	private String sex;
	private CompanyDetail companyDetails;

	/*private Set rentalDetailses;
	private Set customerBonuses;*/

	public CustomerDetails() {
	}

	public CustomerDetails(String aadhaar, String addressLine1, String addressLine2, String addressLine3,
			UserDetails agentCode, String companyId, UserDetails createdBy, Date createdDate, String customerId,
			String email, String firstName, UserDetails lastModifiedBy, Date lastModifiedDate, String lastName,
			String mobile, String phone, byte[] picture, String sex) {
		super();
		this.aadhaar = aadhaar;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.agentCode = agentCode;
		this.companyId = companyId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.customerId = customerId;
		this.email = email;
		this.firstName = firstName;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastName = lastName;
		this.mobile = mobile;
		this.phone = phone;
		this.picture = picture;
		this.sex = sex;
	}

	public String getAadhaar() {
		return this.aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public UserDetails getAgentCode() {
		return this.agentCode;
	}

	public void setAgentCode(UserDetails agentCode) {
		this.agentCode = agentCode;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public UserDetails getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UserDetails createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public UserDetails getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(UserDetails lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the companyDetails
	 */
	public CompanyDetail getCompanyDetails() {
		return companyDetails;
	}

	/**
	 * @param companyDetails
	 *            the companyDetails to set
	 */
	public void setCompanyDetails(CompanyDetail companyDetails) {
		this.companyDetails = companyDetails;
	}

	/**
	 * @return the rentalDetailses
	 */
/*	public Set getRentalDetailses() {
		return rentalDetailses;
	}

	*//**
	 * @param rentalDetailses
	 *            the rentalDetailses to set
	 *//*
	public void setRentalDetailses(Set rentalDetailses) {
		this.rentalDetailses = rentalDetailses;
	}

	*//**
	 * @return the customerBonuses
	 *//*
	public Set getCustomerBonuses() {
		return customerBonuses;
	}

	*//**
	 * @param customerBonuses
	 *            the customerBonuses to set
	 *//*
	public void setCustomerBonuses(Set customerBonuses) {
		this.customerBonuses = customerBonuses;
	}*/

}