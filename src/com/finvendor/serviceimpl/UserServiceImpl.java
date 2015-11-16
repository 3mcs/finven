/**
 * 
 */
package com.finvendor.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.finvendor.dao.UserDAO;
import com.finvendor.model.UserRole;
import com.finvendor.model.Users;
import com.finvendor.service.UserService;

/**
 * @author rayulu vemula
 *
 */
public class UserServiceImpl implements UserService{
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserServiceImpl#saveUserInfo(com.finvendor.model.Users)
	 */
	@Override
	public void saveUserInfo(Users users) {
		logger.info("saveUserInfo Method....");
		 userDAO.saveUserInfo(users);
	}

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserServiceImpl#saveUserRolesInfo(com.finvendor.model.UserRole)
	 */
	@Override
	public void saveUserRolesInfo(UserRole userRole) {
			logger.info("saveUserRolesInfo Method....");
			userDAO.saveUserRolesInfo(userRole);	
	}

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserServiceImpl#validateUsername(com.finvendor.model.Users)
	 */
	@Override
	public boolean validateUsername(String username) {
		logger.info("validateUsername Method....");
		return userDAO.validateUsername(username);
	}

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserServiceImpl#getUserRoleInfobyUsername(com.finvendor.model.UserRole)
	 */
	@Override
	public UserRole getUserRoleInfobyUsername(String username) {
		logger.info("getUserRoleInfobyUsername Method....");
		return userDAO.getUserRoleInfobyUsername(username);
	}

	

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserServiceImpl#getUsersInfoByNamewithPassword(com.finvendor.model.Users)
	 */
	@Override
	public List<Users> getUserInfoByNamewithPassword(String username,
			String password) {
		logger.info("getUsersInfoByNamewithPassword Method....");
		return userDAO.getUserInfoByNamewithPassword(username,password);
	}
	
	@Override
	@Transactional
	public Users getUserDetailsByUsername(String username){
		logger.debug("Entering : UserServiceImpl.getUserDetailsByUsername");
		Users user = userDAO.getUserDetailsByUsername(username);
		logger.debug("Leaving : UserServiceImpl.getUserDetailsByUsername");
		return user;
	}
	
	@Override
	@Transactional
	public int updateUnsuccessfulLoginAttempts(String username, boolean reset){
		return userDAO.updateUnsuccessfulLoginAttempts(username, reset);
	}
	
	@Override
	@Transactional
	public int updateUserAccountStatus(String username, boolean status){
		return userDAO.updateUserAccountStatus(username, status);
	}
	
	@Override
	@Transactional
	public String insertRegistrationVerificationRecord(String username, String email, boolean recreate){
		String registration_id = UUID.randomUUID().toString();
		userDAO.insertRegistrationVerificationRecord(username, email, registration_id, recreate);
		return registration_id;
	}
	
	@Override
	@Transactional
	public boolean updateUserVerificationStatus(String userName, String registrationId){
		int updatedRows = userDAO.updateUserVerificationStatus(userName, registrationId);
		if(updatedRows == 0) {
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	@Transactional
	public String getRegistrationEmailForUsername(String username){
		return userDAO.getRegistrationEmailForUsername(username);
	}
	
}
