package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private long id;
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@UniqueElements
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "password")
	private String password;

	@OneToMany
	private Supervisor supervisor;
	
	@OneToMany
	private Vendor vendor;
	
	public Admin() {}

	public Admin(@NotNull String firstName, @NotNull String lastName, @NotNull @UniqueElements String email,
			String mobileNumber, String password, Supervisor supervisor, Vendor vendor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.supervisor = supervisor;
		this.vendor = vendor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Admin [Id=" + id + ", First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + email
				+ ", Mobile_Number=" + mobileNumber + ", Password=" + password + ", Supervisor=" + supervisor
				+ ", Vendor=" + vendor + "]";
	}
	
}
