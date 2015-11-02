/**
 * 
 */
package com.finvendor.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rayulu vemula
 *
 */
@Entity
@Table(name="vendor")
public class Vendor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="vendor_id")
    private String id;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="email")
	private String email;
	
	@Column(name="secondary_email")
	private String secondary_email;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="company")
	private String company;
	
	@Column(name="company_url")
	private String company_url;
	
	@Column(name="companytype")
	private String companyType;
	
	@Column(name="company_info")
	private String company_info;
	
	@Column(name="tags")
	//@ElementCollection(targetClass=String.class)
	private String tags;
	
	@Column(name="companyaddress")
	private String companyAddress;
	
	@Column(name="regionofincorp")
	private Integer regionofincorp;
	
	@Column(name="countryofincorp")
	private String 	countryofincorp;
	
	 
	@ManyToOne(targetEntity=Users.class,fetch=FetchType.LAZY)
	@JoinColumn(name="username", nullable=false)
	private Users users;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vendor")
	private Set<VendorOffering> vendorOfferings=new HashSet<VendorOffering>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vendor")
	private Set<VendorRegionCountryExchangeMap> vendorRegionCountryMaps=new HashSet<VendorRegionCountryExchangeMap>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vendor")
	private Set<VendorSupport> vendorSupports=new HashSet<VendorSupport>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vendor")
	private Set<VendorAwardsMap> vendorAwardsMaps=new HashSet<VendorAwardsMap>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vendor")
	private Set<VendorDistribution> vendorDistributions=new HashSet<VendorDistribution>();
	 
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the companyType
	 */
	public String getCompanyType() {
		return companyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the countryofincorp
	 */
	public String getCountryofincorp() {
		return countryofincorp;
	}

	/**
	 * @param countryofincorp the countryofincorp to set
	 */
	public void setCountryofincorp(String countryofincorp) {
		this.countryofincorp = countryofincorp;
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the regionofincorp
	 */
	public Integer getRegionofincorp() {
		return regionofincorp;
	}

	/**
	 * @param regionofincorp the regionofincorp to set
	 */
	public void setRegionofincorp(Integer regionofincorp) {
		this.regionofincorp = regionofincorp;
	}

	/**
	 * @return the vendorOfferings
	 */
	public Set<VendorOffering> getVendorOfferings() {
		return vendorOfferings;
	}

	/**
	 * @param vendorOfferings the vendorOfferings to set
	 */
	public void setVendorOfferings(Set<VendorOffering> vendorOfferings) {
		this.vendorOfferings = vendorOfferings;
	}

	/**
	 * @return the vendorRegionCountryMaps
	 */
	public Set<VendorRegionCountryExchangeMap> getVendorRegionCountryMaps() {
		return vendorRegionCountryMaps;
	}

	/**
	 * @param vendorRegionCountryMaps the vendorRegionCountryMaps to set
	 */
	public void setVendorRegionCountryMaps(Set<VendorRegionCountryExchangeMap> vendorRegionCountryMaps) {
		this.vendorRegionCountryMaps = vendorRegionCountryMaps;
	}

	/**
	 * @return the vendorSupports
	 */
	public Set<VendorSupport> getVendorSupports() {
		return vendorSupports;
	}

	/**
	 * @param vendorSupports the vendorSupports to set
	 */
	public void setVendorSupports(Set<VendorSupport> vendorSupports) {
		this.vendorSupports = vendorSupports;
	}

	/**
	 * @return the vendorAwardsMaps
	 */
	public Set<VendorAwardsMap> getVendorAwardsMaps() {
		return vendorAwardsMaps;
	}

	/**
	 * @param vendorAwardsMaps the vendorAwardsMaps to set
	 */
	public void setVendorAwardsMaps(Set<VendorAwardsMap> vendorAwardsMaps) {
		this.vendorAwardsMaps = vendorAwardsMaps;
	}

	/**
	 * @return the vendorDistributions
	 */
	public Set<VendorDistribution> getVendorDistributions() {
		return vendorDistributions;
	}

	/**
	 * @param vendorDistributions the vendorDistributions to set
	 */
	public void setVendorDistributions(Set<VendorDistribution> vendorDistributions) {
		this.vendorDistributions = vendorDistributions;
	}

	/**
	 * @return the secondary_email
	 */
	public String getSecondary_email() {
		return secondary_email;
	}

	/**
	 * @param secondary_email the secondary_email to set
	 */
	public void setSecondary_email(String secondary_email) {
		this.secondary_email = secondary_email;
	}

	/**
	 * @return the company_url
	 */
	public String getCompany_url() {
		return company_url;
	}

	/**
	 * @param company_url the company_url to set
	 */
	public void setCompany_url(String company_url) {
		this.company_url = company_url;
	}

	/**
	 * @return the company_info
	 */
	public String getCompany_info() {
		return company_info;
	}

	/**
	 * @param company_info the company_info to set
	 */
	public void setCompany_info(String company_info) {
		this.company_info = company_info;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	 

	 

}
