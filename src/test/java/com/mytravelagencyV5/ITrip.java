/**
 * 
 */
package com.mytravelagencyV5;

import java.util.List;

/**
 * @author sheetal
 *
 */
public interface ITrip<T> {
	
	double getTotalAmount();
	void addReservation(T reservation);
	
//	void addFlightReservation(T flightReservation);
//	void addHotelReservation(T hotelReservation);
//	void addCarReservation(T carReservation);
}
