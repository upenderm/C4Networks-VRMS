package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CustomerBonusDAO;
import com.c4networks.vrms.services.dao.CustomerBonusDAOImpl;
import com.c4networks.vrms.services.dao.CustomerDetailsDAO;
import com.c4networks.vrms.services.dao.MovieDetailsDAO;
import com.c4networks.vrms.services.dao.RentalDetailsDAO;
import com.c4networks.vrms.services.dao.RentalDetailsDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.services.util.AlphaNumerciRandomGenerator;
import com.c4networks.vrms.services.util.DateFormatter;
import com.c4networks.vrms.vo.AgentCustomerDetails;
import com.c4networks.vrms.vo.CustomerBonus;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.RentalFinalData;
import com.c4networks.vrms.vo.UserDetails;

@Service
public class RentalServiceImpl implements RentalService {

	private static final Logger logger = Logger.getLogger(RentalServiceImpl.class.getName());

	@Autowired
	private RentalDetailsDAO rentalDetailsDAO;

	@Autowired
	private MovieDetailsDAO movieDetailsDAO;

	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;

	@Autowired
	private CustomerBonusDAOImpl customerBonusDAO;

	@Override
	public List<RentalDetails> getActiveRentalsList(String companyId) {
		logger.info("In getActiveRentalsList() of RentalService");
		List<RentalDetails> rentalsList;
		rentalsList = rentalDetailsDAO.findByProperty("companyDetails.companyId",
				companyId, "status", "OPEN");
		logger.info("Rental List size :" + rentalsList.size());

		return rentalsList;
	}

	@Override
	public List<RentalDetails> getAllRentalsList(String companyId) {
		logger.info("In getRentalsList() of RentalService");
		List<RentalDetails> rentalsList;
		rentalsList = rentalDetailsDAO.findByProperty("companyDetails.companyId",
				companyId);
		logger.info("Rental List size :" + rentalsList.size());

		return rentalsList;
	}

