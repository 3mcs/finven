/**
 * 
 */
package com.finvendor.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finvendor.model.Consumer;
import com.finvendor.model.Roles;
import com.finvendor.model.UserRole;
import com.finvendor.model.Users;
import com.finvendor.model.Vendor;
import com.finvendor.service.ConsumerService;
import com.finvendor.service.UserService;
import com.finvendor.service.VendorService;
import com.finvendor.util.CommonUtils;
import com.finvendor.util.EmailUtil;
import com.finvendor.util.RequestConstans;

/**
 * @author rayulu vemula
 *
 */
@Controller
public class RegistrationController {

	private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	String[] vendorTypes = {"Financial Vendor- Data Aggregators", "Financial Vendor- Trading Applications","Financial Vendor- Financial Analytics applications","Financial Vendor- Research report"};
	String[] consumerTypes = {"Financial Firm - Sell side", "Financial Firm - Buy side","Financial Firm - Others","University/College","Other firm"};
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private ConsumerService consumerService;
	
	/**
	 * method for register navigation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */	
	@RequestMapping(value=RequestConstans.Register.REGISTER, method=RequestMethod.GET)
	public ModelAndView registerNavigation(HttpServletRequest request,@ModelAttribute("users") Users users){
		logger.info("Mehtod for toregisterNavigation--:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Register.REGISTER);
		modelAndView.addObject("users", new Users());
		return modelAndView;
	}

	/**
	 * method for check user name in database validation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Register.REGISTERUSERCHECK, method=RequestMethod.POST)
	public ModelAndView checkUserNameValidation(HttpServletRequest request,@ModelAttribute("users") Users users,
			@RequestParam(value = "VEuLA", required = false) String username){
		logger.info("Mehtod for check username in database --:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Register.EMPTY);
		try{
			username = CommonUtils.decrypt(username.getBytes());
			boolean isRxist = userService.validateUsername(username);
			modelAndView.addObject("status", isRxist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("Mehtod for check username validaton --:");
		}
		return modelAndView;
	}
	
	/**
	 * method for to check phone number validation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Register.PHONE_NUMBER_VALIDATION, method=RequestMethod.POST)
	public ModelAndView phoneNumberValidation(HttpServletRequest request,
			@RequestParam(value = "RaYuLu", required = false) String phoneNum){
		logger.info("Mehtod for check phone number validation--:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Register.EMPTY);
		String status = "failed";
		try{
			System.out.println("getting phone number validation--:");
			phoneNum = CommonUtils.decrypt(phoneNum.getBytes());
			//Initialize reg ex for phone number.   
			String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";  
			CharSequence inputStr = phoneNum;  
			Pattern pattern = Pattern.compile(expression);  
			Matcher matcher = pattern.matcher(inputStr);  
			if(!matcher.matches()){  
				status = "success";  
			}else{
				status = "failed";
			}  
			modelAndView.addObject("status", status);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("Mehtod for check phone number validaton--:");
		}
		return modelAndView;
	}
	
	
	/**
	 * method for to check designation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Register.COMPANY_DESIGNATION, method=RequestMethod.POST)
	public ModelAndView designationValidation(HttpServletRequest request,
			@RequestParam(value = "ChEnGaLrAy", required = false) String designation){
		logger.info("Mehtod for check designation validation--:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Register.EMPTY);
		String status = "failed";
		try{
			designation = CommonUtils.decrypt(designation.getBytes());
			if(!designation.matches("[a-zA-Z]+")){  
				status = "success";  
			}else{
				status = "failed";
			}  
			modelAndView.addObject("status", status);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("Mehtod for check designation validaton--:");
		}
		return modelAndView;
	}
	
	/**
	 * method for to check company url validation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Register.COMPANY_URL_VALIDATION, method=RequestMethod.POST)
	public ModelAndView companyURLValidation(HttpServletRequest request,
			@RequestParam(value = "RaYvEmU", required = false) String websiteUrl){
		logger.info("Mehtod for check company URL validation--:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Register.EMPTY);
		String status = "failed";
		try{
			String regex = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";
			/*String regex = "^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$";*/
			websiteUrl = CommonUtils.decrypt(websiteUrl.getBytes());
			if(IsMatch(websiteUrl,regex)){  
				status = "failed";  
			}else{
				status = "success";
			}  
			modelAndView.addObject("status", status);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("Mehtod for check company URL validaton--:");
		}
		return modelAndView;
	}

	// Comapny URL validation method..
 private static boolean IsMatch(String s, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(s);
            return matcher.matches();
        } catch (RuntimeException e) {
        return false;
    }       
 }   
	
	
	/**
	 * method for check user name in database validation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Register.CHECKEMAILEXIST, method=RequestMethod.POST)
	public ModelAndView checkEmailValidationExist(HttpServletRequest request,
			@RequestParam(value = "RAyVE", required = false) String email,
			@ModelAttribute("vendor") Vendor vendor,
			@ModelAttribute("consumer") Consumer consumer){
		logger.info("Mehtod for check email validation in database --:");
		ModelAndView modelAndView=new ModelAndView(RequestConstans.Register.EMPTY);
		boolean isExist = false;
		try{
			email = CommonUtils.decrypt(email.getBytes());
			vendor= vendorService.getVendorInfoByEmail(email);
			consumer = consumerService.getConsumerInfoByEmail(email);
			if(vendor!=null || consumer !=null){
				isExist = true;
			}else{
				isExist = false;
			}
			modelAndView.addObject("status", isExist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("Mehtod for check email validaton in database--:");
		}
		return modelAndView;
	}
	/**
	 * method for check email validation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value=RequestConstans.Register.EMAILVALIDATION, method=RequestMethod.POST)
	public ModelAndView emailValidationCheck(HttpServletRequest request,
			@RequestParam(value = "VeM", required = false) String emailId){
		logger.info("Mehtod to check email validation--:");
		ModelAndView modelAndView = new ModelAndView(RequestConstans.Register.EMPTY);
		String extension = ""; String status = "failed"; String checkValues = "gmail,yahoo,aol,rediff,hotmail,in,msn"; List<String>  emailList= null;
		try{
			if(emailId != null && !emailId.isEmpty()) {
				emailId=CommonUtils.decrypt(emailId.getBytes());
				if(emailId.split("@").length > 1) {
					if(emailId.split("@")[1].split("\\.").length > 1) {
						extension = emailId.split("@")[1].split("\\.")[0];
					} else {
						status = "success";
					}
				} else {
					status = "success";
				}
			} 
			 emailList = Arrays.asList(checkValues.split(","));
			for(String checkNames : emailList) {
				if(checkNames.equalsIgnoreCase(extension) ||
					(emailId.contains("@") && emailId.split("@").length >= 1 && emailId.split("@")[1].toLowerCase().contains(checkNames.toLowerCase()+"."))) {
					status="success";
					break;
				} 
			}
			modelAndView.addObject("status", status);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Mehtod to check email validation--:"+ e);
		}
		return modelAndView;
	}
	/**
	 * method for register navigation
	 * 
	 * @return modelAndView
	 * @throws Exception
	 *             the exception
	 */
	
	@RequestMapping(value=RequestConstans.Register.REGISTERATION, method=RequestMethod.POST)
	public ModelAndView saveVendorInfo(HttpServletRequest request,@ModelAttribute("users") Users users,
							@ModelAttribute("userRole") UserRole userRole,
							@ModelAttribute("roles") Roles roles,
							@ModelAttribute("vendor") Vendor vendor,
							@ModelAttribute("consumer") Consumer consumer,
							@RequestParam(value = "VEuMlA", required = false) String uname,
							@RequestParam(value = "RaYulU", required = false) String password,
							@RequestParam(value = "ChEnGA", required = false) String email,
							@RequestParam(value = "LaKS", required = false) String company,
							@RequestParam(value = "ZaB", required = false) String companytype,
							@RequestParam(value = "NoR", required = false) String tags){
		ModelAndView modelAndView=null;
		boolean status = false;
		try{
			uname=CommonUtils.decrypt(uname.getBytes());
			password=CommonUtils.decrypt(password.getBytes());
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			email=CommonUtils.decrypt(email.getBytes());
			logger.info("Mehtod to save vendor information--:");
			modelAndView=new ModelAndView(RequestConstans.Register.EMPTY);
			users.setUserName(uname.toLowerCase());
			users.setPassword(encoder.encode(password));
			users.setEnabled(false);
			users.setVerified("N");
			users.setRegistration_date(new Timestamp(System.currentTimeMillis()));
			userService.saveUserInfo(users);
			String registrationId = userService.insertRegistrationVerificationRecord(users.getUserName(), email, false);
			// Vendor information Registration
			if (Arrays.asList(vendorTypes).contains(companytype)) {
				roles.setId(new Integer(RequestConstans.Roles.ROLE_VENDOR_VALUE));
				userRole.setUsers(users);
				userRole.setRoles(roles);
				userService.saveUserRolesInfo(userRole);
				vendor.setId(UUID.randomUUID().toString());
				vendor.setFirstName(uname.toLowerCase());
				vendor.setLastName("");
				vendor.setDesignation("");
				vendor.setEmail(email.toLowerCase());
				vendor.setSecondary_email("");
				vendor.setTelephone("");
				vendor.setCompany(company);
				vendor.setCompany_info("best equite");
				vendor.setCompany_url(company);
				vendor.setCompanyType(companytype);
				vendor.setTags(tags);
				vendor.setUsers(users);
				vendor.setCompanyAddress("Bengalure");
				vendor.setCountryofincorp("");
				vendor.setRegionofincorp(new Integer(""));
				vendorService.saveVendorInfo(vendor);
				modelAndView.addObject("status", true);
			}else{
				roles.setId(new Integer(RequestConstans.Roles.ROLE_CONSUMER_VALUE));
				userRole.setUsers(users);
				userRole.setRoles(roles);
				userService.saveUserRolesInfo(userRole);
				consumer.setId(UUID.randomUUID().toString());
				consumer.setFirstName(uname.toLowerCase());
				consumer.setLastName(uname.toLowerCase());
				consumer.setEmail(email.toLowerCase());
				consumer.setTelephone("8888888888");
				consumer.setCompany(company);
				consumer.setCompanyType(companytype);
				consumer.setTags(tags);
				consumer.setUsers(users);
				consumerService.saveConsumerInfo(consumer);
				modelAndView.addObject("status", true);
			}
			EmailUtil emailUtil = new EmailUtil();
			emailUtil.sendRegistartionEmail(users, email.toLowerCase(), registrationId);
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Error saving vendor inforamtion--"+ e);
			modelAndView.addObject("status", status);
		}
				
		return modelAndView;
	}
	
	
	@RequestMapping(value="validateRegistrationEmail", method=RequestMethod.GET)
	public ModelAndView validateRegistrationEmail(HttpServletRequest request,
			@RequestParam(value = "param", required = true) String regId){
		logger.debug("Entering RegistrationController:validateRegistrationEmail for {}", regId);
		ModelAndView modelAndView = new ModelAndView(RequestConstans.Register.USER_VERIFICATION_PAGE);
		boolean userVerified = false;
		try{
			String[] paramArray = regId.split("@");
			String registrationId = paramArray[0];
			String username = paramArray[1];
			logger.debug("RegistrationController:validateRegistrationEmail : registrationId = {}", registrationId);
			logger.debug("RegistrationController:validateRegistrationEmail : username = {}", username);
			modelAndView.addObject("username", username);
			userVerified = userService.updateUserVerificationStatus(username, registrationId);
			if(!userVerified){
				logger.error("Error validating registrationId {}", registrationId);
				userVerified = userService.validateUsername(username);
				if(userVerified){
					modelAndView.addObject("errorMessage", "Error validating registration Id.<br>Validation link may have been expired");
					modelAndView.addObject("linkExpired", true);
					String email = userService.getRegistrationEmailForUsername(username);
					logger.debug("RegistrationController:validateRegistrationEmail : email = {}", email);
					modelAndView.addObject("registrationEmail", email);
				}else{
					modelAndView.addObject("errorMessage", "Error validating registration Id.<br>User Id " + username + " is not available.");	
				}
			}
			
		}catch (Exception exp) {
			logger.error("Error validating User Registration", exp);
			modelAndView.addObject("errorMessage", "Error validation registration Id : " + exp.getMessage());	
		}
		logger.debug("Leaving RegistrationController:validateRegistrationEmail for {}", regId);
		return modelAndView;
	}
	
	@RequestMapping(value="resendRegistrationLink", method=RequestMethod.GET)
	public ModelAndView resendRegistrationLink(HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "email", required = true) String email){
		logger.debug("Entering RegistrationController:resendRegistrationLink for {}", username);
		ModelAndView modelAndView = new ModelAndView(RequestConstans.Register.USER_VERIFICATION_PAGE);
		try{			
			Users user = userService.getUserDetailsByUsername(username);
			String registrationId = userService.insertRegistrationVerificationRecord(user.getUserName(), email, true);
			EmailUtil emailUtil = new EmailUtil();
			emailUtil.sendRegistartionEmail(user, email.toLowerCase(), registrationId);
			modelAndView.addObject("resendRegistrationLink", "success");	
		}catch (Exception exp) {
			logger.error("Error Resending User Registration link", exp);
			modelAndView.addObject("errorMessage", "Error Resending User Registration link : " + exp.getMessage());	
			modelAndView.addObject("resendRegistrationLink", "error");
		}
		logger.debug("Leaving RegistrationController:resendRegistrationLink for {}", username);
		return modelAndView;
	}
	
	
}
