package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vendorId;
	
	@Column(name="Vendor Name")
	private String vendorName;
	
	@Column(name="Vendor Contact")
	private int vendorContact;
	
	public Vendor() {
		super();
	}

	public Vendor(int vendorId, String vendorName, int vendorContact) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorContact = vendorContact;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(int vendorContact) {
		this.vendorContact = vendorContact;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorContact=" + vendorContact + "]";
	}
	
	

}
