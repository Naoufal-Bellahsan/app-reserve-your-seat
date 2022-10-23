package com.app.rys.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entidad Edificio
 * 
 * @author Naoufal
 *
 */
@Entity
public class Building {

	// propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String adrress;

	private String city;
	
	// Un edifico puede tener muchas plantas @OneToMany 
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Floor> floors;
	
	// Constructores
	public Building(Long id, String adrress, String city) {
		this.id = id;
		this.adrress = adrress;
		this.city = city;
	}

	public Building() {

	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdrress() {
		return adrress;
	}

	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	// hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(adrress, city, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Building other = (Building) obj;
		return Objects.equals(adrress, other.adrress) && Objects.equals(city, other.city)
				&& Objects.equals(id, other.id);
	}

	// toString
	@Override
	public String toString() {
		return String.format("Building [id=%s, adrress=%s, city=%s]", id, adrress, city);
	}

}
