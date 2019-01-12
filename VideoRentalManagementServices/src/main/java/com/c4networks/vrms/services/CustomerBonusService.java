package com.c4networks.vrms.services;

import com.c4networks.vrms.vo.CustomerBonus;

public interface CustomerBonusService {

	public CustomerBonus findBonusByCustomerId(String customerId);

}
