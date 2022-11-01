package com.app.rys.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	public Booking createReservation(Seat seat) {
		try {
			List<Seat> seats = seatRepository.findAll();
			Optional<Seat> oSeat = seats.stream()
					.filter(expectedSeat -> expectedSeat.getSeatNumber().equals(seat.getSeatNumber())
							&& expectedSeat.getFloor().getFloorNumber().equals(seat.getFloor().getFloorNumber()))
					.findFirst();

			if (oSeat.isPresent()) {
				Seat existedSeat = oSeat.get();
				if (existedSeat.getState().equals(SeatState.DISPONIBLE.getState())) {

					Long reservationCounter = bookingRepository.count();
					Booking booking = new Booking(UtilityRYS.generateBookingCode(reservationCounter), 
							new Date(), BookingState.PENDIENTE.getState());
					Floor floor = existedSeat.getFloor();
					Building building = floor.getBuilding();
					booking.setInformacionDeReseva(
							new StringBuilder(existedSeat.getSeatNumber() + "/" + floor.getFloorNumber() + " "
									+ building.getAdrress() + ", " + building.getCity()).toString());
					existedSeat.setState(SeatState.NO_DISPONIBLE.getState());
					List<User> users = userRepository.findAll();
					User user = users.get(0);
					booking.setUser(user);
					try {
						userRepository.save(user);
						bookingRepository.save(booking);
						seatRepository.save(existedSeat);
					} catch (Exception e){
						e.printStackTrace();
					}
					return booking;
				}
			}
		} catch (Exception e) {
			System.out.println("Seat not available");
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Booking deletReservation(Long id) {
		try {
			if (bookingRepository.existsById(id)) {
				Booking booking = bookingRepository.getReferenceById(id);
				bookingRepository.delete(booking);
				return booking;
			}
		} catch (Exception e) {
			System.out.println("Booking not available");
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public List<Booking> getReservation() {
		return bookingRepository.findAll();
	}
	
}
