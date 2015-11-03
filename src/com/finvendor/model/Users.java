/**
 * 
 */
package com.finvendor.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author rayulu vemula
 *
 */
@Entity
@Table(name="users")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERNAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ENABLED")
	private Boolean enabled;
	
	@Column(name="LOGIN_ATTEMPTS")
	private short login_attempts;
		
	@Column(name="LAST_LOGIN")
	private Timestamp last_login;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="users")
	private Set<UserRole> userRoles=new HashSet<UserRole>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="users")
	private Set<Vendor> vendor=new HashSet<Vendor>();
	 
 
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the userRoles
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * @return the vendor
	 */
	public Set<Vendor> getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Set<Vendor> vendor) {
		this.vendor = vendor;
	}

	public short getLogin_attempts() {
		return login_attempts;
	}

	public void setLogin_attempts(short login_attempts) {
		this.login_attempts = login_attempts;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

}

