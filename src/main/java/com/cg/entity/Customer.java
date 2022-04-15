package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customer")
public class Customer {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   
   private int customerId;
   
   @NotBlank
   @Column(name="customerName")
   private String customerName;
   
   @Email
   @Column(name="customerEmail")
   private String customerEmail;
   
   @NotBlank
   @Column(name="contactNumber")
   private String contactNumber;
   
   @OneToOne(cascade = CascadeType.ALL)
   private Hall hall;
   
   public Customer() {
	   
   }

    
	public Customer(int customerId, String customerName, String customerEmail, String contactNumber) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerEmail = customerEmail;
	this.contactNumber = contactNumber;
    }
	

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", contactNumber=" + contactNumber + "]";
	}
	
}
