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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

//Admin class
@Entity
public class Admin {
	
	//Properties
	@Id
	@Column(name = "adminId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	@Column(name = "firstName", nullable = false)
	@Pattern(regexp = "^[A-Za-z]+$", message="First name is invalid, must contain alphabets only.")
	private String adminFirstName;
	
	@Column(name = "lastName", nullable = false)
	@Pattern(regexp = "^[A-Za-z]+$", message="Last name is invalid, must contain alphabets only.")
	private String adminLastName;
	
	@Column(name = "age", nullable = false)
//	@Min(value = 20, message= "Age is too low.")
//	@Max(value = 80, message = "Age limit exceeded.")
	private int adminAge;
	
	@Email
	@Size(min = 3, max = 30, message = "Email must be between 3 to 30 characters.")
	@Column(name = "email", nullable = false)
	private String adminEmail;
	
	@Pattern(regexp = "[0-9]{10}", message="Contact number is not valid, must be of 10 digit numeric value.")
	@Column(name = "adminContact")
	private String adminContact;
	
	@Pattern(regexp = "[A-Za-z0-9!@#$%&*]+{8,30}", message="Password does not match the policy.")
	@Column(name = "password")
	private String adminPassword;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminId")
	private List<Supervisor> supervisors;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId")
	private List<Vendor> vendors;
	
	//Default Constructor
	public Admin() {}

	
	//Parameterized Constructor
	public Admin(int adminId, @NotNull String firstName, @NotNull String lastName, @NotNull String email,
			String adminContact, String password) {
		super();
		this.adminId = adminId;
		this.adminFirstName = firstName;
		this.adminLastName = lastName;
		this.adminEmail = email;
		this.adminContact = adminContact;
		this.adminPassword = password;
	}
	
	//Parameterized Overloaded Constructor
	public Admin(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			String adminContact, String password) {
		this.adminFirstName = firstName;
		this.adminLastName = lastName;
		this.adminEmail = email;
		this.adminContact = adminContact;
		this.adminPassword = password;
	}

	
	//Getters and setters
	public long getAdminId() {
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


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminFirstName=" + adminFirstName + ", adminLastName=" + adminLastName
				+ ", adminAge=" + adminAge + ", adminEmail=" + adminEmail + ", adminContact=" + adminContact
				+ ", adminPassword=" + adminPassword + ", supervisors=" + supervisors + ", vendors=" + vendors + "]";
	}

}
