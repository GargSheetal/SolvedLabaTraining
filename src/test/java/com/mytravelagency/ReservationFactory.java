/**
 * 
 */
package com.mytravelagency;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author sheetal
 *
 */
public class ReservationFactory {
	
	public static FlightReservation createFlightReservation(String flightNumber, String originAirport, String destinationAirport,
			LocalDate departureTimestamp, LocalDate arrivalTimestamp, double price) {	
		return new FlightReservation(flightNumber, originAirport, destinationAirport, departureTimestamp, arrivalTimestamp, price);
	};
	
	public static TrainReservation createTrainReservation(String trainNumber, String originStation, String destinationStation,
			Date departureTimestamp, Date arrivalTimestamp, String reservationClass, double price) {	
		return new TrainReservation(trainNumber, originStation, destinationStation, departureTimestamp, arrivalTimestamp, 
				reservationClass, price);
	};
	
	public static BusReservation createBusReservation(String originLocation, String destinationLocation, Date travelDate, 
			double price) {	
		return new BusReservation(originLocation, destinationLocation, travelDate, price);
	};
	
	public static HotelReservation createHotelReservation(String hotelName, LocalDate checkInDate, LocalDate checkOutDate, 
			String roomType, double price) {	
		return new HotelReservation(hotelName, checkInDate, checkOutDate, roomType, price);
	};
	
	
}
