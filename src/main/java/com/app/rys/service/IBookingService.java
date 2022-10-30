package com.app.rys.service;

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
	public void createReservation(Seat seat);
	
	/**
	 * Método para eliminar una reserva
	 * 
	 * @return
	 */
	public Booking deletReservation(Booking booking);
}
