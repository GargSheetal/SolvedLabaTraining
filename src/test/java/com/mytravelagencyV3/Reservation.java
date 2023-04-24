package com.mytravelagencyV3;

import java.util.UUID;

/**
 * @author sheetal
 *
 */

public abstract class Reservation implements IReservation {
	
	private final String reservationId;
	protected Customer customer = new Customer();
	
	protected Reservation() {
		UUID uuid = UUID.randomUUID();
		this.reservationId = uuid.toString();
	}

	protected String getReservationId() {
		return reservationId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public abstract void confirmReservation();
	public abstract void cancelReservation();
	public abstract String toString();
	
}
