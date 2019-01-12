package com.c4networks.vrms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.UserDetailsDAO;
import com.c4networks.vrms.vo.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

	@Autowired
	private UserDetailsDAO userDetailsDao;

	// Use this method going forward. 14-10-2018
	@Override
	public UserDetails getLoggedInUserDetails(String userId) {
		logger.info("UserDetailsServiceImpl.getLoggedInUserDetails");
		UserDetails usrDtls = null;
		try {
			usrDtls = userDetailsDao.findByUserId(userId);
			logger.info("user object is ::" + usrDtls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrDtls;
	}

	@Override
	public UserDetails getLoggedInUserDetailsByUserName(String userName) {
		logger.info("UserDetailsServiceImpl.getLoggedInUserDetails");
		UserDetails usrDtls = null;
		try {
			usrDtls = userDetailsDao.findByUserName(userName);
			logger.info("user object is ::" + usrDtls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrDtls;
	}

}
