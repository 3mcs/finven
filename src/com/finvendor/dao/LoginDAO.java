/**
 * 
 */
package com.finvendor.dao;

import com.finvendor.model.Users;

/**
 * @author rayulu vemula
 *
 */
public interface LoginDAO {

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc) Method to get users info by emailId
	 * 
	 * @return Object with success or failure messages
	 * @see com.finvendor.dao.LoginDAO#getUserInfoByEmail()
	 */
	Users getUserInfoByEmail(String email);
 

}
