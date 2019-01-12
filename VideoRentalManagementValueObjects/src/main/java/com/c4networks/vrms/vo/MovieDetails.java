package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Upender M
 * 
 */

@XmlType(name = "MovieDetails", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "MovieDetails")
public class MovieDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserDetails agentCode;
	private Integer availableCopies;
	private CompanyDetail companyDetails;
	private UserDetails createdBy;
	private Date createdDate;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;
	private String movieDesc;
	private String movieId;
	private String movieName;
	private byte[] picture;
	private String status;
	private String totalCopies;
	private Categories categories;
//	private Set rentalDetailses;

	public MovieDetails() {
	}

	public MovieDetails(UserDetails agentCode, Integer availableCopies, CompanyDetail companyId, UserDetails createdBy,
			Date createdDate, UserDetails lastModifiedBy, Date lastModifiedDate, String movieDesc, String movieId,
			String movieName, byte[] picture, String status, String totalCopies) {
		super();
		this.agentCode = agentCode;
		this.availableCopies = availableCopies;
		this.companyDetails = companyId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.movieDesc = movieDesc;
		this.movieId = movieId;
		this.movieName = movieName;
		this.picture = picture;
		this.status = status;
		this.totalCopies = totalCopies;
	}

	public UserDetails getAgentCode() {
		return this.agentCode;
	}

	public void setAgentCode(UserDetails agentCode) {
		this.agentCode = agentCode;
	}

	public Integer getAvailableCopies() {
		return this.availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public CompanyDetail getCompanyDetails() {
		return this.companyDetails;
	}

	public void setCompanyDetails(CompanyDetail companyDetails) {
		this.companyDetails = companyDetails;
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

	public String getMovieDesc() {
		return this.movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalCopies() {
		return this.totalCopies;
	}

	public void setTotalCopies(String totalCopies) {
		this.totalCopies = totalCopies;
	}

	/**
	 * @return the categories
	 */
	public Categories getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	/**
	 * @return the rentalDetailses
	 */
	/*public Set getRentalDetailses() {
		return rentalDetailses;
	}

	*//**
	 * @param rentalDetailses
	 *            the rentalDetailses to set
	 *//*
	public void setRentalDetailses(Set rentalDetailses) {
		this.rentalDetailses = rentalDetailses;
	}
*/
}