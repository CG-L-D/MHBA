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
<<<<<<< Updated upstream
import javax.persistence.JoinColumn;
=======
import javax.validation.constraints.NotNull;
>>>>>>> Stashed changes

@Entity
@Table(name = "Vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id", nullable = false)
	private int vendorId;
<<<<<<< Updated upstream

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "vendorContact")
	private String vendorContact;

	@OneToMany(targetEntity = VendorOffers.class, cascade = CascadeType.ALL)
	// @JoinColumn(name = "vendorOfferId", referencedColumnName = "vendorId")
	private List<VendorOffers> vendorOffers = new ArrayList<VendorOffers>();

=======
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name="vendorContact")
	private int vendorContact;
	
>>>>>>> Stashed changes
	public Vendor() {
		super();
	}

<<<<<<< Updated upstream
	public Vendor(int vendorId, String firstName, String lastName, String vendorContact,
			List<VendorOffers> vendorOffers) {
=======
	public Vendor(int vendorId, String firstName, String lastName, int vendorContact) {
>>>>>>> Stashed changes
		super();
		this.vendorId = vendorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vendorContact = vendorContact;
		this.vendorOffers = vendorOffers;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

<<<<<<< Updated upstream
	public List<VendorOffers> getVendorOffers() {
		return vendorOffers;
	}

	public void setVendorOffers() {
		this.vendorOffers = vendorOffers;
	}

=======
>>>>>>> Stashed changes
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
<<<<<<< Updated upstream
	}

	public String getLastName() {
		return lastName;
	}

=======
	}

	public String getLastName() {
		return lastName;
	}

>>>>>>> Stashed changes
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", firstName=" + firstName + ", lastName=" + lastName
<<<<<<< Updated upstream
				+ ", vendorContact=" + vendorContact + ", vendorOffers=" + vendorOffers + "]";
	}
	/*
	 * public double getVendorCost(Map<String,Double> vendorServicesAvailable) {
	 * 
	 * double totalCost=0;
	 * 
	 * for (String key: vendorServicesAvailable.keySet())
	 * totalCost += vendorServicesAvailable.get(key);
	 * 
	 * 
	 * return totalCost;
	 * 
	 * }
	 */
=======
				+ ", vendorContact=" + vendorContact + "]";
	}

	
	
>>>>>>> Stashed changes

}
