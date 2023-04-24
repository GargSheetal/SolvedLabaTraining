/**
 * 
 */
package com.mytravelagencyV2;


/**
 * @author sheetal
 *
 */
public class FlightReservation extends Reservation {

	private Flight flight;
	protected boolean needSpecialAssistance;
	protected boolean needMealService;
	
	public FlightReservation(Flight flight, String customerName, String customerEmail, String customerPhone) {
		super(customerName, customerEmail, customerPhone);
		this.flight = flight;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public void setNeedSpecialAssistance(boolean needSpecialAssistance) {
		this.needSpecialAssistance = needSpecialAssistance;
	}

	public void setNeedMealService(boolean needMealService) {
		this.needMealService = needMealService;
	}

	@Override
	public void confirmReservation() {
		
		System.out.println("\n[SYSTEM] - Flight Reservation Confirmed : ");
		Flight.printFlight(this.flight);
		
	}

	@Override
	public void cancelReservation() {
		
		System.out.println("[SYSTEM] - Flight Reservation Canceled !!");
		
	}
	
	
	@Override
	public String toString() {
		String s = 
		"\nFlight Reservation Id : " + getReservationId() + " -----" +
		"\n" +
		flight.toString() +
		"\n" +
		
				"Customer : " + 
				customerName + " | " + 
				customerEmail + " | " +
				customerPhone
		 +
		"\n" +
		
				"Additional Services : " +
				"\n needMealService : " + needMealService +
				"\n needSpecialAssistance : " + needSpecialAssistance
		;
		
		return s;
	}

	public static void printFlightReservation(FlightReservation flightReservation) {
		System.out.println("\nFlight Reservation Id : " + flightReservation.getReservationId() + " -----");
		Flight.printFlight(flightReservation.flight);
		System.out.println(
				"Customer : " + 
				flightReservation.customerName + " | " + 
				flightReservation.customerEmail + " | " +
				flightReservation.customerPhone
		);
		System.out.println(
				"Additional Services : " +
				"\n needMealService : " + flightReservation.needMealService +
				"\n needSpecialAssistance : " + flightReservation.needSpecialAssistance
		);
	}
	


}
