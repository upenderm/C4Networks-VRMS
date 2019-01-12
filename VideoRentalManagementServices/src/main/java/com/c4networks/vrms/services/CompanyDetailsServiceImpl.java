package com.c4networks.vrms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CompanyDetailsDAO;
import com.c4networks.vrms.vo.CompanyDetail;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
	private static final Logger logger = Logger.getLogger(CategoriesDetailsServiceImpl.class.getName());

	@Autowired
	private CompanyDetailsDAO companyDetailDAO;

	@Override
	public CompanyDetail findCompanyDetailsById(String companyDetailId) {
		logger.info("CustomerDetailsServiceImpl.getCustomerById");
		CompanyDetail companyDetail = null;
		try {
			companyDetail = companyDetailDAO.findByCompanyDetailsId(companyDetailId);
			logger.info("companyDetail is ::" + companyDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyDetail;
	}

}
