package com.c4networks.vrms.wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;

import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.RentalFinalData;
import com.c4networks.vrms.vo.UserDetails;
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

	public List<CustomerDetails> getCustomersListForUser(String userId, String companyId) {
		System.out.println("In getAllCustomers method of Facade client");
		List<CustomerDetails> customersList = new ArrayList<CustomerDetails>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			customersList = port.getCustomersListForUser(userId, companyId);
			System.out.println("customers list size returned from webservice is :" + customersList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customersList;
	}

	public List<MovieDetails> getMoviesList(String userId, String companyId) {
		System.out.println("In getMoviesList method of Facade client");
		List<MovieDetails> moviesList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			moviesList = port.viewAllMoviesForUser(userId, companyId);
			System.out.println("moviesList size returned from webservice is :" + moviesList.size());
			for (MovieDetails m : moviesList) {
				System.out.println(m.getMovieName());
				System.out.println(m.getCategories());
				System.out.println(m.getCategories().getActivePrice());
				System.out.println(m.getCategories().getCategoryName());
				System.out.println(m.getCreatedBy());
			}
			System.out.println("Hello client");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public Integer addRental(RentalDetails bean, String customerId, UserDetails userDetails, String movieId,
			String expectedReturnDate) {
		Integer result = 0;
		System.out.println("In addRental method of Facade client");
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.addRental(bean, customerId, userDetails, movieId, expectedReturnDate);
			System.out.println("Add a Rental, result is :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<RentalDetails> getActiveRentalsList(String userId, String companyId) {
		System.out.println("In getActiveRentalsList method of Facade client");
		List<RentalDetails> rentalList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalList = port.viewActiveRentalsForAgent(userId, companyId);
			System.out.println("rentalList size returned from webservice is :" + rentalList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentalList;

	}

	public List<RentalDetails> getAllRentalsList(String userId, String companyId) {
		System.out.println("In getActiveRentalsList method of Facade client");
		List<RentalDetails> rentalList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalList = port.viewAllRentalsForAgent(userId, companyId);
			System.out.println("rentalList size returned from webservice is :" + rentalList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentalList;

	}

	public Integer viewBonusByCustomerById(String customerId) {
		System.out.println("VideoRentalManaementUI.viewBonusByCustomerById");
		Integer result = 0;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.viewBonusByCustomerById(customerId);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	public List<RentalDetails> getRentalsByCustomerId(String customerId) {
		System.out.println("VideoRentalManaementUI.getRentalsByCustomerId");
		List<RentalDetails> rentalList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalList = port.getRentalsByCustomerId(customerId);
			System.out.println("rentalList size returned from webservice is :" + rentalList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalList;

	}

	public Integer closeRental(RentalFinalData bean, Boolean bonusCheck) {
		System.out.println("VideoRentalManaementUI.closeRental");
		Integer result = 0;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.closeRental(bean, bonusCheck);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;

	}

	public RentalFinalData rentalFinalize(String rentalId) {
		System.out.println("VideoRentalManaementUI.rentalFinalize");
		RentalFinalData result = null;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.rentalFinalize(rentalId);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	public Integer addMovie(MovieDetails movie, String categoryId, UserDetails userDetails) {
		System.out.println("VideoRentalManaementUI.addMovie");
		Integer result = 0;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.addMovies(movie, categoryId, userDetails);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

	public List<Categories> getAllCategoriesForUser(String userId, String companyId) {
		System.out.println("In getActiveRentalsList method of Facade client");
		List<Categories> categoryList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			categoryList = port.viewAllMovieCategoriesForUser(userId, companyId);
			System.out.println("categoryList size returned from webservice is :" + categoryList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryList;

	}

	public Integer addCustomer(CustomerDetails customerDetails, UserDetails userDtls) {
		System.out.println("VideoRentalManagementClient.addCustomer");
		Integer result = 0;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.addCustomerForUser(customerDetails, userDtls);
			System.out.println("result is :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<RentalDetails> viewRentalHistoryByCustomerId(String customerId, String userId, String companyId) {
		System.out.println("VIdeoRentalManagementClient.viewRentalHistoryByCustomerId");
		List<RentalDetails> rentalsList = new ArrayList<>();
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			rentalsList = port.viewRentalHistoryByCustomerId(customerId, userId, companyId);
		} catch (Exception e) {
			e.getMessage();
		}
		return rentalsList;
	}

	public UserDetails getLoggedInUserDetails(String userId) {
		System.out.println("VIdeoRentalManagementClient.getLoggedInUserDetails");
		UserDetails userDetails = null;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			userDetails = port.getUserDetailsById(userId);
		} catch (Exception e) {
			e.getMessage();
		}
		return userDetails;
	}

	public Integer getAvailableMovieCopiesById(String movieId, String userId, String companyId) {
		System.out.println("VideoRentalManaementUI.getAvailableMovieCopiesById");
		Integer result = 0;
		try {
			VideoRentalManagementServicesManager port = service.getVideoRentalManagementServicesPort();
			result = port.getAvailableMovieCopies(movieId, userId, companyId);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

}
