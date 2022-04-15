package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adminId")
	private int adminId;
	
	@NotNull
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name = "adminContact")
	private String adminContact;
	
	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Supervisor> supervisors;
	
	@OneToMany(cascade = CascadeType.ALL)
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
		super();
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

	public void setadminContact(String adminContact) {
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
		return "Admin [First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + email
				+ ", Contact_Number=" + adminContact + ", Password=" + password + "]";
	}
	
}
