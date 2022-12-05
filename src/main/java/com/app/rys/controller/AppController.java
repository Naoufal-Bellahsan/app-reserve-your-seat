package com.app.rys.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rys.models.Booking;
import com.app.rys.models.Seat;
import com.app.rys.service.IBookingService;

@RestController
@RequestMapping("/api/reservation")
public class AppController {

	@Autowired
	private IBookingService bookingService;

	@PostMapping("/reserve/")
	public ResponseEntity<Booking> createReservation(@RequestBody Seat seat) {
		Booking booking = bookingService.createReservation(seat);
		if(booking != null) {
			return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Booking> deleteReservation(@PathVariable(value = "id") Long id) {
		Booking booking = bookingService.deletReservation(id);
		return new ResponseEntity<Booking>(booking, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Booking>> getReservations() {
		List<Booking> reservations = bookingService.getReservation();
		return new ResponseEntity<List<Booking>>(reservations, HttpStatus.OK);
	}
}
