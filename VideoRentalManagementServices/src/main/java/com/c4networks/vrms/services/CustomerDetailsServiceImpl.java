package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.c4networks.vrms.services.dao.CompanyDetailsDAOImpl;
import com.c4networks.vrms.services.dao.CustomerDetailsDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.AlphaNumerciRandomGenerator;
import com.c4networks.vrms.vo.AgentCustomerDetails;
import com.c4networks.vrms.vo.CompanyDetail;
import com.c4networks.vrms.vo.UserDetails;

@Component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CompanyDetailsDAOImpl companyDetailsDAO;

	@Autowired
	private CustomerDetailsDAOImpl customerDetailsDAO;

	private static final Logger logger = Logger.getLogger(CustomerDetailsServiceImpl.class.getName());

	public List<AgentCustomerDetails> getCustomers(String companyOID) {
		logger.info("In getCustomers() of CustomerDetailsService");
		List<AgentCustomerDetails> customerList = new ArrayList<>();
		try {
			CompanyDetail companyDetails = companyDetailsDAO.findByCompanyDetailsByOID(companyOID);
			customerList = customerDetailsDAO.findByProperty("companyDetails", companyDetails);
			logger.info("Customer List size :" + customerList.size());
			if (!customerList.isEmpty()) {
				Comparator<AgentCustomerDetails> comparator = Comparator
						.comparing(AgentCustomerDetails::getLastModifiedDate);
				return customerList.stream().sorted(comparator.reversed()).collect(Collectors.toList());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public Integer addCustomer(AgentCustomerDetails custDtls, UserDetails userDetails) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			AgentCustomerDetails bean = new AgentCustomerDetails();

//			String vrmsReference = "VRMS";
//			List<String> maxVrmsReference = customerDetailsDAO.getMaxVrmsReference();
//			logger.info("Size-------" + maxVrmsReference.size());
//			if (maxVrmsReference.size() > 0) {
//				String maxId = (String) maxVrmsReference.get(0);
//				logger.info("max id is:" + maxId);
//				if (maxId != null && !maxId.equals("")) {
//					Integer max = Integer.parseInt(maxId.substring(4));
//					max = max + 1;
//					if (max.toString().length() == 1)
//						vrmsReference += "00" + max;
//					else if (max.toString().length() == 2)
//						vrmsReference += "0" + max;
//					else
//						vrmsReference += max;
//					bean.setcVrmsId(vrmsReference);
//				} else
//					bean.setVrmsId("VRMS001");
//			}

			bean.setAgCustomerOID(AlphaNumerciRandomGenerator.generateAgentCustomerIdentifier());
			bean.setAgCustomerId(AlphaNumerciRandomGenerator.generateAlphaNumericSeqForAgentCustomerID());
			bean.setFirstName(custDtls.getFirstName());
			bean.setLastName(custDtls.getLastName());
			bean.setEmail(custDtls.getEmail());
			bean.setAddressLine1(custDtls.getAddressLine1());
			bean.setAddressLine2(custDtls.getAddressLine2());
			bean.setAddressLine3(custDtls.getAddressLine3());
			bean.setPhone(custDtls.getPhone());
			bean.setMobile(custDtls.getMobile());
			bean.setSex(custDtls.getSex());
			bean.setCompanyDetails(userDetails.getCompanyDetails());
			bean.setCreatedBy(userDetails);
			bean.setCreatedDate(new Date());
			bean.setLastModifiedBy(userDetails);
			bean.setLastModifiedDate(new Date());
			bean.setRoleId(userDetails.getRoleId());
			customerDetailsDAO.saveCustomerDetail(bean);
			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public AgentCustomerDetails getCustomerById(String customerId) {
		logger.info("CustomerDetailsServiceImpl.getCustomerById");
		AgentCustomerDetails customer = new AgentCustomerDetails();
		try {
			customer = customerDetailsDAO.findByCustomerId(customerId);
			logger.info("customer is ::" + customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
