/**
 * 
 */
package com.mytravelagencyV3;


/**
 * @author sheetal
 *
 */
public final class FlightReservation extends Reservation implements IFlightReservation {

	private final Flight flight;
	private boolean needSpecialAssistance;
	private boolean needMealService;
	
	public FlightReservation(Flight flight) {
		this.flight = flight;
	}

	public Flight getFlight() {
		return flight;
	}
	
	public boolean getNeedSpecialAssistance()
	{
		return needSpecialAssistance;
	}
	
	@Override
	public void setNeedSpecialAssistance(boolean needSpecialAssistance) {
		this.needSpecialAssistance = needSpecialAssistance;
	}

	public boolean getNeedMealService()
	{
		return needMealService;
	}
	
	@Override
	public void setNeedMealService(boolean needMealService) {
		this.needMealService = needMealService;
	}

	@Override
	public void confirmReservation() {
		
		System.out.println("\n[SYSTEM] - Flight Reservation Confirmed : ");
		System.out.println(this.flight.toString());
		
	}

	@Override
	public void cancelReservation() {
		
		System.out.println("\n[SYSTEM] - Flight Reservation Canceled !!");
		
	}
	
	// overriding toString method to return stringify version of Flight Reservation details
	@Override
	public String toString() {
		String s = 
		"\nFlight Reservation Id : " + this.getReservationId() + " -----" +
		"\n" +
		this.flight.toString() +
		"\n" +
		
				"Customer : " + 
				this.customer.getCustomerName() + " | " + 
				this.customer.getCustomerEmail() + " | " +
				this.customer.getCustomerPhone()
		 +
		"\n" +
		
				"Additional Services : " +
				"\n needMealService : " + this.needMealService +
				"\n needSpecialAssistance : " + this.needSpecialAssistance
		;
		
		return s;
	}

}
