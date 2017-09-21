package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.RentalDetails;

public interface CustomerDetailsService {

	public List<CustomerDetails> getCustomers();

	public Integer addCustomer(CustomerDetails custDtls);
	
	public CustomerDetails getCustomerById(Integer customerId);

	public Integer addRental(RentalDetails rentalDetails, Integer customerId, Integer movieId, String expectedReturnDate);

}
