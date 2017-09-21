package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.c4networks.vrms.services.dao.CustomerDetailsDAOImpl;
import com.c4networks.vrms.services.dao.MoviesDAOImpl;
import com.c4networks.vrms.services.dao.RentalDetailsDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.DateFormatter;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.Movies;
import com.c4networks.vrms.vo.RentalDetails;

@Component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailsDAOImpl customerDetailsDAO;
	
	@Autowired
	private RentalDetailsDAOImpl rentalDetailsDAO;
	
	@Autowired
	private MoviesDAOImpl movieDetailsDAO;

	private static final Logger logger = Logger.getLogger(CustomerDetailsServiceImpl.class.getName());

	public List<CustomerDetails> getCustomers() {
		logger.info("In getCustomers() of CustomerDetailsService");
		List<CustomerDetails> customerList = new ArrayList<>();
		try {
			customerList = customerDetailsDAO.findAll();
			logger.info("Customer List size :" + customerList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public Integer addCustomer(CustomerDetails custDtls) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			CustomerDetails bean = new CustomerDetails();

			String vrmsReference = "VRMS";
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
					bean.setVrmsId(vrmsReference);
				} else
					bean.setVrmsId("VRMS001");
			}

			bean.setFirstName(custDtls.getFirstName());
			bean.setLastName(custDtls.getLastName());
			bean.setEmail(custDtls.getEmail());
			bean.setAddress(custDtls.getAddress());
			bean.setPhone(custDtls.getPhone());
			bean.setMobile(custDtls.getMobile());
			bean.setStatus("ACTIVE");
			bean.setCreatedBy(1);
			bean.setCreatedDate(new Date());
			bean.setLastModifiedBy(1);
			bean.setLastModifiedDate(new Date());

			customerDetailsDAO.save(bean);
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
	public CustomerDetails getCustomerById(Integer customerId) {
		logger.info("CustomerDetailsServiceImpl.getCustomerById");
		CustomerDetails customer = new CustomerDetails();
		try {
			customer = customerDetailsDAO.findById(customerId);
			logger.info("customer is ::" + customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Integer addRental(RentalDetails rentalDetails, Integer customerId, Integer movieId, String expectedReturnDate) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			RentalDetails bean = new RentalDetails();

			CustomerDetails customerDetails = customerDetailsDAO.findById(customerId);
			bean.setCustomerDetails(customerDetails);

			Movies movies = movieDetailsDAO.findById(movieId);
			bean.setMovies(movies);

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
			bean.setRentalDate(new Date());
			bean.setExpectedReturnDate(DateFormatter.convertStringToDate(expectedReturnDate));

			if (movies.getCategories().getCategoryId() == 1) {
				bean.setBonusPoints(2);
			} else {
				bean.setBonusPoints(1);
			}
			bean.setBonusStatus("ACTIVE");
			bean.setRentalStatus("OPEN");
			bean.setLateCharges(0);

			rentalDetailsDAO.save(bean);

			movies.setCopies(movies.getCopies() - 1);
			movieDetailsDAO.save(movies);

			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
