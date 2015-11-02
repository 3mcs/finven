/**
 * 
 */
package com.finvendor.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finvendor.model.AssetClass;
import com.finvendor.model.Awards;
import com.finvendor.model.Cost;
import com.finvendor.model.Country;
import com.finvendor.model.Exchange;
import com.finvendor.model.Region;
import com.finvendor.model.Support;
import com.finvendor.model.UserRole;
import com.finvendor.model.Users;
import com.finvendor.model.Vendor;
import com.finvendor.model.VendorOffering;
import com.finvendor.model.VendorSupportCoverageDetails;
import com.finvendor.service.LoginService;
import com.finvendor.service.MarketDataAggregatorsService;
import com.finvendor.service.UserService;
import com.finvendor.service.VendorService;
import com.finvendor.util.CommonUtils;
import com.finvendor.util.RequestConstans;

/**
 * @author rayulu vemula
 *
 */
@Controller
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private MarketDataAggregatorsService marketDataAggregatorsService;
	
	
	@RequestMapping(value=RequestConstans.Home.HOME_PAGE, method=RequestMethod.GET)
	public ModelAndView homePageLand(ModelMap modelMap,HttpServletRequest request){
		logger.info("Method to load home page---:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Home.HOME_PAGE);
		return modelAndView;
	}

	@RequestMapping(value=RequestConstans.Login.LOGIN, method=RequestMethod.GET)
	public ModelAndView loginInfo(ModelMap modelMap,HttpServletRequest request){
		logger.info("Method to login page---:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Login.LOGIN);
		return modelAndView;
	}

	/**
	 * method for spring security checking through role
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value=RequestConstans.Login.LOGINVALIDATION, method=RequestMethod.POST)
	public ModelAndView loginValidation(ModelMap modelMap,HttpServletRequest request,
			@RequestParam(value = "VEuMlA", required = false) String username,
			@RequestParam(value = "RaYulU", required = false) String password){
		logger.info("Method to login page---:");
		ModelAndView modelAndView = new ModelAndView(RequestConstans.Register.EMPTY);
		boolean status = false;
		try{
			username=CommonUtils.decrypt(username.getBytes());
			password=CommonUtils.decrypt(password.getBytes());
			List<Users> users = userService.getUserInfoByNamewithPassword(username,password);
			if(users.size() > 0){
				status = false;
			}else{
				status = true;
			}
			modelAndView.addObject("status", status);
		}catch (Exception e) {
			modelAndView.addObject("status", true);
			e.printStackTrace();
			logger.error("Error to check user validation---:" + e);
		}
		return modelAndView;
	}

	
	/**
	 * method for spring security checking through role
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value=RequestConstans.Login.WELCOME, method=RequestMethod.GET)
	public ModelAndView welcomeInfo(HttpServletRequest request,@ModelAttribute("users") Users users,
			@ModelAttribute("userRole") UserRole userRole,@ModelAttribute("vendor") Vendor vendor){
		logger.info("Method to load all home pages---:");
		ModelAndView modelAndView=null;
		if(SecurityContextHolder.getContext().
				getAuthentication().getPrincipal() != null &&  SecurityContextHolder.getContext().
				getAuthentication().getPrincipal().equals(RequestConstans.Anonymous.ANONYMOUS_USER)){
			modelAndView=new ModelAndView(RequestConstans.Login.HOME);
		}else{
			List<AssetClass> assetClasses = null;
			List<Region> regions = null;
			List<Country> countries = null;
			List<Exchange> exchanges = null;
			List<Support> supports = null;
			List<Cost> costs = null;
			List<Awards> awards = null;
 			User appUser = (User)SecurityContextHolder.getContext().
					getAuthentication().getPrincipal();
			try{
			if(appUser.getAuthorities().contains(new GrantedAuthorityImpl(RequestConstans.Roles.ROLE_ADMIN))){
	       		modelAndView=new ModelAndView(RequestConstans.Login.ADMIN_INFO);
	       		modelAndView.addObject("username", appUser.getUsername());
	       	} else if(appUser.getAuthorities().contains(new GrantedAuthorityImpl(RequestConstans.Roles.ROLE_VENDOR))){
	       		modelAndView=new ModelAndView(RequestConstans.Login.VENDOR_INFO);
	       		assetClasses = marketDataAggregatorsService.getAllAssetClass();
				regions = marketDataAggregatorsService.getAllRegionClass();
				countries = marketDataAggregatorsService.getAllCountries();
				exchanges = marketDataAggregatorsService.getAllExchanges();
				supports =  marketDataAggregatorsService.getAllVendorSupports();
				costs  = marketDataAggregatorsService.getAllCostInfo();
				awards = marketDataAggregatorsService.getAllAwards();
				
				vendor = vendorService.getVendorDetails(appUser.getUsername());
				
				modelAndView.addObject("assetClasses", assetClasses);
				modelAndView.addObject("regions", regions);
				modelAndView.addObject("regionslist", regions);
				modelAndView.addObject("countries", countries);
				modelAndView.addObject("exchanges", exchanges);
				modelAndView.addObject("supports", supports);
				modelAndView.addObject("costs", costs);
				modelAndView.addObject("awards", awards);
	       		modelAndView.addObject("username", appUser.getUsername());
	       		modelAndView.addObject("myprofiletab", "myprofile");
	       		
	       		modelAndView.addObject("vendortabdetails", "vendortabdetails");
	       		
	       		modelAndView.addObject("vendor", vendor);
	       		
	       	} else if(appUser.getAuthorities().contains(new GrantedAuthorityImpl(RequestConstans.Roles.ROLE_CONSUMER))){
	       		modelAndView=new ModelAndView(RequestConstans.Login.CONSUMER_INFO);
	       	    
	       		assetClasses = marketDataAggregatorsService.getAllAssetClass();
				regions = marketDataAggregatorsService.getAllRegionClass();
				countries = marketDataAggregatorsService.getAllCountries();
				exchanges = marketDataAggregatorsService.getAllExchanges();
				supports =  marketDataAggregatorsService.getAllVendorSupports();
				costs  = marketDataAggregatorsService.getAllCostInfo();
				awards = marketDataAggregatorsService.getAllAwards();
				
				modelAndView.addObject("assetClasses", assetClasses);
				modelAndView.addObject("regions", regions);
				modelAndView.addObject("regionslist", regions);
				modelAndView.addObject("countries", countries);
				modelAndView.addObject("exchanges", exchanges);
				modelAndView.addObject("supports", supports);
				modelAndView.addObject("costs", costs);
				modelAndView.addObject("awards", awards);
	       		modelAndView.addObject("username", appUser.getUsername());
	       		modelAndView.addObject("consumerMyProfiletab", "consumermyprofile");
	       	}
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Error to load all home pages---:" + e);
			}
		}
		return modelAndView;
	}
	
	/**
	 * method for bad login info
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public ModelAndView loginError() {
		logger.info("Method for login failed---:");
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView=new ModelAndView(RequestConstans.Login.SIGNIN_FAILED);
        modelAndView.addObject("error", "true");
		return modelAndView;
 
	}
	/**
	 * method for access denied
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/access-denied")
    public String accessDenied() {
		logger.info("Method for access denied--:");
          return "access-denied"; // logical view name
     }
	
	/**
	 * method for login out
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		logger.info("Method for logout---:");
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView=new ModelAndView(RequestConstans.Login.HOME);
		return modelAndView;
 
	}
	
	/**
	 * method for my home
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Login.MY_HOME_PAGE, method = RequestMethod.GET)
	public ModelAndView myHomePage(@RequestParam("RaYUnA") String username) {
		logger.info("Method for logout---:");
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView  modelAndView= null;
		try{
			username = CommonUtils.decrypt(username.getBytes());
			modelAndView=new ModelAndView(RequestConstans.Login.HOME);
			modelAndView.addObject("myusername", username);
		}catch(Exception exception){
			exception.printStackTrace();
		}
        
		return modelAndView;
 
	}
	
	/**
	 * method to navigate forget password
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value =RequestConstans.Login.FORGET, method=RequestMethod.GET)
    public ModelAndView forgetPassword() {
		logger.info("Method forget password page---:");
        ModelAndView modelAndView=new ModelAndView(RequestConstans.Login.FORGET);
         return modelAndView;
     }
	
	/**
	 * method to reset action for forget password
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value =RequestConstans.Login.RESET_PASSWORD, method=RequestMethod.GET)
    public ModelAndView resetForgetPassword(@RequestParam("email") String email) {
		logger.info("Method to reset forget password---:");
		Users users=null;
        ModelAndView modelAndView=new ModelAndView(RequestConstans.Login.FORGET);
       try{
        if(!email.equals("") && email != null){
        	 users=loginService.getUserInfoByEmail(email); 
        }
       }
       catch(Exception ex){
    	   ex.printStackTrace();
       }
         return modelAndView;
     }
	
}
