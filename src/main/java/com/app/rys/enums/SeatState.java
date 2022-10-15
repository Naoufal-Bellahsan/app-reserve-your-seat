package com.app.rys.enums;

/**
 * Enum del estado de asiento
 * 
 * @author Naoufal
 *
 */
public enum SeatState {
	DISPONIBLE("D") ,NO_DISPONIBLE("ND");
	
	private String seatSstate;

	SeatState(String seatSstate) {
		this.seatSstate=seatSstate;
	}

	public String getState() {
		return seatSstate;
	}
	
}
