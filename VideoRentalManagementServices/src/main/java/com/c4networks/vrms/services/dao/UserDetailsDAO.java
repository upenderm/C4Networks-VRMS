package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.UserDetails;

/**
 * 
 * @author M Upender
 *
 */

public interface UserDetailsDAO {

	public void saveUserDetails(UserDetails transientInstance);

	public void deleteUserDetails(UserDetails persistentInstance);

	public UserDetails findByUserId(String id);
	
	public UserDetails findByUserName(String userName);

	public List<UserDetails> findByProperty(String propertyName, Object value);
	
	public List<UserDetails> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<UserDetails> findAll();

}
