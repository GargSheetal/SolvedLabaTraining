/**
 * 
 */
package com.mytravelagency;

import java.util.Date;

/**
 * @author sheetal
 *
 */
public class TrainReservation extends Reservation {

	private String trainNumber;
	private String originStation;
	private String destinationStation;
	private Date departureTimestamp;
	private Date arrivalTimestamp;
	private String reservationClass;
	private boolean includeMeals;

	public TrainReservation(String trainNumber, String originStation, String destinationStation,
			Date departureTimestamp, Date arrivalTimestamp, String reservationClass, double price) {
		super(price);
		this.trainNumber = trainNumber;
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.departureTimestamp = departureTimestamp;
		this.arrivalTimestamp = arrivalTimestamp;
		this.reservationClass = reservationClass;
	}

	
	public boolean getIncludeMeals() {
		return includeMeals;
	}

	public void setIncludeMeals(boolean includeMeals) {
		this.includeMeals = includeMeals;
	}
	
	@Override
	public void confirmReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelReservation() {
		// TODO Auto-generated method stub
		
	}

}
