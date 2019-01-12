package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.RentalDetails;

/**
 * 
 * @author M Upender
 *
 */

public interface RentalDetailsDAO {

	public void saveRentalDetails(RentalDetails transientInstance);

	public void deleteRentalDetails(RentalDetails persistentInstance);

	public RentalDetails findByRentalId(String rentalId);

	public List<RentalDetails> findByProperty(String propertyName, Object value);

	public List<RentalDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2);
	
	public List<RentalDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2, String propertyName3, Object value3);

	public List<RentalDetails> findAll();

	public List<String> getMaxRentalReference();

}
