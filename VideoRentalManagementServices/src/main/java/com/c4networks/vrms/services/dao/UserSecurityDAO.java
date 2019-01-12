package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.UserSecurity;

/**
 * 
 * @author M Upender
 *
 */

public interface UserSecurityDAO {

	public void saveUserSecurity(UserSecurity userSecurity);

	public void deleteUserSecurity(UserSecurity userSecurity);

	public UserSecurity findUserSecurityByUserName(String userName);

	public List<UserSecurity> findByProperty(String propertyName, Object value);

	public List<UserSecurity> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<UserSecurity> findAll();

}
