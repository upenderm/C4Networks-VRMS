package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.RentalDetails;

public interface RentalDetailsDAO {

	public void save(RentalDetails transientInstance);

	public void delete(RentalDetails persistentInstance);

	public RentalDetails findById(java.lang.Integer id);

	public List<RentalDetails> findByExample(RentalDetails instance);

	public List<RentalDetails> findByProperty(String propertyName, Object value);

	public List<RentalDetails> findAll();

	public List<String> getMaxRentalReference();
	
}
