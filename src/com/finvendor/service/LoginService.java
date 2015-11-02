/**
 * 
 */
package com.finvendor.service;

 
import org.springframework.stereotype.Service;

import com.finvendor.model.Users;

/**
 * @author rayulu vemula
 *
 */
@Service
public interface LoginService {

	/** --------------------------------------------------------------------- */
	/**
	 * Method to get user info by email
	 * 
	 * @param email
	 * @return 
	 */
	Users getUserInfoByEmail(String email);


}
