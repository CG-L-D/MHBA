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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@NotBlank
	@Column(name = "customerName")
	private String customerName;

	@Column(name = "customerEmail")
	private String customerEmail;

	@Column(name = "customerPassword")
	private String customerPassword;

	@NotBlank
	@Column(name = "customerContact")
	private String customerContact;

	private Date bookHallFrom;

	private Date bookHallTo;

	private double customerBill;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customers_halls", joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId"), inverseJoinColumns = @JoinColumn(name = "hallId", referencedColumnName = "hallId"))
	private List<Hall> halls;

	public Customer() {

	}

	public Customer(int customerId, String customerName, String customerEmail, String customerPassword,
			String customerContact) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;

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

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
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

	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public double getCustomerBill() {
		return customerBill;
	}

	public void setCustomerBill(double customerBill) {
		this.customerBill = customerBill;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerContact=" + customerContact
				+ ", bookHallFrom=" + bookHallFrom + ", bookHallTo=" + bookHallTo + ", customerBill=" + customerBill
				+ ", halls=" + halls + "]";
	}

}
