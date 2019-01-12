package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Upender M
 * 
 */

@XmlType(name = "Categories", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "Categories")
public class Categories implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer activePrice;
	private Integer bonus;
	private String categoryDesc;
	private String categoryId;
	private String categoryName;
	private UserDetails createdBy;
	private Date createdDate;
	private Integer initialPrice;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;
	private String status;
	private UserDetails agentCode;
	private CompanyDetail companyDetails;
	//	private Set movieDetailses;

	public Categories() {
	}

	public Categories(Integer activePrice, Integer bonus, String categoryDesc, String categoryId,
			String categoryName, UserDetails createdBy, Date createdDate, Integer initialPrice,
			UserDetails lastModifiedBy, Date lastModifiedDate, String status) {
		super();
		this.activePrice = activePrice;
		this.bonus = bonus;
		this.categoryDesc = categoryDesc;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.initialPrice = initialPrice;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.status = status;
	}

	public Integer getActivePrice() {
		return this.activePrice;
	}

	public void setActivePrice(Integer activePrice) {
		this.activePrice = activePrice;
	}

	public Integer getBonus() {
		return this.bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public String getCategoryDesc() {
		return this.categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public Integer getInitialPrice() {
		return this.initialPrice;
	}

	public void setInitialPrice(Integer initialPrice) {
		this.initialPrice = initialPrice;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the agentCode
	 */
	public UserDetails getAgentCode() {
		return agentCode;
	}

	/**
	 * @param agentCode
	 *            the agentCode to set
	 */
	public void setAgentCode(UserDetails agentCode) {
		this.agentCode = agentCode;
	}

	/**
	 * @return the movieDetailses
	 */
	/*public Set getMovieDetailses() {
		return movieDetailses;
	}
	*/
	/**
	 * @param movieDetailses
	 *            the movieDetailses to set
	 */
	/*public void setMovieDetailses(Set movieDetailses) {
		this.movieDetailses = movieDetailses;
	}*/

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

}