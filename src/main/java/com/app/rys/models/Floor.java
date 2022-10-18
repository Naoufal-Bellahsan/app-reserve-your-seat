package com.app.rys.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad Planta
 * 
 * @author Naoufal
 *
 */
@Entity
public class Floor {

	// propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String floorNumber;

	// Constructores
	public Floor(Long id, String floorNumber) {
		this.id = id;
		this.floorNumber = floorNumber;
	}

	public Floor() {

	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	// hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(floorNumber, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Floor other = (Floor) obj;
		return Objects.equals(floorNumber, other.floorNumber) && Objects.equals(id, other.id);
	}

	// toString
	@Override
	public String toString() {
		return String.format("Floor [id=%s, floorNumber=%s]", id, floorNumber);
	}

}
