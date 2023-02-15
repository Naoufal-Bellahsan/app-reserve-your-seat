package com.app.rys.service;

import java.util.List;

import com.app.rys.models.Seat;

/**
 * Servicio de obtener puestos
 * 
 * @author Naoufal
 *
 */
public interface ISeatService {
	
	/**
	 * Método para obtener puestos
	 * 
	 * @return
	 */
	public List<Seat> getSeats(String city, String adrress, String floorNumber);
	public double getOccupancy(String floorNumber, String address, String city);

}
