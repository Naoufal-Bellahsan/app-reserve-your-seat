package com.app.rys.utility;

/**
 * Utilidades
 * 
 * @author Naoufal
 *
 */
public class UtilityRYS {
	
	/**
	 * Método para generar automáticamente el código de reserva
	 * 
	 * @param reservationCounter
	 * @return
	 */
	public static String generateBookingCode(Long reservationCounter) {
		StringBuilder bookingCode = new StringBuilder();
		bookingCode.append("R-" + (reservationCounter+1));
		return bookingCode.toString();
	}
}
