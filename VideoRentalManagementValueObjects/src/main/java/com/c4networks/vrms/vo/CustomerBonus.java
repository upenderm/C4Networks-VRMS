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
	private AgentCustomerDetails agentCustomerDetails;
	private Integer bonusPoints;
	private Integer bonusVersion;
	private UserDetails createdBy;
	private Date createdDate;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;

	public CustomerBonus() {
	}

	public String getBonusId() {
		return bonusId;
	}

	public void setBonusId(String bonusId) {
		this.bonusId = bonusId;
	}

	public AgentCustomerDetails getAgentCustomerDetails() {
		return agentCustomerDetails;
	}

	public void setAgentCustomerDetails(AgentCustomerDetails agentCustomerDetails) {
		this.agentCustomerDetails = agentCustomerDetails;
	}

	public Integer getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public Integer getBonusVersion() {
		return bonusVersion;
	}

	public void setBonusVersion(Integer bonusVersion) {
		this.bonusVersion = bonusVersion;
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