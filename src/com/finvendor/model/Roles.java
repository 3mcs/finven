/**
 * 
 */
package com.finvendor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rayulu vemula
 *
 */
@Entity
@Table(name="roles")
public class Roles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="role_id")
    @GeneratedValue
    private Integer id;
	
	@Column(name="rolename")
	private String roleName;
   
	@OneToMany(fetch=FetchType.LAZY,mappedBy="roles")
	private Set<UserRole> userRoles=new HashSet<UserRole>();
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

}
