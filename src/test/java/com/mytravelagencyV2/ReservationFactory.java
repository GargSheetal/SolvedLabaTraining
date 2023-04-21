/**
 * 
 */
package com.mytravelagencyV2;


/**
 * @author sheetal
 *
 */
public class ReservationFactory {
	
	public static FlightReservation createFlightReservation(Flight flight, String customerName, String customerEmail, String customerPhone) {	
		return new FlightReservation(flight, customerName, customerEmail, customerPhone);
	
	};
	
	public static CarReservation createCarReservation(Car car, String customerName, String customerEmail, String customerPhone) {	
		return new CarReservation(car, customerName, customerEmail, customerPhone);
	};
	
	public static HotelReservation createHotelReservation(Hotel hotel, String customerName, String customerEmail, String customerPhone) {	
		return new HotelReservation(hotel, customerName, customerEmail, customerPhone);
	};
	
	
}
