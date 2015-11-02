package com.finvendor.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finvendor.service.ConsumerService;
import com.finvendor.service.VendorService;

@Controller
public class ValidationController {
	
	private static Logger logger = Logger.getLogger(ValidationController.class);
	
	@Resource(name="vendorService")
	private VendorService vendorService;
	
	@Resource(name="consumerService")
	private ConsumerService consumerService;
	
	@RequestMapping(value="checkExistingEmail", method=RequestMethod.POST)
	public String checkExistingEmail(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("param");
		logger.info("Validate existing Email : " + email);		
		try{
			if(vendorService.getVendorInfoByEmail(email) != null || consumerService.getConsumerInfoByEmail(email) != null){
				response.getWriter().print("Email is already registered !");
			}
		}catch (IOException exp) {
			logger.info("Error checking Email id : " + exp);
		}catch (Exception exp) {
			logger.info("Error checking Email id : " + exp);
			try{
				response.getWriter().print("Error validating Email id");
			}catch (IOException e) {
				logger.info("Error checking Email id : " + e);
			}
		}
		return null;
	}
}
