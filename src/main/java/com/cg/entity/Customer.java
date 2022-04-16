package com.cg.entity;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
   
  
   @Column(name="customerEmail")
   private String customerEmail;
   
   @NotBlank
   @Column(name="contactNumber")
   private String contactNumber;
   
   private Date bookHallFrom;
   
   private Date bookHallTo;
   
   @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	  @JoinTable(name = "customers_halls", joinColumns = 
	  @JoinColumn(name = "customerId", referencedColumnName = "customerId"),
	  inverseJoinColumns = @JoinColumn(name = "hallId", referencedColumnName = "hall_id"))
   private List<Hall> halls;
   
   public Customer() {
	   
   }

	public Customer(int customerId,String customerName, String customerEmail, String contactNumber) {
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



	public Date getBookHallFrom() {
		return bookHallFrom;
	}



	public void setBookHallFrom(Date bookHallFrom) {
		this.bookHallFrom = bookHallFrom;
	}



	public Date getBookHallTo() {
		return bookHallTo;
	}



	public void setBookHallTo(Date bookHallTo) {
		this.bookHallTo = bookHallTo;
	}



	public List<Hall> getHall() {
		return halls;
	}



	public void setHall(List<Hall> hall) {
		this.halls = halls	;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", contactNumber=" + contactNumber + "]";
	}
	
}
