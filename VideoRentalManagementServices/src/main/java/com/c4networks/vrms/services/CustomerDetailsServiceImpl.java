package com.c4networks.vrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.c4networks.vrms.services.dao.CustomerDetailsDAOImpl;
import com.c4networks.vrms.services.hibernate.HibernateSessionFactory;
import com.c4networks.vrms.vo.CustomerDetails;

@Component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailsDAOImpl customerDetailsDAO;

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

	public Integer addCustomer(CustomerDetails action) {
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

			bean.setFirstName(action.getFirstName().trim());
			bean.setLastName(action.getLastName().trim());
			bean.setEmail(action.getEmail().trim());
			bean.setAddress(action.getAddress().trim());
			bean.setPhone(action.getPhone().trim());
			bean.setMobile(action.getMobile().trim());
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

}
