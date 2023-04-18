/**
 * 
 */
package com.mytravelagency;

import java.time.LocalDate;

/**
 * @author sheetal
 *
 */
public class FlightReservation extends Reservation {

	private String flightNumber;
	private String originAirport;
	private String destinationAirport;
	private LocalDate departureTimestamp;
	private LocalDate arrivalTimestamp;
	private boolean needSpecialAssistance;
	private boolean needMealService;

	public FlightReservation(String flightNumber, String originAirport, String destinationAirport,
			LocalDate departureTimestamp, LocalDate arrivalTimestamp, double price) {
		super(price);
		this.setFlightNumber(flightNumber);
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.departureTimestamp = departureTimestamp;
		this.arrivalTimestamp = arrivalTimestamp;
		
	}

	
	public String getFlightNumber() {
		return flightNumber;
	}

	private void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public boolean getNeedSpecialAssistance() {
		return needSpecialAssistance;
	}

	public void setNeedSpecialAssistance(boolean needSpecialAssistance) {
		this.needSpecialAssistance = needSpecialAssistance;
	}

	public boolean getNeedMealService() {
		return needMealService;
	}

	public void setNeedMealService(boolean needMealService) {
		this.needMealService = needMealService;
	}
	
	@Override
	public void confirmReservation() {
		
		System.out.println(String.format("Flight Number %s departing from %s on %s and arriving at %s on %s booked at a price of $%s",
				flightNumber, originAirport, departureTimestamp.toString(), destinationAirport, arrivalTimestamp.toString(), this.getPrice()));
		System.out.println("Flight Reservation Confirmed !!");
		
	}

	@Override
	public void cancelReservation() {
		
		System.out.println("Flight Reservation Canceled !!");
		
	}

}
