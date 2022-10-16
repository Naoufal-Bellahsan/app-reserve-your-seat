package com.app.rys.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

/**
 * Entidad reserva
 * 
 * @author Oleksandr
 */
public class Booking {

	// propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Pattern(message = "Booking code not valid", regexp = "^[a-z]{1}-[0-9]")
	private String bookingCode;

	@Temporal(TemporalType.TIMESTAMP) // Fecha y hora
	private Date ReservationDate;

	private String bookingState;

	// Constructores: vacio y con campos
	public Booking(Long id, @Pattern(message = "Booking code not valid", regexp = "^[a-z]{1}-[0-9]") String bookingCode,
			Date reservationDate, String bookingState) {
		super();
		this.id = id;
		this.bookingCode = bookingCode;
		ReservationDate = reservationDate;
		this.bookingState = bookingState;
	}

	public Booking() {

	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public Date getReservationDate() {
		return ReservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		ReservationDate = reservationDate;
	}

	public String getBookingState() {
		return bookingState;
	}

	public void setBookingState(String bookingState) {
		this.bookingState = bookingState;
	}

	// equals & hashcode
	@Override
	public int hashCode() {
		return Objects.hash(ReservationDate, bookingCode, bookingState, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(ReservationDate, other.ReservationDate) && Objects.equals(bookingCode, other.bookingCode)
				&& Objects.equals(bookingState, other.bookingState) && Objects.equals(id, other.id);
	}

	// toString
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingCode=" + bookingCode + ", ReservationDate=" + ReservationDate
				+ ", bookingState=" + bookingState + "]";
	}

}
