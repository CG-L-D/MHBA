package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id", nullable = false)
	private int vendorId;
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "vendorContact")
	private String vendorContact;

	@Column(name="flowerVendor")
	private boolean flower;
	
	@Column(name="musicVendor")
	private boolean music;
	
	@Column(name="cateringVendor")
	private boolean catering;
	
	@Column(name="videoVendor")
	private boolean video;
	
	@Column(name="status")
	private boolean isAvailable;
	
	@Column(name="vendorCost")
	private double vendorCost;	
	
	public Vendor() {
		super();
	}

	public Vendor(int vendorId, String firstName, String lastName, String vendorContact, boolean flower, boolean music,
			boolean catering, boolean video, boolean isAvailable, double vendorCost) {
		super();
		this.vendorId = vendorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vendorContact = vendorContact;
		this.flower = flower;
		this.music = music;
		this.catering = catering;
		this.video = video;
		this.isAvailable = isAvailable;
		this.vendorCost = vendorCost;
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

	public String getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}

	public boolean isFlower() {
		return flower;
	}

	public void setFlower(boolean flower) {
		this.flower = flower;
	}

	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
	}

	public boolean isCatering() {
		return catering;
	}

	public void setCatering(boolean catering) {
		this.catering = catering;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getVendorCost() {
		return vendorCost;
	}

	public void setVendorCost(double vendorCost) {
		this.vendorCost = vendorCost;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", vendorContact=" + vendorContact + ", flower=" + flower + ", music=" + music + ", catering="
				+ catering + ", video=" + video + ", isAvailable=" + isAvailable + ", vendorCost=" + vendorCost + "]";
	}


	
	
}
