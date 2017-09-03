package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CategoriesDAO;
import com.c4networks.vrms.services.dao.CustomerDetailsDAO;
import com.c4networks.vrms.services.dao.CustomerDetailsDAOImpl;
import com.c4networks.vrms.services.dao.MoviesDAO;
import com.c4networks.vrms.services.dao.MoviesDAOImpl;
import com.c4networks.vrms.services.dao.RentalDetailsDAO;
import com.c4networks.vrms.services.dao.RentalDetailsDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.DateFormatter;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.Movies;
import com.c4networks.vrms.vo.RentalDetails;

@Service
public class RentalServiceImpl implements RentalService{

	private static final Logger logger = Logger.getLogger(RentalServiceImpl.class.getName());

	@Autowired
	private RentalDetailsDAO rentalDetailsDAO;
	
	@Autowired
	private MoviesDAO moviesDAO;

	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;
	
	public List<RentalDetails> getActiveRentalsList() {
		logger.info("In getActiveRentalsList() of RentalService");
		List<RentalDetails> rentalsList;
		rentalsList = rentalDetailsDAO.findByProperty("rentalStatus", "OPEN");
		logger.info("Rental List size :" + rentalsList.size());

		return rentalsList;
	}

	public List<RentalDetails> getRentalsList() {
		logger.info("In getRentalsList() of RentalService");
		List<RentalDetails> rentalsList;
		rentalsList = rentalDetailsDAO.findAll();
		logger.info("Rental List size :" + rentalsList.size());

		return rentalsList;
	}

	public Integer addRental(RentalDetails rentalDtls) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			RentalDetails bean = new RentalDetails();

			CustomerDetails customerDetails = customerDetailsDAO.findById(rentalDtls.getCustomerDetails().getCustomerId());
			bean.setCustomerDetails(customerDetails);

			Movies movies = moviesDAO.findById(rentalDtls.getMovies().getMovieId());
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
			bean.setExpectedReturnDate(rentalDtls.getExpectedReturnDate());

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
			moviesDAO.save(movies);

			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public Integer closeRental(RentalDetails rentalDetails, boolean bonusCheck) {
		logger.info("rental id received is :" + rentalDetails.getRentalDetailsId());

		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			RentalDetailsDAOImpl dao = new RentalDetailsDAOImpl();

			RentalDetails bean = dao.findById(rentalDetails.getRentalDetailsId());

			bean.setRentalStatus("CLOSE");
			bean.setActualReturnDate(new Date());

			bean.setComments(rentalDetails.getComments());
			bean.setAmount(rentalDetails.getAmount());

			session.update(bean);

			logger.info("bonus check from rentalDetails is :" + bonusCheck);
			if (bonusCheck) {
				List<RentalDetails> list = dao.findByProperty("customerDetails.customerId", bean.getCustomerDetails().getCustomerId(), "bonusStatus", "ACTIVE");
				for (RentalDetails rd : list) {
					rd.setBonusStatus("INACTIVE");
					session.update(rd);
				}
			}

			transaction.commit();
			if (transaction.wasCommitted()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<RentalDetails> getRentalsByCustomerId(Integer customerId) {
		List<RentalDetails> list = new ArrayList<RentalDetails>();
		logger.info("Received customer id is :"+customerId);
		try {
			RentalDetailsDAOImpl rentalDetailsDAO = new RentalDetailsDAOImpl();
			list = rentalDetailsDAO.findByProperty("customerDetails.customerId", customerId, "rentalStatus", "OPEN");
			logger.info("rental details list size:" + list.size());
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	public String[] rentalFinalize(Integer rentalEditId) {

		String[] finalData = new String[6];
		try {
			RentalDetailsDAOImpl rentalDetailsDAO = new RentalDetailsDAOImpl();
			RentalDetails rd = rentalDetailsDAO.findById(rentalEditId);

			Date rntdDate = rd.getRentalDate();
			Date currDate = new Date();
//			int diff = currDate.compareTo(rntdDate);
			int diff = (int)DateFormatter.getNoofDays(currDate, rntdDate);
			logger.info("difference in dates is :" + diff);

			Integer price = rd.getMovies().getCategories().getPrice();
			finalData[0] = price.toString();
			Integer total = price * diff;
			finalData[1] = total.toString();
			if (diff > 1) {
				diff = diff - 1;
				total = price * diff;
				finalData[2] = total.toString();
			}
			finalData[3] = rd.getCustomerDetails().getFirstName();
			finalData[4] = rd.getMovies().getMovieName();
			finalData[5] = rd.getCustomerDetails().getCustomerId().toString();
			logger.info("Calculated charges per day are :" + finalData[0]);
			logger.info("Calculated charges total are :" + finalData[1]);
			logger.info("Calculated late charges are :" + finalData[2]);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalData;
	}

	public Integer viewBonusByCustomerById(Integer customerId) {
		Integer bonus = 0;
		RentalDetailsDAOImpl dao = new RentalDetailsDAOImpl();
		List<RentalDetails> list = dao.findByProperty("customerDetails.customerId", customerId, "bonusStatus", "ACTIVE");
		for (RentalDetails rd : list) {
			bonus = bonus + rd.getBonusPoints();
		}
		return bonus;
	}

	public List<RentalDetails> viewRentalHistoryByCustomerId(Integer customerId) {
		logger.info("customer id is :"+customerId);
		RentalDetailsDAOImpl dao = new RentalDetailsDAOImpl();
		List<RentalDetails> list = dao.findByProperty("customerDetails.customerId", customerId, "rentalStatus", "CLOSE");
		logger.info("history list size is :"+list.size());
		return list;
	}

}