package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Upender M
 * 
 */

@XmlType(name = "CustomerBonus", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "CustomerBonus")
public class CustomerBonus implements Serializable {

	private static final long serialVersionUID = 1L;
	private String bonusId;
	private CustomerDetails customerDetails;
	private Integer bonusPoints;
	private Integer bonusVersion;
	private UserDetails createdBy;
	private Date createdDate;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;

	public CustomerBonus() {
	}

	public CustomerBonus(CustomerDetails customerDetails, Integer bonusPoints, Integer bonusVersion,
			UserDetails createdBy, Date createdDate, UserDetails lastModifiedBy, Date lastModifiedDate) {
		super();
		this.customerDetails = customerDetails;
		this.bonusPoints = bonusPoints;
		this.bonusVersion = bonusVersion;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	public CustomerDetails getCustomerDetails() {
		return this.customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Integer getBonusPoints() {
		return this.bonusPoints;
	}

	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public Integer getBonusVersion() {
		return this.bonusVersion;
	}

	public void setBonusVersion(Integer bonusVersion) {
		this.bonusVersion = bonusVersion;
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

	/**
	 * @return the bonusId
	 */
	public String getBonusId() {
		return bonusId;
	}

	/**
	 * @param bonusId
	 *            the bonusId to set
	 */
	public void setBonusId(String bonusId) {
		this.bonusId = bonusId;
	}

}