	@Override
	public Integer addRental(RentalDetails rentalDetails, String customerId, UserDetails userDetails, String movieId,
			String expectedReturnDate) {
		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			RentalDetails rentalBean = new RentalDetails();

			rentalBean.setRentalId(AlphaNumerciRandomGenerator.generateAlphaNumericSeqForRentalID());

			AgentCustomerDetails customerDetails = customerDetailsDAO.findByCustomerId(customerId);
			rentalBean.setAgentCustomerDetails(customerDetails);

			rentalBean.setCompanyDetails(userDetails.getCompanyDetails());

			MovieDetails movies = movieDetailsDAO.findByMovieId(movieId);
			rentalBean.setMovieDetails(movies);
			rentalBean.setCompanyDetails(userDetails.getCompanyDetails());

			/*String rentalReference = "RNT";
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
			}*/

			rentalBean.setRentalDate(new Date());
			rentalBean.setExpectedReturnDate(DateFormatter.convertStringToDate(expectedReturnDate));
			rentalBean.setActualReturnDate(null);
			rentalBean.setCharges(movies.getCategories().getActivePrice());
			rentalBean.setLateCharges(0);
			rentalBean.setEffectiveCharges(0);
			rentalBean.setStatus("OPEN");
			rentalBean.setComments(rentalDetails.getComments());

			CustomerBonus bonus = new CustomerBonus();
			bonus.setBonusId(AlphaNumerciRandomGenerator.generateAlphaNumericSeqForBonusID());
			bonus.setAgentCustomerDetails(customerDetails);
			bonus.setBonusPoints(movies.getCategories().getBonus());
			bonus.setBonusVersion(1);
			bonus.setCreatedBy(userDetails);
			bonus.setCreatedDate(new Date());
			bonus.setLastModifiedBy(userDetails);
			bonus.setLastModifiedDate(new Date());

			movies.setAvailableCopies(movies.getAvailableCopies() - 1);
			movies.setLastModifiedBy(userDetails);
			movies.setLastModifiedDate(new Date());

			customerBonusDAO.saveCustomerBonus(bonus);
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

	@Override
	public Integer closeRental(RentalFinalData finalData, boolean bonusCheck) {
		logger.info("rental id received is :" + finalData.getRentalId());

		Session session = null;
		Transaction transaction = null;
		Integer result = 0;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			RentalDetailsDAOImpl dao = new RentalDetailsDAOImpl();
			CustomerBonusDAO bonusDao = new CustomerBonusDAOImpl();

			RentalDetails bean = dao.findByRentalId(finalData.getRentalId());

			bean.setStatus("CLOSE");
			bean.setActualReturnDate(new Date());

			bean.setComments(finalData.getComments());
			bean.setEffectiveCharges(finalData.getBilledAmount()
					+ (finalData.getLateCharges() != null ? finalData.getLateCharges() : 0));

			session.update(bean);

			logger.info("bonus check from rentalDetails is :" + bonusCheck);
			if (bonusCheck) {
				List<CustomerBonus> list = bonusDao.findByProperty("customerDetails.customerId", bean.getAgentCustomerDetails().getAgCustomerOID(), "bonusVersion", 1);
				for (CustomerBonus cb : list) {
					cb.setBonusVersion(0);
					session.update(cb);
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

	@Override
	public List<RentalDetails> getRentalsByCustomerId(String customerId) {
		List<RentalDetails> list = new ArrayList<RentalDetails>();
		logger.info("Received customer id is :" + customerId);
		try {
			RentalDetailsDAOImpl rentalDetailsDAO = new RentalDetailsDAOImpl();
			list = rentalDetailsDAO.findByProperty("customerDetails.customerId", customerId, "status", "OPEN");
			logger.info("rental details list size:" + list.size());
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public RentalFinalData rentalFinalize(String rentalEditId) {

		RentalFinalData finalData = new RentalFinalData();
		try {
			RentalDetailsDAOImpl rentalDetailsDAO = new RentalDetailsDAOImpl();
			RentalDetails rd = rentalDetailsDAO.findByRentalId(rentalEditId);

			Date rntdDate = rd.getRentalDate();
			Date currDate = new Date();
			//			int diff = currDate.compareTo(rntdDate);
			int diff = (int) DateFormatter.getNoofDays(currDate, rntdDate);
			logger.info("difference in dates is :" + diff);

			Integer price = rd.getMovieDetails().getCategories().getActivePrice();
			finalData.setActualPrice(price);
			Integer total = price * diff;
			finalData.setTotalPrice(total);
			finalData.setLateCharges(0);
			if (diff > 1) {
				diff = diff - 1;
				total = price * diff;
				finalData.setTotalPrice(total);
			}
			finalData.setCustomerName(rd.getAgentCustomerDetails().getFirstName());
			finalData.setMovieName(rd.getMovieDetails().getMovieName());
			finalData.setCustomerId(rd.getAgentCustomerDetails().getAgCustomerId().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalData;
	}

	@Override
	public Integer viewBonusByCustomerById(String customerId) {
		Integer bonus = 0;
		List<CustomerBonus> list = customerBonusDAO.findByProperty("customerDetails.customerId", customerId,
				"bonusVersion", 1);
		if (list.size() == 0) {
			bonus = list.get(0).getBonusPoints();
		} else {
			int counter = 0;
			for (CustomerBonus cbean : list) {
				counter = counter + cbean.getBonusPoints();
			}
			bonus = counter;
		}
		return bonus;
	}

	@Override
	public List<RentalDetails> viewRentalHistoryByCustomerId(String customerId, String companyCode) {
		logger.info("customer id is :" + customerId);
		RentalDetailsDAOImpl dao = new RentalDetailsDAOImpl();
		List<RentalDetails> list = dao.findByProperty("customerDetails.customerId", customerId, "companyDetails.companyId", companyCode);
		logger.info("history list size is :" + list.size());
		return list;
	}

}
