package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
<<<<<<< Updated upstream
=======
import javax.persistence.GenerationType;
>>>>>>> Stashed changes
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

@Entity
@Table(name="Vendor_Offers")
public class VendorOffers {
	
	@Id
<<<<<<< Updated upstream
=======
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "vendorOffer_id")
	private int id;
	
	@Column
>>>>>>> Stashed changes
	private String serviceType;
	
	@Column
	private double serviceCost;

	public VendorOffers() {
		super();
	}
	
	public VendorOffers(String serviceType, double serviceCost) {
		super();
		this.serviceType = serviceType;
		this.serviceCost = serviceCost;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	@Override
	public String toString() {
		return "VendorOffers [serviceType=" + serviceType + ", serviceCost=" + serviceCost + "]";
	}
	
	

}
