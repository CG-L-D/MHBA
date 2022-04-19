package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

//Admin class
@Entity
public class Admin {

	// Properties
	@Id
	@Column(name = "adminId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	@Column(name = "firstName", nullable = false)
	@Pattern(regexp = "^[A-Za-z]+$", message = "First name is invalid, must contain alphabets only.")
	private String adminFirstName;

	@Column(name = "lastName", nullable = false)
	@Pattern(regexp = "^[A-Za-z]+$", message = "Last name is invalid, must contain alphabets only.")
	private String adminLastName;

	@Column(name = "age", nullable = false)
	// @Min(value = 20, message= "Age is too low.")
	// @Max(value = 80, message = "Age limit exceeded.")
	private int adminAge;

	@Email
	@Size(min = 3, max = 30, message = "Email must be between 3 to 30 characters.")
	@Column(name = "email", nullable = false)
	private String adminEmail;

	@Pattern(regexp = "[0-9]{10}", message = "Contact number is not valid, must be of 10 digit numeric value.")
	@Column(name = "adminContact")
	private String adminContact;

	@Pattern(regexp = "[A-Za-z0-9!@#$%&*]+{8,30}", message = "Password does not match the policy.")
	@Column(name = "password")
	private String adminPassword;

	@Column(name = "adminRevenue")
	private double adminRevenue;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminId")
	@JsonIgnore
	private List<Supervisor> supervisors;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId")
	@JsonIgnore
	private List<Vendor> vendors;

	@Column(name = "active")
	private boolean active;

	// Default Constructor
	public Admin() {
	}

	// Parameterized Constructor
	public Admin(int adminId, @NotNull String firstName, @NotNull String lastName, @NotNull String email,
			String adminContact, String password, boolean active) {
		super();
		this.adminId = adminId;
		this.adminFirstName = firstName;
		this.adminLastName = lastName;
		this.adminEmail = email;
		this.adminContact = adminContact;
		this.adminPassword = password;
		this.active = active;
	}

	// Parameterized Overloaded Constructor
	public Admin(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			String adminContact, String password, boolean active) {
		this.adminFirstName = firstName;
		this.adminLastName = lastName;
		this.adminEmail = email;
		this.adminContact = adminContact;
		this.adminPassword = password;
		this.active = active;
	}

	// Getters and setters
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public double getAdminRevenue() {
		return adminRevenue;
	}

	public void setAdminRevenue(double adminRevenue) {
		this.adminRevenue = adminRevenue;
	}

	public List<Supervisor> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(List<Supervisor> supervisors) {
		this.supervisors = supervisors;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminFirstName=" + adminFirstName + ", adminLastName=" + adminLastName
				+ ", adminAge=" + adminAge + ", adminEmail=" + adminEmail + ", adminContact=" + adminContact
				+ ", adminPassword=" + adminPassword + ", adminRevenue=" + adminRevenue + ", supervisors=" + supervisors
				+ ", vendors=" + vendors
				+ ", active=" + active + "]";
	}

}
