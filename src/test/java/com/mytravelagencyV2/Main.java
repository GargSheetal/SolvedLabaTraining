package com.mytravelagencyV2;

import java.util.List;
import java.util.Scanner;


public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static Trip trip = new Trip();
	
	private static FlightReservation flightReservationMenuItem() {
		System.out.print("Enter origin airport : ");
		String originAirport = scanner.nextLine();
		

		System.out.print("Enter destination airport : ");
		String destinationAirport = scanner.nextLine();
		

		System.out.print("Enter departure date (yyyy-MM-dd) : ");
		String departureDate = scanner.nextLine();

		
		List<Flight> searchFlightResults = Flight.search(originAirport, destinationAirport, departureDate);
		System.out.println("Search Results -----");
		Flight.printFlightList(searchFlightResults);
		
		System.out.println("Set Filters : ");
		
		System.out.print("Enter max price (default is 0.0) : ");
		double maxPrice = scanner.nextDouble();scanner.nextLine();
		
		System.out.print("Enter max number of stops (default is 0) : ");
		int maxNoOfStops = scanner.nextInt();scanner.nextLine();
		
		List<Flight> filterFlightResults = Flight.filter(searchFlightResults, maxPrice, maxNoOfStops);
		System.out.println("Filtered Results -----");
		Flight.printFlightList(filterFlightResults);
		
		System.out.print("Select your flight : ");
		int selectedFlightIdx = scanner.nextInt();scanner.nextLine();
		
		Flight selectedFlight = filterFlightResults.get(selectedFlightIdx - 1);
		System.out.println("\nFlight Selected -----");
		Flight.printFlight(selectedFlight);
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		System.out.print("Customer Email : ");
		String customerEmail = scanner.nextLine();
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		
		System.out.print("needSpecialAssistance : ");
		Boolean needSpecialAssistance = scanner.nextBoolean();scanner.nextLine();
		System.out.print("needMealService : ");
		Boolean needMealService = scanner.nextBoolean();scanner.nextLine();
		
		FlightReservation flightReservation = ReservationFactory.createFlightReservation(selectedFlight, customerName, customerEmail, customerPhone);
		flightReservation.setNeedSpecialAssistance(needSpecialAssistance);
		flightReservation.setNeedMealService(needMealService);
		flightReservation.confirmReservation();
		return flightReservation;
	}
	
	private static HotelReservation hotelReservationMenuItem() {
		
		System.out.print("Enter location : ");
		String location = scanner.nextLine();
		
		System.out.print("Enter date of stay : ");
		String dateOfStay = scanner.nextLine();
		
		List<Hotel> searchHotelResults = Hotel.search(dateOfStay, location);
		System.out.println("\nSearch Results -----");
		Hotel.printHotelList(searchHotelResults);
		
		System.out.println("Set Filters : ");
		System.out.print("Enter max price (default is 0.0) : ");
		double maxPrice = scanner.nextDouble(); scanner.nextLine();
		
		System.out.print("Enter a room type : ");
		String roomType = scanner.nextLine();
		
		List<Hotel> filteredHotelResults = Hotel.filter(searchHotelResults, maxPrice, roomType);
		System.out.println("Filtered results: ");
		Hotel.printHotelList(filteredHotelResults);
		
		System.out.print("Select your hotel : ");
		int selectedHotelIdx = scanner.nextInt();scanner.nextLine();
		
		Hotel selectedHotel = filteredHotelResults.get(selectedHotelIdx - 1);
		System.out.println("\nHotel Selected -----");
		Hotel.printHotel(selectedHotel);
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		System.out.print("Customer Email : ");
		String customerEmail = scanner.nextLine();
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		
		System.out.print("needFreeBreakfast : ");
		boolean needFreeBreakfast = scanner.nextBoolean(); scanner.nextLine();
		
		System.out.print("needFreeInternet : ");
		boolean needFreeInternet = scanner.nextBoolean(); scanner.nextLine();
		
		HotelReservation hotelReservation = ReservationFactory.createHotelReservation(selectedHotel, customerName, customerEmail, customerPhone);
		hotelReservation.setFreeBreakfast(needFreeBreakfast);
		hotelReservation.setFreeInternet(needFreeInternet);
		hotelReservation.confirmReservation();
		
		return hotelReservation;
	}
	
	private static void addMoreTripReservations() {
		System.out.print("\nDo you want to add more reservations to this trip : ");
		Boolean response = scanner.nextBoolean();scanner.nextLine();
		
		if(response == true) {
			mainMenu();
		}
	}
	
	private static void mainMenu() {
		System.out.print(
			"\n Main Menu -----" + 
			"\n 1. Flight Reservation" + 
			"\n 2. Hotel Reservation" +
			"\n 3. Car Reservation" + 
			"\n 4. Exit" + 
			"\n Enter your response : "
		);
		int mainMenuResponse = scanner.nextInt(); scanner.nextLine();
		
		switch(mainMenuResponse) {
			case 1: trip.addFlightReservation(flightReservationMenuItem()); addMoreTripReservations(); break;
			case 2: trip.addHotelReservation(hotelReservationMenuItem()); addMoreTripReservations(); break;
			default: break;
			
			
		}

	}
	
	
	public static void main(String[] args) {	
		
		mainMenu();
		Trip.printTrip(trip);
		scanner.close();
				
	}

}
