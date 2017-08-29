package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.CustomerDetails;

public interface CustomerDetailsDAO {

	public void save(CustomerDetails transientInstance);

	public void delete(CustomerDetails persistentInstance);

	public CustomerDetails findById(java.lang.Integer id);

	public List<CustomerDetails> findByExample(CustomerDetails instance);

	public List<CustomerDetails> findByProperty(String propertyName, Object value);

	public List<CustomerDetails> findAll();

}
