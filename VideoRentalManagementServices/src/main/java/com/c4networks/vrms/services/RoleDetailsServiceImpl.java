package com.c4networks.vrms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.RoleDetailsDAO;
import com.c4networks.vrms.vo.RoleDetail;

@Service
public class RoleDetailsServiceImpl implements RoleDetailsService {
	private static final Logger logger = Logger.getLogger(RoleDetailsServiceImpl.class.getName());

	@Autowired
	private RoleDetailsDAO roleDetailsDAO;

	@Override
	public RoleDetail findByRoleDetailId(String roleId) {
		logger.info("CustomerDetailsServiceImpl.customerId");
		RoleDetail roleDetail = null;
		try {
			roleDetail = roleDetailsDAO.findByRoleDetailId(roleId);
			logger.info("customerBonus is ::" + roleDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleDetail;
	}

}
