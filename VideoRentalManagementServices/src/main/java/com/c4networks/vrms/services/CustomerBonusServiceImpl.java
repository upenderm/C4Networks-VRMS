package com.c4networks.vrms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CustomerBonusDAO;
import com.c4networks.vrms.vo.CustomerBonus;

@Service
public class CustomerBonusServiceImpl implements CustomerBonusService {
	private static final Logger logger = Logger.getLogger(CustomerBonusService.class.getName());

	@Autowired
	private CustomerBonusDAO customerBonusDAO;

	@Override
	public CustomerBonus findBonusByCustomerId(String customerId) {
		logger.info("CustomerDetailsServiceImpl.customerId");
		CustomerBonus customerBonus = null;
		try {
			customerBonus = customerBonusDAO.findBonusByCustomerId(customerId);
			logger.info("customerBonus is ::" + customerBonus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerBonus;
	}

}
