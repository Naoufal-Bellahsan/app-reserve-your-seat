package com.app.rys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.rys.enums.SeatState;
import com.app.rys.models.Building;
import com.app.rys.models.Floor;
import com.app.rys.models.Seat;
import com.app.rys.models.User;
import com.app.rys.repository.BuildingRepository;
import com.app.rys.repository.FloorRepository;
import com.app.rys.repository.SeatRepository;
import com.app.rys.repository.UserRepository;

@SpringBootApplication
public class RysApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private FloorRepository floorRepository;
	
	@Autowired 
	private SeatRepository seatRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RysApplication.class, args);
	}
	
	// ejecucion del codigo despues de la creacion del bean
	@PostConstruct
	public void initDB() {
		
		// usuario
		User user = new User();
		user.setFullName("admin");
		user.setEmail("user.admin@gmail.com");
		user.setPhone("985858565");
		user.setPassword("admin");
		user.setUserCode("U-1");
		
		Building building = new Building();
		Floor floor1 = new Floor();
		Floor floor2 = new Floor();
		
		// asientos
		Seat seat1 = new Seat();
		seat1.setSeatNumber("1");
		seat1.setState(SeatState.DISPONIBLE.getState());
		seat1.setFloor(floor1);
		
		Seat seat2 = new Seat();
		seat2.setSeatNumber("2");
		seat2.setState(SeatState.DISPONIBLE.getState());
		seat2.setFloor(floor1);
		
		Seat seat3 = new Seat();
		seat3.setSeatNumber("1");
		seat3.setState(SeatState.DISPONIBLE.getState());
		seat3.setFloor(floor2);
		
		Seat seat4 = new Seat();
		seat4.setSeatNumber("2");
		seat4.setState(SeatState.DISPONIBLE.getState());
		seat4.setFloor(floor2);
		
		// plantas
		floor1.setFloorNumber("1");
		floor1.setBuilding(building);
		floor1.setSeats(Arrays.asList(seat1, seat2));
		
		floor2.setFloorNumber("2");
		floor2.setBuilding(building);
		floor2.setSeats(Arrays.asList(seat3, seat4));
		
		//edificio
		building.setAdrress("Calle Atocha, 42");
		building.setCity("Madrid");
		building.setFloors(Arrays.asList(floor1,floor2));
		
		userRepository.save(user);
		buildingRepository.save(building);
		//floorRepository.saveAll(Arrays.asList(floor1, floor2));
		//seatRepository.saveAll(Arrays.asList(seat1, seat2, seat3, seat4));

	}
	
}