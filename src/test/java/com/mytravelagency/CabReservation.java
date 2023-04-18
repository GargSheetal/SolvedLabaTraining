/**
 * 
 */
package com.mytravelagency;

import java.util.Date;

/**
 * @author sheetal
 *
 */
public class CabReservation extends Reservation {

	protected Date pickupTime;
	protected Date dropoffTime;
	
	
	public CabReservation(Date pickupTime, Date dropoffTime, double price) {
		super(price);
		this.pickupTime = pickupTime;
		this.dropoffTime = dropoffTime;
	}
	
	@Override
	public void confirmReservation() {
		System.out.println("Cab is Booked");
		
	}
	@Override
	public void cancelReservation() {
		System.out.println("Cab is Cancelled");
		
	}
	
	
	
	

}
