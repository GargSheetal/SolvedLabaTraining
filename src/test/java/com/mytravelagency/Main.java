package com.mytravelagency;

import java.time.LocalDate;


public class Main {
	
	public static void main(String[] args) {
		
		FlightReservation flightReservation = ReservationFactory.createFlightReservation("AI101", "JFK", "DEL", 
				LocalDate.parse("2023-05-19"), LocalDate.parse("2023-05-20"), 987.99);
		System.out.println("Reservation id: " + flightReservation.getReservationId());
		
		flightReservation.setCustomer(new Customer("Mary Jane", "mj123@domain.test"));
		System.out.println("Customer name: " + flightReservation.getCustomer().getName());
		System.out.println("Customer email: " + flightReservation.getCustomer().getEmail());
		
		flightReservation.setNeedMealService(true);
		System.out.println("Need meal service: " + flightReservation.getNeedMealService());
		
		flightReservation.confirmReservation();
		
		System.out.println("--------------------------------------");
		
		
		HotelReservation hotelReservation = ReservationFactory.createHotelReservation("Hilton", LocalDate.parse("2023-06-23"), 
				LocalDate.parse("2023-06-25"), "Queen Suite", 500.78);
		System.out.println("Reservation id: " + flightReservation.getReservationId());
		
		hotelReservation.setCustomer(new Customer("John Doe", "johndoe123@domain.test"));
		System.out.println("Customer name: " + hotelReservation.getCustomer().getName());
		System.out.println("Customer email: " + hotelReservation.getCustomer().getEmail());
		
		hotelReservation.setAddBreakfastService(true);
		System.out.println("Need breakfast service: " + hotelReservation.getAddBreakfastService());
		
		hotelReservation.confirmReservation();
		
		System.out.println("--------------------------------------");
		
	}

}
