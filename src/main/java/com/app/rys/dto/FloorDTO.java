package com.app.rys.dto;

public class FloorDTO {

	private String floorNumber;

	private Integer ocupancy;

	// Constructores
	public FloorDTO(String floorNumber, Integer ocupancy) {
		this.floorNumber = floorNumber;
		this.ocupancy = ocupancy;
	}

	public FloorDTO() {

	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Integer getOcupancy() {
		return ocupancy;
	}

	public void setOcupancy(Integer ocupancy) {
		this.ocupancy = ocupancy;
	}

	// toString
	@Override
	public String toString() {
		return String.format("Floor [floorNumber=%s, ocupancy=%s]", floorNumber, ocupancy);
	}

}
