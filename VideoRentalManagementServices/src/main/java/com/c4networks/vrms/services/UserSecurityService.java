package com.c4networks.vrms.services;

import com.c4networks.vrms.vo.UserSecurity;

public interface UserSecurityService {

	public UserSecurity getLoggedInUserDetailsByUserName(String userName);

}
