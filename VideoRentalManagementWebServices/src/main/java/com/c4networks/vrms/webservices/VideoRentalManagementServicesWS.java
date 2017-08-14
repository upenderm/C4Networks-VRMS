package com.c4networks.vrms.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.c4networks.vrms.services.CustomerDetailsService;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.RentalDetails;

@WebService(name = "VideoRentalManagementServicesManager", serviceName = "VideoRentalManagementServices", portName = "VideoRentalManagementServicesPort")
// @XmlSeeAlso(RentalDetails.class)
public class VideoRentalManagementServicesWS {

	@WebMethod
	public List<CustomerDetails> getAllCustomers() {

		CustomerDetailsService service = new CustomerDetailsService();
		List<CustomerDetails> customersList = service.getCustomers();

		return customersList;
	}

	@WebMethod
	public Integer addCustomer(CustomerDetails action) {

		CustomerDetailsService service = new CustomerDetailsService();
		Integer result = service.addCustomer(action);
		return result;
	}

}
