package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.CompanyDetail;

/**
 * 
 * @author M Upender
 *
 */

public interface CompanyDetailsDAO {

	public void saveCompanyDetails(CompanyDetail transientInstance);

	public void deleteCompanyDetails(CompanyDetail persistentInstance);

	public CompanyDetail findByCompanyDetailsByOID(String companyDetailOID);
	
	public CompanyDetail findByCompanyDetailsId(String companyDetailId);

	public List<CompanyDetail> findByProperty(String propertyName, Object value);

	public List<CompanyDetail> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<CompanyDetail> findAll();

}
