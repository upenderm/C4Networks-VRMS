package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;

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
	private String movieId;
	private String movieName;
	private String movieDesc;
	private Integer availableCopies;
	private String status;
	private Integer totalCopies;
	private Categories categories;
	private UserDetails createdBy;
	private Date createdDate;
	private UserDetails lastModifiedBy;
	private Date lastModifiedDate;
	private CompanyDetail companyDetails;
	private byte[] picture;

	public MovieDetails() {
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
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

	public CompanyDetail getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(CompanyDetail companyDetails) {
		this.companyDetails = companyDetails;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

}