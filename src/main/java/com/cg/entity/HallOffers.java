package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hallFeatures")
public class HallOffers {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name = "hall_id")
    @Column(name = "hallOfferId")
    private int id;

    @Column(name = "serviceType")
    private String serviceType;

    @Column(name = "serviceDetails")
    private String serviceDetails;
	
    @Column(name = "available")
    private boolean isAvailable;
    
    public HallOffers() {
    	super();
    }

	public HallOffers(int id, String serviceType, String serviceDetails, boolean isAvailable) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.serviceDetails = serviceDetails;
		this.isAvailable = isAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "HallOffers [id=" + id + ", serviceType=" + serviceType + ", serviceDetails=" + serviceDetails
				+ ", isAvailable=" + isAvailable + "]";
	}
    
	
}
