package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.AgentCustomerDetails;
import com.c4networks.vrms.vo.UserDetails;

public interface CustomerDetailsService {

	public List<AgentCustomerDetails> getCustomers(String companyOID);

	public Integer addCustomer(AgentCustomerDetails custDtls, UserDetails userDetails);

	public AgentCustomerDetails getCustomerById(String customerId);

}
