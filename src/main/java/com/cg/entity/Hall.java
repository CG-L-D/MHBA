package com.cg.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hall_id;

	@Column(name = "hallName")
	private String hallName;

	@Min(value = 5)
	@Column(name = "noOfRooms")
	private int noOfRooms;

	@Min(value = 100)
	@Column(name = "capacity")
	private long capacity;

	@Column(name = "location")
	private String location;

	@Column(name = "city")
	private String city;

	@Min(value = 5000)
	@Column(name = "price")
	private double price;

	@Column(name = "bookedFrom")
	private Date bookedFrom;

	@Column(name = "bookedTo")
	private Date bookedTo;

	@Column(name = "bookingStatus")
	private boolean bookingStatus = false;

	@OneToOne
	private Vendor vendor;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<HallOffers> hallOffers;

	public Hall() {
		super();
	}

	public Hall(int hall_id, String hallName, @Min(5) int noOfRooms, @Min(100) long capacity, String location,
			String city, @Min(5000) double price, Date bookedFrom, Date bookedTo, boolean bookingStatus, Vendor vendor,
			List<HallOffers> hallOffers) {
		super();
		this.hall_id = hall_id;
		this.hallName = hallName;
		this.noOfRooms = noOfRooms;
		this.capacity = capacity;
		this.location = location;
		this.city = city;
		this.price = price;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.bookingStatus = bookingStatus;
		this.vendor = vendor;
		this.hallOffers = hallOffers;
	}

	public int getHall_id() {
		return hall_id;
	}

	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<HallOffers> getHallOffers() {
		return hallOffers;
	}

	public void setHallOffers(List<HallOffers> hallOffers) {
		this.hallOffers = hallOffers;
	}

	@Override
	public String toString() {
		return "Hall [hall_id=" + hall_id + ", hallName=" + hallName + ", noOfRooms=" + noOfRooms + ", capacity="
				+ capacity + ", location=" + location + ", city=" + city + ", price=" + price + ", bookedFrom="
				+ bookedFrom + ", bookedTo=" + bookedTo + ", bookingStatus=" + bookingStatus + ", vendor=" + vendor
				+ ", hallOffers=" + hallOffers + "]";
	}

}
