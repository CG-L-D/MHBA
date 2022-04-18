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
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	@Pattern(regexp = "^[A-Za-z]+$", message="Last name is invalid, must contain alphabets only.")
	private String lastName;
	
	@Column(name = "age", nullable = false)
//	@Min(value = 20, message= "Age is too low.")
//	@Max(value = 80, message = "Age limit exceeded.")
	private int age;
	
	@Email
	@Size(min = 3, max = 30, message = "Email must be between 3 to 30 characters.")
	@Column(name = "email", nullable = false)
	private String email;
	
	@Pattern(regexp = "[0-9]{10}", message="Contact number is not valid, must be of 10 digit numeric value.")
	@Column(name = "adminContact")
	private String adminContact;
	
	@Pattern(regexp = "[A-Za-z0-9!@#$%&*]+{8,30}", message="Password does not match the policy.")
	@Column(name = "password")
	private String password;

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
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adminContact = adminContact;
		this.password = password;
	}
	
	//Parameterized Overloaded Constructor
	public Admin(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			String adminContact, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adminContact = adminContact;
		this.password = password;
	}

	
	//Getters and setters
	public long getId() {
		return adminId;
	}

	public void setId(int id) {
		this.adminId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setContact(String contact) {
		this.adminContact = contact;
	}

	public void setMobileNumber(String adminContact) {
		this.adminContact = adminContact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Admin [Id=" + adminId + ", First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + email
				+ ", Contact_Number=" + adminContact + ", Password=" + password + "]";
	}
	
}
