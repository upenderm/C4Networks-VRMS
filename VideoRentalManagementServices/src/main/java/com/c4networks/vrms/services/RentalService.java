package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.RentalFinalData;
import com.c4networks.vrms.vo.UserDetails;

public interface RentalService {

	public List<RentalDetails> getActiveRentalsList(String agentCode, String companyId);

	public List<RentalDetails> getAllRentalsList(String agentCode, String companyId);

	public Integer addRental(RentalDetails rentalDetails, String customerId, UserDetails userDetails,
			String movieId, String expectedReturnDate);

	public Integer closeRental(RentalFinalData finalData, boolean bonusCheck);

	public List<RentalDetails> getRentalsByCustomerId(String customerId);

	public RentalFinalData rentalFinalize(String rentalEditId);

	public Integer viewBonusByCustomerById(String customerId);

	public List<RentalDetails> viewRentalHistoryByCustomerId(String customerId, String agentCode, String companyCode);

}
