/**
 * 
 */
package com.finvendor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finvendor.model.UserRole;
import com.finvendor.model.Users;

/**
 * @author rayulu vemula
 *
 */
@Service
public interface UserService {

	/** --------------------------------------------------------------------- */
	/**
	 * Method to save user infor type
	 * 
	 * @param users
	 * @return integer
	 */
	public void saveUserInfo(Users users);

	/** --------------------------------------------------------------------- */
	/**
	 * Method to save userrole info type
	 * 
	 * @param userRole
	 * @return 
	 */
	public void saveUserRolesInfo(UserRole userRole);

	/** --------------------------------------------------------------------- */
	/**
	 * Method to validate user name
	 * 
	 * @param username
	 * @return 
	 */
	public boolean validateUsername(String username);

	/** --------------------------------------------------------------------- */
	/**
	 * Method to get userrole info by username
	 * 
	 * @param username
	 * @return 
	 */
	public UserRole getUserRoleInfobyUsername(String username);



	/** --------------------------------------------------------------------- */
	/**
	 * Method to get user info
	 * 
	 * @param username,password
	 * @return 
	 */
	public List<Users> getUserInfoByNamewithPassword(String username,
			String password);
	
	
	public Users getUserDetailsByUsername(String username);
	public int updateUnsuccessfulLoginAttempts(String username, boolean reset);
	public int updateUserAccountStatus(String username, boolean status);
	
}
