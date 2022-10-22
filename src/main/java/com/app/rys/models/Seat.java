package com.app.rys.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.rys.enums.SeatState;

/**
 * Entidad Asiento
 * 
 * @author Naoufal
 *
 */
@Entity
public class Seat {

	// propiedaes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String seatNumber;

	private String state = SeatState.DISPONIBLE.getState();
	
	// un asiento esta asginado a una planta unica @ManyToOne
	@ManyToOne()
	@JoinColumn(name = "floor_id")
	private Floor floor;
	
	// Constructores
	public Seat(Long id, String seatNumber, String state) {
		this.id = id;
		this.seatNumber = seatNumber;
		this.state = state;
	}

	public Seat() {

	}

	// getters & getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(id, seatNumber, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Objects.equals(id, other.id) && Objects.equals(seatNumber, other.seatNumber)
				&& Objects.equals(state, other.state);
	}

	// toString
	@Override
	public String toString() {
		return String.format("Seat [id=%s, seatNumber=%s, state=%s]", id, seatNumber, state);
	}

}
