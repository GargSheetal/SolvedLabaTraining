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

	private Date pickupTime;
	private Date dropoffTime;
	
	
	public CabReservation(Date pickupTime, Date dropoffTime, double price) {
		super(price);
		this.setPickupTime(pickupTime);
		this.setDropoffTime(dropoffTime);
	}
	
	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(Date dropoffTime) {
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
