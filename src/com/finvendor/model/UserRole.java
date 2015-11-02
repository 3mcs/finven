/**
 * 
 */
package com.finvendor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rayulu vemula
 *
 */
@Entity
@Table(name="user_roles")
public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@ManyToOne(targetEntity=Users.class,fetch=FetchType.LAZY)
	@JoinColumn(name="username", nullable=false)
	private Users users; 
	
	@ManyToOne(targetEntity=Roles.class,fetch=FetchType.LAZY)
	@JoinColumn(name="role_id",nullable=false) 
	private Roles roles;
	

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
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the roles
	 */
	public Roles getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	 
}
