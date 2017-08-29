package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.CustomerDetails;

public interface CustomerDetailsService {

	public List<CustomerDetails> getCustomers();

	public Integer addCustomer(CustomerDetails custDtls);

}
