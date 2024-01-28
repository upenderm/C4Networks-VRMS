package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.c4networks.vrms.services.dao.CustomerBonusDAOImpl;
import com.c4networks.vrms.services.dao.CustomerDetailsDAOImpl;
import com.c4networks.vrms.services.dao.MovieDetailsDAOImpl;
import com.c4networks.vrms.services.dao.RentalDetailsDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.AlphaNumerciRandomGenerator;
import com.c4networks.vrms.services.util.DateFormatter;
import com.c4networks.vrms.vo.CustomerBonus;
import com.c4networks.vrms.vo.AgentCustomerDetails;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.UserDetails;

@Component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailsDAOImpl customerDetailsDAO;

	@Autowired
	private RentalDetailsDAOImpl rentalDetailsDAO;

	@Autowired
	private CustomerBonusDAOImpl CustomerBonusDAO;

	@Autowired
	private MovieDetailsDAOImpl movieDetailsDAO;

	private static final Logger logger = Logger.getLogger(CustomerDetailsServiceImpl.class.getName());

	public List<AgentCustomerDetails> getCustomers(String companyId) {
		logger.info("In getCustomers() of CustomerDetailsService");
		List<AgentCustomerDetails> customerList = new ArrayList<>();
		try {
			customerList = customerDetailsDAO.findByProperty("companyDetails.companyOID", companyId);
			logger.info("Customer List size :" + customerList.size());
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

			/*String vrmsReference = "VRMS";
			List<String> maxVrmsReference = customerDetailsDAO.getMaxVrmsReference();
			logger.info("Size-------" + maxVrmsReference.size());
			if (maxVrmsReference.size() > 0) {
				String maxId = (String) maxVrmsReference.get(0);
				logger.info("max id is:" + maxId);
				if (maxId != null && !maxId.equals("")) {
					Integer max = Integer.parseInt(maxId.substring(4));
					max = max + 1;
					if (max.toString().length() == 1)
						vrmsReference += "00" + max;
					else if (max.toString().length() == 2)
						vrmsReference += "0" + max;
					else
						vrmsReference += max;
					bean.setcVrmsId(vrmsReference);
				} else
					bean.setVrmsId("VRMS001");
			}*/

			bean.setAgCustomerOID(custDtls.getAgCustomerOID());
			bean.setAgCustomerId(custDtls.getAgCustomerId());
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

	@Override
	public Integer addRental(RentalDetails rentalDetails, String customerId, UserDetails userDetails, String movieId,
			String expectedReturnDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Integer addRental(RentalDetails rentalDetails, String customerId, UserDetails userDetails,
			String movieId, String expectedReturnDate) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			RentalDetails rentalBean = new RentalDetails();
			CustomerBonus bonus = new CustomerBonus();

			AgentCustomerDetails customerDetails = customerDetailsDAO.findByCustomerId(customerId);
			rentalBean.setCustomerDetails(customerDetails);

			MovieDetails movies = movieDetailsDAO.findByMovieId(movieId);
			rentalBean.setMovieDetails(movies);
			rentalBean.setCompanyDetails(userDetails.getCompanyDetails());
			rentalBean.setAgentCode(userDetails);

			String rentalReference = "RNT";
			List<String> maxRentalReference = rentalDetailsDAO.getMaxRentalReference();
			logger.info("Size-------" + maxRentalReference.size());
			if (maxRentalReference.size() > 0) {
				String maxId = (String) maxRentalReference.get(0);
				logger.info("max id is:" + maxId);
				if (maxId != null && !maxId.equals("")) {
					Integer max = Integer.parseInt(maxId.substring(3));
					max = max + 1;
					if (max.toString().length() == 1)
						rentalReference += "00" + max;
					else if (max.toString().length() == 2)
						rentalReference += "0" + max;
					else
						rentalReference += max;
					bean.setRentalId(rentalReference);
				} else
					bean.setRentalId("RNT001");
			}

			rentalBean.setRentalId(AlphaNumerciRandomGenerator.generateAlphaNumericSeqForRentalID());
			rentalBean.setRentalDate(new Date());
			rentalBean.setExpectedReturnDate(DateFormatter.convertStringToDate(expectedReturnDate));

			rentalBean.setStatus("OPEN");
			//			bean.setLateCharges(0);

			bonus.setCustomerId(customerDetails);
			bonus.setBonusPoints(movies.getCategories().getBonus());
			bonus.setBonusVersion(1);
			bonus.setCreatedBy(userDetails.getUserId());
			bonus.setCreatedDate(new Date());
			bonus.setLastModifiedBy(userDetails.getUserId());
			bonus.setLastModifiedDate(new Date());

			movies.setAvailableCopies(movies.getAvailableCopies() - 1);
			movies.setLastModifiedBy(userDetails);
			movies.setLastModifiedDate(new Date());

			CustomerBonusDAO.saveCustomerBonus(bonus);
			movieDetailsDAO.saveMovieDetail(movies);
			rentalDetailsDAO.saveRentalDetails(rentalBean);

			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
*/
}
