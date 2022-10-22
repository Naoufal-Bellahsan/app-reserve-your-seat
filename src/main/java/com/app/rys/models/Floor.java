package com.app.rys.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	// una planta esta asignada a un edificio único @ManyToOne
	@ManyToOne()
	@JoinColumn(name = "building_id")
	private Building building;
	
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
	
	// una planta puede tener varios asientos @OneToMany
	@OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Seat> seats;
	
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
