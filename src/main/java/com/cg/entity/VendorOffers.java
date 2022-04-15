package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Vendor_Offers")
public class VendorOffers {
	
	@Column
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
