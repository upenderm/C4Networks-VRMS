package com.c4networks.vrms.services;

import java.util.List;

import com.c4networks.vrms.vo.RentalDetails;

public interface RentalService {

	public List<RentalDetails> getActiveRentalsList();

	public List<RentalDetails> getRentalsList();

	public Integer addRental(RentalDetails rentalDtls);

	public Integer closeRental(RentalDetails rentalDetails, boolean bonusCheck);

	public List<RentalDetails> getRentalsByCustomerId(Integer customerId);

	public String[] rentalFinalize(Integer rentalEditId);

	public Integer viewBonusByCustomerById(Integer customerId);

	public List<RentalDetails> viewRentalHistoryByCustomerId(Integer customerId);

}
