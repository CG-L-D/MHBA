package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hall_id;
	
	@Column(name = "hallName")
	private String hallName;
	
	@Column(name = "noOfRooms")
	private int noOfRooms;
	
	@Column(name = "capacity")
	private long capacity;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "price")
	private double price;
	
	private boolean bookingStatus = false;

	public Hall() {}
	
	public Hall(int hall_id, String hallName, int noOfRooms, long capacity, String location, String city,
			double price) {
		super();
		this.hall_id = hall_id;
		this.hallName = hallName;
		this.noOfRooms = noOfRooms;
		this.capacity = capacity;
		this.location = location;
		this.city = city;
		this.price = price;
//		this.dateOfBooking=dateOfBooking;
	}

	public int getHall_id() {return hall_id;}

	public void setHall_id(int hall_id) {this.hall_id = hall_id;}

	public String getHallName() {return hallName;}

	public void setHallName(String hallName) {this.hallName = hallName;	}

	public int getNoOfRooms() {	return noOfRooms;}

	public void setNoOfRooms(int noOfRooms) {this.noOfRooms = noOfRooms;}

	public long getCapacity() {	return capacity;}

	public void setCapacity(long capacity) {this.capacity = capacity;}

	public String getLocation() {return location;}

	public void setLocation(String location) { this.location = location;}

	public String getCity() { return city;}

	public void setCity(String city) { this.city = city;}

	public double getPrice() { return price;}

	public void setPrice(double price) { this.price = price;}
	
	public void setBookingStatus(boolean b) { this.bookingStatus = b ;}

//	public Date getDateOfBooking() {return dateOfBooking;}
//
//	public void setDateOfBooking(Date dateOfBooking) {this.dateOfBooking = dateOfBooking;}

	@Override
	public String toString() {
		return "Hall [hall_id=" + hall_id + ", hallName=" + hallName + ", noOfRooms=" + noOfRooms + ", capacity="
				+ capacity + ", location=" + location + ", city=" + city + ", price=" + price + "]";
	}
	
	
	

}
