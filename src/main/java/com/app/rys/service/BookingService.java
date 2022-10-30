package com.app.rys.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rys.enums.BookingState;
import com.app.rys.enums.SeatState;
import com.app.rys.models.Booking;
import com.app.rys.models.Building;
import com.app.rys.models.Floor;
import com.app.rys.models.Seat;
import com.app.rys.models.User;
import com.app.rys.repository.BookingRepository;
import com.app.rys.repository.SeatRepository;
import com.app.rys.repository.UserRepository;
import com.app.rys.utility.UtilityRYS;

/**
 * Servicio de reservación
 * 
 * @author Naoufal
 *
 */
@Service
public class BookingService implements IBookingService {

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void createReservation(Seat seat) {
		try {
			if (seat.getState().equals(SeatState.DISPONIBLE.getState())) {
				Long reservationCounter = bookingRepository.count();
				Booking booking = new Booking();
				booking.setBookingCode(UtilityRYS.generateBookingCode(reservationCounter));
				booking.setReservationDate(new Date());
				booking.setBookingState(BookingState.PENDIENTE.getState());
				Floor floor = seat.getFloor();
				Building building = floor.getBuilding();
				booking.setInformacionDeReseva(
						new StringBuilder(building.getAdrress() + ", " + building + "/" + floor + "/" + seat)
								.toString());
				seat.setState(SeatState.NO_DISPONIBLE.getState());
				List<User> users = userRepository.findAll();
				User user = users.get(0);
				user.setBookings(Arrays.asList(booking));
				userRepository.save(user);
				bookingRepository.save(booking);	
				seatRepository.save(seat);
			}
		} catch (Exception e) {
			System.out.println("Seat not available");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Booking deletReservation(Booking booking) {
		try {
			if (bookingRepository.existsById(booking.getId())) {
				bookingRepository.delete(booking);
				return booking;
			}
		} catch (Exception e) {
			System.out.println("Booking not available");
		}
		return null;
	}

}
