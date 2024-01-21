package com.c4networks.vrms.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Upender M
 * 
 */

@XmlType(name = "CompanyDetail", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "CompanyDetail")
public class CompanyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private String companyOID;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String companyDesc;
	private String companyId;
	private byte[] companyImage;
	private byte[] companyLogo;
	private String companyName;
	private String country;
	private String createdBy;
	private Date createdDate;
	private String lastModifiedBy;
	private Date lastModifiedDate;
	private String mobile;
	private String mobile2;
	private String phone;
	private String registeredNum;
	private String state;
	private String zipcode;

	public CompanyDetail() {
	}

	public CompanyDetail(String companyOID, String addressLine1, String addressLine2, String city, String companyDesc, String companyId,
			byte[] companyImage, byte[] companyLogo, String companyName, String country, String createdBy,
			Date createdDate, String lastModifiedBy, Date lastModifiedDate, String phone, String registeredNum,
			String state, String zipcode) {
		super();
		this.companyOID = companyOID;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.companyDesc = companyDesc;
		this.companyId = companyId;
		this.companyImage = companyImage;
		this.companyLogo = companyLogo;
		this.companyName = companyName;
		this.country = country;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.phone = phone;
		this.registeredNum = registeredNum;
		this.state = state;
		this.zipcode = zipcode;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyDesc() {
		return this.companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public byte[] getCompanyImage() {
		return this.companyImage;
	}

	public void setCompanyImage(byte[] companyImage) {
		this.companyImage = companyImage;
	}

	public byte[] getCompanyLogo() {
		return this.companyLogo;
	}

	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegisteredNum() {
		return this.registeredNum;
	}

	public void setRegisteredNum(String registeredNum) {
		this.registeredNum = registeredNum;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public final String getCompanyOID() {
		return companyOID;
	}

	public final void setCompanyOID(String companyOID) {
		this.companyOID = companyOID;
	}

	public final String getMobile() {
		return mobile;
	}

	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public final String getMobile2() {
		return mobile2;
	}

	public final void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

}