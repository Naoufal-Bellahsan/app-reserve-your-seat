package com.app.rys.enums;

/**
 * Enum del estado de asiento
 * 
 * @author Naoufal
 *
 */
public enum SeatState {
	DISPONIBLE("D") ,NO_DISPONIBLE("ND");
	
	private String seatState;

	SeatState(String seatState) {
		this.seatState=seatState;
	}

	public String getState() {
		return seatState;
	}
	
}
