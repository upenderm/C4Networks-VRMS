package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.UserDetails;

public interface CustomerDetailsService {

	public List<CustomerDetails> getCustomers(String agentCode, String companyId);

	public Integer addCustomer(CustomerDetails custDtls, UserDetails userDetails);
	
	public CustomerDetails getCustomerById(String customerId);

//	public Integer addRental(RentalDetails rentalDetails, String customerId, UserDetails userDetails, String movieId, String expectedReturnDate);

}
