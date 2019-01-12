package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.CustomerBonus;

/**
 * 
 * @author M Upender
 *
 */

public interface CustomerBonusDAO {

	public void saveCustomerBonus(CustomerBonus customerBonus);

	public void deleteCustomerBonus(CustomerBonus customerBonus);

	public CustomerBonus findBonusByCustomerId(String customerId);

	public List<CustomerBonus> findByProperty(String propertyName, Object value);
	
	public List<CustomerBonus> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<CustomerBonus> findAll();
	
}
