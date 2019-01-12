package com.c4networks.vrms.vo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RentalFinalData", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "RentalFinalData")
public class RentalFinalData {

	private String rentalId;
	private Integer actualPrice;
	private Integer lateCharges;
	private Integer totalPrice;
	private String customerId;
	private String customerName;
	private String movieName;
	private Integer billedAmount;
	private String comments;
	
	/**
	 * @return the rentalId
	 */
	public String getRentalId() {
		return rentalId;
	}
	/**
	 * @param rentalId the rentalId to set
	 */
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}
	/**
	 * @return the actualPrice
	 */
	public Integer getActualPrice() {
		return actualPrice;
	}
	/**
	 * @param actualPrice the actualPrice to set
	 */
	public void setActualPrice(Integer actualPrice) {
		this.actualPrice = actualPrice;
	}
	/**
	 * @return the lateCharges
	 */
	public Integer getLateCharges() {
		return lateCharges;
	}
	/**
	 * @param lateCharges the lateCharges to set
	 */
	public void setLateCharges(Integer lateCharges) {
		this.lateCharges = lateCharges;
	}
	/**
	 * @return the totalPrice
	 */
	public Integer getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the billedAmount
	 */
	public Integer getBilledAmount() {
		return billedAmount;
	}
	/**
	 * @param billedAmount the billedAmount to set
	 */
	public void setBilledAmount(Integer billedAmount) {
		this.billedAmount = billedAmount;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


}
