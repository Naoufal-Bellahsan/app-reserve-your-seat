package com.app.rys.controller;


public class BookingPostBody {
	
	private String seatNumber;
	private String address;
	private String floorNumber;
	private String city;
	private String reservationDate;

	public BookingPostBody(String seatNumber, String address, String floorNumber, String city, String reservationDate) {
		super();
		this.seatNumber = seatNumber;
		this.address = address;
		this.floorNumber = floorNumber;
		this.city = city;
		this.reservationDate = reservationDate;
	}

	public BookingPostBody() {
		super();
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	

}
