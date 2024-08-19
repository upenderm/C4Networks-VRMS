package com.c4networks.vrms.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.c4networks.vrms.services.CategoriesDetailsService;
import com.c4networks.vrms.services.CustomerDetailsService;
import com.c4networks.vrms.services.MoviesService;
import com.c4networks.vrms.services.RentalService;
import com.c4networks.vrms.services.UserDetailsService;
import com.c4networks.vrms.vo.Categories;
import com.c4networks.vrms.vo.AgentCustomerDetails;
import com.c4networks.vrms.vo.MovieDetails;
import com.c4networks.vrms.vo.RentalDetails;
import com.c4networks.vrms.vo.RentalFinalData;
import com.c4networks.vrms.vo.UserDetails;

@HandlerChain(file = "handler-chain.xml")
@WebService(name = "VideoRentalManagementServicesManager", serviceName = "VideoRentalManagementServices", portName = "VideoRentalManagementServicesPort")
@XmlSeeAlso({ RentalDetails.class, MovieDetails.class, AgentCustomerDetails.class, Categories.class, RentalFinalData.class })
public class VideoRentalManagementServicesWS {

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Autowired
	private MoviesService moviesService;

	@Autowired
	private CategoriesDetailsService categoriesDetailsService;

	@Autowired
	private RentalService rentalService;

	@Autowired
	private UserDetailsService usrDtlsService;

	@WebMethod
	public List<AgentCustomerDetails> getCustomersListForUser(String companyOID) {
		List<AgentCustomerDetails> custDtlsList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			custDtlsList = customerDetailsService.getCustomers(companyOID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return custDtlsList;
	}

	@WebMethod
	public Integer addCustomerForUser(AgentCustomerDetails custDtls, UserDetails userDetails) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = customerDetailsService.addCustomer(custDtls, userDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public List<MovieDetails> viewAllMoviesForUser(String companyOID) {
		List<MovieDetails> moviesList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			moviesList = moviesService.getMoviesList(companyOID);
			for (MovieDetails m : moviesList) {
				System.out.println(m.getMovieName());
				System.out.println(m.getCategories());
				System.out.println(m.getCategories().getActivePrice());
				System.out.println(m.getCategories().getCategoryName());
				System.out.println(m.getCreatedBy());
			}
			System.out.println("Hello");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	@WebMethod
	public Integer addMovies(MovieDetails movie, String categoryId, UserDetails userDetails) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = moviesService.addMovie(movie, categoryId, userDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public List<Categories> viewAllMovieCategoriesForUser(String companyOID) {
		List<Categories> categoriesList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			categoriesList = categoriesDetailsService.getAllCategoriesForUser(companyOID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriesList;
	}
	
	@WebMethod
	public Categories getCategoriesDetailsById(String catId) {
		Categories cdls = null;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			cdls = categoriesDetailsService.getCategoriesById(catId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cdls;
	}
	
	@WebMethod
	public Integer addCategory(Categories category, UserDetails userDetails) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = categoriesDetailsService.addCategory(category, userDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@WebMethod
	public Integer deleteCategory(Categories category) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = categoriesDetailsService.deleteCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public Integer addRental(RentalDetails rentalDetails, String customerId, UserDetails userDetails, String movieId,
			String expectedReturnDate) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = rentalService.addRental(rentalDetails, customerId, userDetails, movieId, expectedReturnDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public List<RentalDetails> viewActiveRentalsForAgent(String companyId) {
		List<RentalDetails> activeRentalsList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			activeRentalsList = rentalService.getActiveRentalsList(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activeRentalsList;
	}
	
	@WebMethod
	public List<RentalDetails> viewInactiveRentalsForAgent(String companyId) {
		List<RentalDetails> inActiveRentalsList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			inActiveRentalsList = rentalService.getInactiveRentalsList(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inActiveRentalsList;
	}

	@WebMethod
	public List<RentalDetails> viewAllRentalsForAgent(String companyId) {
		List<RentalDetails> allRentalList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			allRentalList = rentalService.getAllRentalsList(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRentalList;
	}

	@WebMethod
	public List<RentalDetails> getRentalsByCustomerId(String customerId) {
		List<RentalDetails> allRentalList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			allRentalList = rentalService.getRentalsByCustomerId(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRentalList;
	}

	@WebMethod
	public List<RentalDetails> viewRentalHistoryByCustomerId(String customerId, String companyId) {
		List<RentalDetails> rentalHistoryList = new ArrayList<>();
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			rentalHistoryList = rentalService.viewRentalHistoryByCustomerId(customerId, companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalHistoryList;
	}

	@WebMethod
	public Integer closeRental(RentalFinalData finalData, boolean bonusCheck) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = rentalService.closeRental(finalData, bonusCheck);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public RentalFinalData rentalFinalize(String rentalId) {
		RentalFinalData result = null;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = rentalService.rentalFinalize(rentalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public Integer viewBonusByCustomerById(String customerId) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = rentalService.viewBonusByCustomerById(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public Integer getAvailableMovieCopies(String movieId, String companyId) {
		Integer result = 0;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			result = moviesService.getAvailableMovieCopiesById(movieId, companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public AgentCustomerDetails getCustomerDetailsById(String custId) {
		AgentCustomerDetails cdls = null;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			cdls = customerDetailsService.getCustomerById(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cdls;
	}

	@WebMethod
	public UserDetails getUserDetailsById(String userId) {
		System.out.println("UserId is :" + userId);
		UserDetails userDetails = null;
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			userDetails = usrDtlsService.getLoggedInUserDetailsByUserName(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}

}
