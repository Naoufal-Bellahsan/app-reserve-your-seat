package com.app.rys.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
