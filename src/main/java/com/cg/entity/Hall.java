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
import javax.validation.constraints.Min;

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

	@Column(name = "housekeeping")
	private List<String> housekeeping;

	@Column(name = "dining")
	private List<String> dining;

	@Column(name = "electricalEquipment")
	private List<String> electricalEquipment;


	public Hall() {
	}

	public Hall(int hall_id, String hallName, int noOfRooms, long capacity, String location, String city,
			double price, List<String> housekeeping, List<String> dining, List<String> electricalEquipment) {
		super();
		this.hall_id = hall_id;
		this.hallName = hallName;
		this.noOfRooms = noOfRooms;
		this.capacity = capacity;
		this.location = location;
		this.city = city;
		this.price = price;
		this.housekeeping = housekeeping;
		this.dining =dining;
		this.electricalEquipment = electricalEquipment;
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

	public boolean getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public void setHousekeeping(List<String> housekeeping){
		this.housekeeping = housekeeping;
	}
	public void setDining(List<String> dining){
		this.dining = dining;
	}
	public void setElectricalEquipment(List<String> electricalEquipment){
		this.electricalEquipment = electricalEquipment;
	}
	public List<String> getHousekeeping(){
		return this.housekeeping;
	}
	public List<String> getDining(){
		return this.dining;
	}
	public List<String> getelectricalEquipment(){
		return this.electricalEquipment;
	}

	@Override
	public String toString() {
		return "Hall [hall_id=" + hall_id + ", hallName=" + hallName + ", noOfRooms=" + noOfRooms + ", capacity="
				+ capacity + ", location=" + location + ", city=" + city + ", price=" + price + ", bookedFrom="
				+ bookedFrom + ", bookedTo=" + bookedTo + ", bookingStatus=" + bookingStatus + "]";
	}

}
