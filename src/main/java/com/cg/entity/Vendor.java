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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendorId", nullable = false)
	private int vendorId;

	@Column(name = "firstName")
	private String vendorFirstName;

	@Column(name = "lastName")
	private String vendorLastName;

	@Column(name = "vendorContact")
	private String vendorContact;

	@Column(name = "flowerVendor")
	private boolean flower;

	@Column(name = "musicVendor")
	private boolean music;

	@Column(name = "cateringVendor")
	private boolean catering;

	@Column(name = "videoVendor")
	private boolean video;

	@Column(name = "status")
	private boolean isVendorAvailable;
	/*
	 * "vendorCost")
	 * private double vendorCost;
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	private Hall hall;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	private Date bookVendorFrom;

	private Date bookVendorTo;

	public Vendor() {
		super();
	}

	public Vendor(int vendorId, String vendorFirstName, String vendorLastName, String vendorContact, boolean flower,
			boolean music,
			boolean catering, boolean video, boolean isVendorAvailable) {
		super();
		this.vendorId = vendorId;
		this.vendorFirstName = vendorFirstName;
		this.vendorLastName = vendorLastName;
		this.vendorContact = vendorContact;
		this.flower = flower;
		this.music = music;
		this.catering = catering;
		this.video = video;
		this.isVendorAvailable = isVendorAvailable;

	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorFirstName() {
		return vendorFirstName;
	}

	public void setVendorFirstName(String firstName) {
		this.vendorFirstName = firstName;
	}

	public String getVendorLastName() {
		return vendorLastName;
	}

	public void setVendorLastName(String lastName) {
		this.vendorLastName = lastName;
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

	public boolean getIsVendorAvailable() {
		return isVendorAvailable;
	}

	public void setIsVendorAvailable(boolean isVendorAvailable) {
		this.isVendorAvailable = isVendorAvailable;
	}

	public double getVendorCost() {

		double vendorCost = 0;

		if (flower)
			vendorCost += 3000;
		if (music)
			vendorCost += 4000;
		if (catering)
			vendorCost += 10000;
		if (video)
			vendorCost += 6000;

		return vendorCost;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Date getBookVendorFrom() {
		return bookVendorFrom;
	}

	public void setBookVendorFrom(Date bookVendorFrom) {
		this.bookVendorFrom = bookVendorFrom;
	}

	public Date getBookVendorTo() {
		return bookVendorTo;
	}

	public void setBookVendorTo(Date bookVendorTo) {
		this.bookVendorTo = bookVendorTo;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorFirstName=" + vendorFirstName + ", vendorLastName="
				+ vendorLastName + ", vendorContact=" + vendorContact + ", flower=" + flower + ", music=" + music
				+ ", catering=" + catering + ", video=" + video + ", isVendorAvailable=" + isVendorAvailable
				+ ", hall=" + hall + ", admin=" + admin + ", bookVendorFrom="
				+ bookVendorFrom + ", bookVendorTo=" + bookVendorTo + "]";
	}

}
