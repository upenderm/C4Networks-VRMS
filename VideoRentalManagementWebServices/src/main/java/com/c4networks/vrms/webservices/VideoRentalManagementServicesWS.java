package com.c4networks.vrms.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.c4networks.vrms.services.CategoriesDetailsService;
import com.c4networks.vrms.services.CustomerDetailsService;
import com.c4networks.vrms.services.MoviesService;
import com.c4networks.vrms.services.RentalService;
import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.CustomerDetails;
import com.c4networks.vrms.vo.Movies;
import com.c4networks.vrms.vo.RentalDetails;

@WebService(name = "VideoRentalManagementServicesManager", serviceName = "VideoRentalManagementServices", portName = "VideoRentalManagementServicesPort")
// @XmlSeeAlso(RentalDetails.class)
public class VideoRentalManagementServicesWS {

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Autowired
	private MoviesService moviesService;

	@Autowired
	private CategoriesDetailsService categoriesDetailsService;

	@Autowired
	private RentalService rentalService;

	@WebMethod
	public List<CustomerDetails> getAllCustomers() {
		List<CustomerDetails> custDtlsList = new ArrayList<>();
		try {
			custDtlsList = customerDetailsService.getCustomers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return custDtlsList;
	}

	@WebMethod
	public Integer addCustomer(CustomerDetails customerDetails) {
		Integer result = 0;
		try {
			result = customerDetailsService.addCustomer(customerDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public List<Movies> viewAllMovies() {
		List<Movies> moviesList = new ArrayList<>();
		try {
			moviesList = moviesService.getMoviesList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	@WebMethod
	public Integer addMovies(Movies movie) {
		Integer result = 0;
		try {
			result = moviesService.addMovie(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public List<Categories> viewAllCategories() {
		List<Categories> categoriesList = new ArrayList<>();
		try {
			categoriesList = categoriesDetailsService.getCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriesList;
	}

	@WebMethod
	public List<RentalDetails> viewActiveRentals() {
		List<RentalDetails> activeRentalsList = new ArrayList<>();
		try {
			activeRentalsList = rentalService.getActiveRentalsList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activeRentalsList;
	}

	@WebMethod
	public List<RentalDetails> viewAllRentals() {
		List<RentalDetails> allRentalList = new ArrayList<>();
		try {
			allRentalList = rentalService.getRentalsList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRentalList;
	}

	@WebMethod
	public List<RentalDetails> getRentalsByCustomerId(Integer customerId) {
		List<RentalDetails> allRentalList = new ArrayList<>();
		try {
			allRentalList = rentalService.getRentalsByCustomerId(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRentalList;
	}
	
	@WebMethod
	public List<RentalDetails> viewRentalHistoryByCustomerId(Integer customerId) {
		List<RentalDetails> rentalHistoryList = new ArrayList<>();
		try {
			rentalHistoryList = rentalService.viewRentalHistoryByCustomerId(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalHistoryList;
	}

	@WebMethod
	public Integer closeRental(RentalDetails rentalDetails, boolean bonusCheck) {
		Integer result = 0;
		try {
			result = rentalService.closeRental(rentalDetails, bonusCheck);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@WebMethod
	public String[] rentalFinalize(Integer rentalId) {
		String[] result = null;
		try {
			result = rentalService.rentalFinalize(rentalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@WebMethod
	public Integer viewBonusByCustomerById(Integer customerId) {
		Integer result = 0;
		try {
			result = rentalService.viewBonusByCustomerById(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
