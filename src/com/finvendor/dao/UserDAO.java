/**
 * 
 */
package com.finvendor.dao;

import java.util.List;

import com.finvendor.model.UserRole;
import com.finvendor.model.Users;

/**
 * @author rayulu vemula
 *
 */
public interface UserDAO {

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc) Method to save users info
	 * 
	 * @return Integer with success or failure messages
	 * @see com.finvendor.dao.UserDAO#saveUsers()
	 */
	public void saveUserInfo(Users users);

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc) Method to save users role info
	 * 
	 * @return Integer with success or failure messages
	 * @see com.finvendor.dao.UserDAO#saveUserRolesInfo()
	 */
	public void saveUserRolesInfo(UserRole userRole);

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc) Method to validate username
	 * 
	 * @return Integer with success or failure messages
	 * @see com.finvendor.dao.UserDAO#validateUsername()
	 */
	public boolean validateUsername(String username);

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc) Method to get userrole infor by username
	 * 
	 * @return Integer with success or failure messages
	 * @see com.finvendor.dao.UserDAO#getUserRoleInfobyUsername()
	 */
	public UserRole getUserRoleInfobyUsername(String username);

	

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc) Method to get user info
	 * 
	 * @return 
	 * @see com.finvendor.dao.UserDAO#getUsersInfoByNamewithPassword()
	 */
	public List<Users> getUserInfoByNamewithPassword(String username,
			String password);

	
	
	
}
