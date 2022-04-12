package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "vendor_id")
	private int vendorId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name="vendorContact")
	private int vendorContact;
	
	public Vendor() {
		super();
	}

	public Vendor(int vendorId, String firstName, String lastName, int vendorContact) {
		super();
		this.vendorId = vendorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vendorContact = vendorContact;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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

	public int getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(int vendorContact) {
		this.vendorContact = vendorContact;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", vendorContact=" + vendorContact + "]";
	}

	
	

}
