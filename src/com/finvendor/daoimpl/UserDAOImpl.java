/**
 * 
 */
package com.finvendor.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.finvendor.dao.UserDAO;
import com.finvendor.model.UserRole;
import com.finvendor.model.Users;

/**
 * @author rayulu vemula
 *
 */
public class UserDAOImpl implements UserDAO{

	
	private static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	public static final int REGISTRATION_LINK_EXPIRY = 48;
	
	private static final String SEL_USER_DETAILS_FROM_USERNAME = "SELECT username, password, enabled, last_login, login_attempts, registration_date, verified FROM users WHERE username = :username";
	private static final String UPDATE_LOGIN_UNSUCCESSFUL_ATTEMPTS = "UPDATE users SET login_attempts = login_attempts + 1, last_modified = CURRENT_TIMESTAMP() WHERE username = :username";
	private static final String RESET_LOGIN_UNSUCCESSFUL_ATTEMPTS = "UPDATE users SET login_attempts = 0, last_login = CURRENT_TIMESTAMP(), last_modified = CURRENT_TIMESTAMP() WHERE username = :username";
	private static final String UPDATE_USER_STATUS = "UPDATE users SET enabled = :enabled, last_modified = CURRENT_TIMESTAMP() WHERE username = :username";
	private static final String INSERT_USER_VERIFICATION_RECORD = "INSERT into user_verification (username, email, registration_id, created_date) values (:username, :email, :registration_id, CURRENT_TIMESTAMP())";
	private static final String DELETE_USER_VERIFICATION_RECORD = "DELETE from user_verification where username = :username";
	private static final String UPDATE_USER_VERIFICATION_DATE = "UPDATE user_verification set verified_date = CURRENT_TIMESTAMP() where registration_id = :registrationId and username = :username and TIMESTAMPDIFF(HOUR, created_date, CURRENT_TIMESTAMP()) < " + REGISTRATION_LINK_EXPIRY;
	private static final String UPDATE_USER_REGISTER_ENABLE_STATUS = "UPDATE users set enabled = :enabled, verified = 'Y' where username = :username";
	private static final String SELECT_REGISTRATION_EMAIL_FOR_USERNAME = "SELECT email from user_verification where username = :username";
	
	@Autowired
	private SessionFactory sessionFactory;

	
	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserDAOImpl#saveUserInfo(com.finvendor.model.Users)
	 */
	@Transactional
	@Override
	public void saveUserInfo(Users users) {
		logger.info("saveUserInfo method---");
		try{
			 this.sessionFactory.getCurrentSession().save(users);
			 this.sessionFactory.getCurrentSession().flush();
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("Error in saveUserInfo---- " + ex);
		}
		
	}

	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserDAOImpl#saveUserRolesInfo(com.finvendor.model.userRole)
	 */
	@Transactional
	@Override
	public void saveUserRolesInfo(UserRole userRole) {
		logger.info("saveUserRolesInfo method---");
		try{
			this.sessionFactory.getCurrentSession().save(userRole);
			this.sessionFactory.getCurrentSession().flush();
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("Error in saveUserRolesInfo---- " + ex);
		}
	}
	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserDAOImpl#validateUsername(com.finvendor.model.Users)
	 */
	@Transactional
	@Override
	public boolean validateUsername(String username) {
		logger.info("validateUsername method---");
		Users users=null; Criteria criteria=null; boolean check = false;
		try{
			criteria = this.sessionFactory.getCurrentSession().createCriteria(Users.class);
			criteria.add(Restrictions.sqlRestriction("lower(username) like '" + username.toLowerCase() + "'"));
			users = (Users) criteria.uniqueResult();
			if(users!=null){
				check = true;
			}else{
				check = false;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Error in validateUsername---- " + ex);
		}
		return check;
	}
	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserDAOImpl#getUserRoleInfobyUsername(com.finvendor.model.UserRole)
	 */
	@Transactional
	@Override
	public UserRole getUserRoleInfobyUsername(String username) {
		logger.info("getUserRoleInfobyUsername method---");
		SQLQuery sqlQuery=null; String hsql = null; 
		try{
			 hsql = "select * from user_roles where username='"+username+"' ";
	    	 sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(hsql);
		}catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Error in validateUsername---- " + ex);
		}
		return (UserRole)sqlQuery.uniqueResult();
	}
	
