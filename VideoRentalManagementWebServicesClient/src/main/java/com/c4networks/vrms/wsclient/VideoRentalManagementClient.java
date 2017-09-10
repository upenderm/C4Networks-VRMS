package com.c4networks.vrms.wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceFeature;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.Movies;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.webservices.VideoRentalManagementServices;
import com.c4networks.vrms.webservices.VideoRentalManagementServicesManager;

@HandlerChain(file = "handler-chain.xml")
public class VideoRentalManagementClient {

	private static VideoRentalManagementClient vrmsClient = null;
	private VideoRentalManagementServices service;
	protected String serviceName;
	protected String serviceNameSpace;

	private VideoRentalManagementClient() {
		System.out.println("In a private constructor");
		serviceName = "VideoRentalManagementServices";
		serviceNameSpace = "http://webservices.vrms.c4networks.com/";
		service = new VideoRentalManagementServices(getWSDLLocation(), getServiceQName());
	}

	public QName getServiceQName() {
		return new QName(serviceNameSpace, serviceName);
	}

	public URL getWSDLLocation() {

		URL wsdl = null;
		String wsdlLocation = "";
		wsdlLocation = "http://localhost:8080/VideoRentalManagementWebServices/services/VideoRentalManagementServices?wsdl";
		System.out.println("Getting WSDL from [" + wsdlLocation + "]");
		try {
			wsdl = new URL(wsdlLocation);
		} catch (MalformedURLException e) {
			System.out.println(e);
		}

		return wsdl;
	}

	public static VideoRentalManagementClient getInstance() {
		System.out.println("In GetInstance");
		if (vrmsClient == null) {
			System.out.println("Creating the object");
			vrmsClient = new VideoRentalManagementClient();
		}
		return vrmsClient;
	}

	public List<CustomerDetails> getAllCustomers() {
		System.out.println("In getAllCustomers method of Facade client");
		List<CustomerDetails> customersList = new ArrayList<CustomerDetails>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			customersList = port.getAllCustomers();
			System.out.println("customers list size returned from webservice is :" + customersList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customersList;
	}

	public List<Movies> getMoviesList() {
		System.out.println("In getMoviesList method of Facade client");
		List<Movies> moviesList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			moviesList = port.viewAllMovies();
			System.out.println("moviesList size returned from webservice is :" + moviesList.size());
			for(Movies m : moviesList){
				System.out.println(m.getMovieName());
				System.out.println(m.getCategories());
				System.out.println(m.getCategories().getPrice());
				System.out.println(m.getCategories().getCategoryName());
				System.out.println(m.getCustomerDetailsByCreatedBy());
				System.out.println(m.getCustomerDetailsByCreatedBy().getCustomerId());
			}
			System.out.println("Hello client");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public Integer addRental(RentalDetails bean) {
		Integer result = 0;
		System.out.println("In addRental method of Facade client");
		List<RentalDetails> rentalList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalList = port.viewActiveRentals();
			System.out.println("rentalList size returned from webservice is :" + rentalList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer getAvailableMovieCopiesById(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RentalDetails> getActiveRentalsList() {
		System.out.println("In getActiveRentalsList method of Facade client");
		List<RentalDetails> rentalList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalList = port.viewActiveRentals();
			System.out.println("rentalList size returned from webservice is :" + rentalList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentalList;

	}

	public List<RentalDetails> getRentalsList() {
		System.out.println("In getActiveRentalsList method of Facade client");
		List<RentalDetails> rentalList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalList = port.viewAllRentals();
			System.out.println("rentalList size returned from webservice is :" + rentalList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentalList;

	}

	public List<CustomerDetails> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer viewBonusByCustomerById(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RentalDetails> getRentalsByCustomerId(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer closeRental(RentalDetails bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] rentalFinalize(Integer rentalEditId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer addMovie(Movies bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categories> getCategories() {
		System.out.println("In getActiveRentalsList method of Facade client");
		List<Categories> categoryList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			categoryList = port.viewAllCategories();
			System.out.println("categoryList size returned from webservice is :" + categoryList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryList;

	}

	public Integer addCustomer(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RentalDetails> viewRentalHistoryByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
