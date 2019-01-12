package com.c4networks.vrms.services;

import com.c4networks.vrms.vo.UserDetails;

public interface UserDetailsService {

	public UserDetails getLoggedInUserDetails(String userId);
	
	public UserDetails getLoggedInUserDetailsByUserName(String userName);

}
