package com.c4networks.vrms.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Movies generated by MyEclipse Persistence Tools
 */

public class Movies implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer movieId;
	private Categories categories;
	private CustomerDetails customerDetailsByLastModifiedBy;
	private CustomerDetails customerDetailsByCreatedBy;
	private String movieName;
	private String movieDesc;
	private Integer copies;
	private Date createdDate;
	private Date lastModifiedDate;
	private Set<CustomerDetails> rentalDetailses = new HashSet<CustomerDetails>(0);

	// Constructors

	/** default constructor */
	public Movies() {
	}

	/** minimal constructor */
	public Movies(Integer movieId, Categories categories,
			CustomerDetails customerDetailsByLastModifiedBy,
			CustomerDetails customerDetailsByCreatedBy, String movieName, Integer copies,
			Date createdDate, Date lastModifiedDate) {
		this.movieId = movieId;
		this.categories = categories;
		this.customerDetailsByLastModifiedBy = customerDetailsByLastModifiedBy;
		this.customerDetailsByCreatedBy = customerDetailsByCreatedBy;
		this.movieName = movieName;
		this.copies = copies;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	/** full constructor */
	public Movies(Integer movieId, Categories categories,
			CustomerDetails customerDetailsByLastModifiedBy,
			CustomerDetails customerDetailsByCreatedBy, String movieName,
			String movieDesc, Integer copies, Date createdDate, Date lastModifiedDate,
			Set<CustomerDetails> rentalDetailses) {
		this.movieId = movieId;
		this.categories = categories;
		this.customerDetailsByLastModifiedBy = customerDetailsByLastModifiedBy;
		this.customerDetailsByCreatedBy = customerDetailsByCreatedBy;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.copies = copies;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.rentalDetailses = rentalDetailses;
	}

	// Property accessors

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	@XmlTransient
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@XmlTransient
	public CustomerDetails getCustomerDetailsByLastModifiedBy() {
		return this.customerDetailsByLastModifiedBy;
	}

	public void setCustomerDetailsByLastModifiedBy(
			CustomerDetails customerDetailsByLastModifiedBy) {
		this.customerDetailsByLastModifiedBy = customerDetailsByLastModifiedBy;
	}

	@XmlTransient
	public CustomerDetails getCustomerDetailsByCreatedBy() {
		return this.customerDetailsByCreatedBy;
	}

	public void setCustomerDetailsByCreatedBy(
			CustomerDetails customerDetailsByCreatedBy) {
		this.customerDetailsByCreatedBy = customerDetailsByCreatedBy;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return this.movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<CustomerDetails> getRentalDetailses() {
		return this.rentalDetailses;
	}

	public void setRentalDetailses(Set<CustomerDetails> rentalDetailses) {
		this.rentalDetailses = rentalDetailses;
	}

	public Integer getCopies() {
		return copies;
	}

	public void setCopies(Integer copies) {
		this.copies = copies;
	}

}