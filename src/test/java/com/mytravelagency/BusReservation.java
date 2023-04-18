/**
 * 
 */
package com.mytravelagency;

import java.util.Date;

/**
 * @author sheetal
 *
 */
public class BusReservation extends Reservation {

	private String originLocation;
	private String destinationLocation;
	private Date travelDate;
	
	public BusReservation(String originLocation, String destinationLocation, Date travelDate, double price) {
		super(price);
		this.setOriginLocation(originLocation);
		this.setDestinationLocation(destinationLocation);
		this.setTravelDate(travelDate);
	}

	public String getOriginLocation() {
		return originLocation;
	}


	public void setOriginLocation(String originLocation) {
		this.originLocation = originLocation;
	}


	public String getDestinationLocation() {
		return destinationLocation;
	}


	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}


	public Date getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	
	@Override
	public void confirmReservation() {
		System.out.println("Bus Tickets Confirmed");
		
	}


	@Override
	public void cancelReservation() {
		System.out.println("Bus Tickets Cancelled");
		
	}

	

}