	/** --------------------------------------------------------------------- */
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.finvendor.dao.UserDAOImpl#getUsersInfoByNamewithPassword(com.finvendor.model.Users)
	 */
	@Transactional
	@Override
	public List<Users> getUserInfoByNamewithPassword(String username,
			String password) {
		logger.info("getUsersInfoByNamewithPassword method---");
		SQLQuery sqlQuery=null; String hsql = null; 
		List<Users>  users = new ArrayList<Users>();
		Users usersinfo= new Users();
		try{
			 hsql = "select * from users where username = :username and password = :password";
	    	 sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(hsql);
	    	 sqlQuery.setParameter("username", username);
	    	 sqlQuery.setParameter("password", password);
	    	 @SuppressWarnings("unchecked")
			List<Object[]> usersObject = sqlQuery.list();
	    	 for (int i = 0; i < usersObject.size(); i++) {
	    		 Object[] usercheck = usersObject.get(i);
	    		 String usernameval = usercheck[0].toString();
	    		 String passwordval = usercheck[1].toString();
	    		 usersinfo.setUserName(usernameval);
	    		 usersinfo.setPassword(passwordval);
	    		 users.add(usersinfo);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Error in getUsersInfoByNamewithPassword---- " + ex);
		}
		return users;
	}
	
	@Override
	public Users getUserDetailsByUsername(String username){
		logger.debug("Entering UserDAOImpl:getUserDetailsByUsername");
		SQLQuery sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(SEL_USER_DETAILS_FROM_USERNAME);
		sqlQuery.addEntity(Users.class);
		sqlQuery.setParameter("username", username);
		logger.debug("Leaving UserDAOImpl:getUserDetailsByUsername");
		return (Users)sqlQuery.uniqueResult();
		//logger.debug("Leaving UserDAOImpl:getUserDetailsByUsername");
		//return user.size() == 0  ? null : user.get(0);
	}
	
	@Override
	public int updateUnsuccessfulLoginAttempts(String username, boolean reset){
		logger.debug("Entering UserDAOImpl:updateUnsucessfulLoginAttempts");
		int updatedRows = 0;
		SQLQuery sqlQuery = null;
		if(reset){
			sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(RESET_LOGIN_UNSUCCESSFUL_ATTEMPTS);
		}else{
			sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(UPDATE_LOGIN_UNSUCCESSFUL_ATTEMPTS);
		}		
		sqlQuery.setParameter("username", username);
		updatedRows = sqlQuery.executeUpdate();
		logger.debug("Leaving UserDAOImpl:updateUnsucessfulLoginAttempts");
		return updatedRows;
	}
	
	@Override	
	public int updateUserAccountStatus(String username, boolean status){
		logger.debug("Entering UserDAOImpl:updateUserAccountStatus");
		int updatedRows = 0;
		SQLQuery sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(UPDATE_USER_STATUS);
		sqlQuery.setParameter("username", username);
		sqlQuery.setParameter("enabled", status);
		updatedRows = sqlQuery.executeUpdate();
		logger.debug("Leaving UserDAOImpl:updateUserAccountStatus");
		return updatedRows;
	}
	
	@Override
	public void insertRegistrationVerificationRecord(String username, String email, String registration_id, boolean recreate){
		logger.debug("Entering UserDAOImpl:insertRegistrationVerificationRecord {}, Recreate : ", username, recreate);
		SQLQuery sqlQuery = null;
		if(recreate){
			sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(DELETE_USER_VERIFICATION_RECORD);
			sqlQuery.setParameter("username", username);
			sqlQuery.executeUpdate();
		}
		sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(INSERT_USER_VERIFICATION_RECORD);
		sqlQuery.setParameter("username", username);
		sqlQuery.setParameter("email", email);
		sqlQuery.setParameter("registration_id", registration_id);
		sqlQuery.executeUpdate();
		logger.debug("Leaving UserDAOImpl:insertRegistrationVerificationRecord {}", username);
	}
	
	@Override
	public int updateUserVerificationStatus(String username, String registration_id){
		logger.debug("Entering UserDAOImpl:updateUserVerificationStatus {}, {}", username, registration_id);
		int updatedRows = 0;
		SQLQuery sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(UPDATE_USER_VERIFICATION_DATE);
		sqlQuery.setParameter("registrationId", registration_id);
		sqlQuery.setParameter("username", username);
		updatedRows = sqlQuery.executeUpdate();
		logger.debug("UserDAOImpl:updateUserVerificationStatus {}, Rows updated : {}", username, updatedRows);
		if(updatedRows == 1){
			sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(UPDATE_USER_REGISTER_ENABLE_STATUS);
			sqlQuery.setParameter("username", username);
			sqlQuery.setParameter("enabled", true);
			sqlQuery.executeUpdate();
		}
		logger.debug("Leaving UserDAOImpl:updateUserVerificationStatus {}, {}", username, registration_id);
		return updatedRows;
	}
	
	@Override
	public String getRegistrationEmailForUsername(String username) {
		logger.debug("Entering UserDAOImpl:getRegistrationEmailForUsername {}", username);
		SQLQuery sqlQuery = null; 
		try{
			 sqlQuery = this.sessionFactory.getCurrentSession().createSQLQuery(SELECT_REGISTRATION_EMAIL_FOR_USERNAME);
			 sqlQuery.setParameter("username", username);
			 logger.debug("Leaving UserDAOImpl:getRegistrationEmailForUsername {}", username);
			 return (String)sqlQuery.uniqueResult();
		}catch (Exception exp) {
			logger.error("Error getRegistrationEmailForUsername" + exp);
			return null;
		}
	}	
}
