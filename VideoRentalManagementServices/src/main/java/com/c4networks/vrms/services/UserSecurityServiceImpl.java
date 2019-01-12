package com.c4networks.vrms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.UserSecurityDAO;
import com.c4networks.vrms.vo.UserSecurity;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {
	private static final Logger logger = Logger.getLogger(UserSecurityServiceImpl.class.getName());

	@Autowired
	private UserSecurityDAO userSecurityDAO;

	// Use this method going forward. 14-10-2018
	@Override
	public UserSecurity getLoggedInUserDetailsByUserName(String userName) {
		logger.info("UserDetailsServiceImpl.getLoggedInUserDetails");
		UserSecurity usrDtls = null;
		try {
			usrDtls = userSecurityDAO.findUserSecurityByUserName(userName);
			logger.info("user object is ::" + usrDtls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrDtls;
	}

}
