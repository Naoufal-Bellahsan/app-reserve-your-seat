package com.app.rys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rys.enums.SeatState;
import com.app.rys.models.Building;
import com.app.rys.models.Floor;
import com.app.rys.models.Seat;

import com.app.rys.repository.BuildingRepository;


/**
 * Servicio de obtener puestos
 * 
 * Y los puestos ocupados
 * 
 * @author Naoufal
 *
 */
@Service
public class SeatService implements ISeatService {

	@Autowired
	private BuildingRepository buildingRepository;
	

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public List<Seat> getSeats(String city, String adrress, String floorNumber) {
		try {
			Building building = buildingRepository.findByCityAndAdrress(city.toUpperCase(), adrress).get(0);// building is null cuando hago findByCityAndAdrress
			Optional<Floor> oFloor = building.getFloors().stream()
					.filter(floor -> floor.getFloorNumber().equals(floorNumber)).findAny();
			if (oFloor.isPresent()) {
				List<Seat> seats = oFloor.get().getSeats();
				return seats;
			}
			
		} catch (Exception e) {
			System.out.println("Floor not available");
		}
		return null;
	}
	
	// obtener los puesto no disponibles:
	// pasamos como parámetro el número de planta y utilice el SeatRepository para
	// buscar todas las sillas de esa planta.
	// una expresión lambda para filtrar las sillas que no están disponibles
	// (por ejemplo, las que tienen un valor de "No_Disponible" en el campo
	// "State").
	// Devolver la lista de sillas no disponibles como resultado del método.

	public double getOccupancy(String floorNumber, String address, String city) {
		List<Seat> seatsOnFloor = new ArrayList<>();
		try {
			seatsOnFloor = getSeats(city, address, floorNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (double) seatsOnFloor.stream().filter(seat -> seat.getState().equals(SeatState.NO_DISPONIBLE.getState()))
				.collect(Collectors.toList()).size() / seatsOnFloor.size() * 100;	
	}

}
