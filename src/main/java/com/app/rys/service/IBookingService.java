package com.app.rys.service;

import java.util.List;

import com.app.rys.models.Booking;
import com.app.rys.models.Seat;

/**
 * Servicio de reservación
 * 
 * @author Naoufal
 *
 */
public interface IBookingService {
	
	/**
	 * Método para crear una reserva
	 * 
	 * @return
	 */
	public Booking createReservation(Seat seat);
	
	/**
	 * Método para eliminar una reserva
	 * 
	 * @return
	 */
	public Booking deletReservation(Long id);
	
	/**
	 * Método para devolver las reservas
	 * 
	 * @return
	 */
	public List<Booking> getReservation();
}
