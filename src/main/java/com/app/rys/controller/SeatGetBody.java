package com.app.rys.controller;

public class SeatGetBody {

	private String city;
	private String adrress;
	private String floorNumber;
	
	public SeatGetBody(String city, String adrress, String floorNumber) {
		super();
		this.city = city;
		this.adrress = adrress;
		this.floorNumber = floorNumber;
	}

	public SeatGetBody() {
		super();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdrress() {
		return adrress;
	}

	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	
}
