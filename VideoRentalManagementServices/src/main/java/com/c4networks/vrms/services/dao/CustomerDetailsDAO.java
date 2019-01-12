package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.CustomerDetails;

/**
 * 
 * @author M Upender
 *
 */

public interface CustomerDetailsDAO {

	public void saveCustomerDetail(CustomerDetails transientInstance);

	public void deleteCustomerDetail(CustomerDetails persistentInstance);

	public CustomerDetails findByCustomerId(String id);

	public List<CustomerDetails> findByProperty(String propertyName, Object value);
	
	public List<CustomerDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<CustomerDetails> findAll();

}
