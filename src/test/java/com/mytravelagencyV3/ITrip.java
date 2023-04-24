/**
 * 
 */
package com.mytravelagencyV3;

/**
 * @author sheetal
 *
 */
public interface ITrip {
	
	double getTotalAmount();
	void addFlightReservation(IFlightReservation flightReservation);
	void addHotelReservation(IHotelReservation hotelReservation);
	void addCarReservation(ICarReservation carReservation);
}
