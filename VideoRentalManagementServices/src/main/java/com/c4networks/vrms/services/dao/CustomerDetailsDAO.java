package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.AgentCustomerDetails;

/**
 * 
 * @author M Upender
 *
 */

public interface CustomerDetailsDAO {

	public void saveCustomerDetail(AgentCustomerDetails transientInstance);

	public void deleteCustomerDetail(AgentCustomerDetails persistentInstance);

	public AgentCustomerDetails findByCustomerId(String id);

	public List<AgentCustomerDetails> findByProperty(String propertyName, Object value);
	
	public List<AgentCustomerDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<AgentCustomerDetails> findAll();

}
