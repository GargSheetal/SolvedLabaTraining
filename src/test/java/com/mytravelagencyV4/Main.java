package com.mytravelagencyV4;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mytravelagency.utilities.MenuHelper;
import com.travelagency.customexceptions.MissingInputException;



public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static Trip trip = new Trip();
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	
	private static IFlightReservation flightReservationMenuItem() {
		
		logger.trace("Flight Reservation started");
		System.out.print("Enter origin airport : ");
		String originAirport = scanner.nextLine();
		logger.debug("originAirport: {}", originAirport);
		
		System.out.print("Enter Destination airport : ");
		String destinationAirport = scanner.nextLine();
		logger.debug("destinationAirport: {}", destinationAirport);
		
		System.out.print("Enter departure date (yyyy-MM-dd) : ");
		String departureDate = scanner.nextLine();
		logger.debug("departureDate: {}", departureDate);
		
		List<Flight> searchFlightResults = Flight.search(originAirport, destinationAirport, departureDate);
		System.out.println("\nSearch Results -----");
		for(Flight flight: searchFlightResults)
		{
			System.out.println(
					(searchFlightResults.indexOf(flight) + 1) + " | " +
					flight.toString()
					);
		}
		logger.trace("Flight search results fetched");
		
		System.out.println("\nSet Filters : ");
		System.out.print("Enter max price : ");
		double maxPrice = scanner.nextDouble();scanner.nextLine();
		logger.debug("maxPrice: {}", maxPrice);
		
		System.out.print("Enter max number of stops : ");
		int maxNoOfStops = scanner.nextInt();scanner.nextLine();
		logger.debug("maxNoOfStops: {}", maxNoOfStops);
		
		List<Flight> filterFlightResults = Flight.filter(searchFlightResults, maxPrice, maxNoOfStops);
		System.out.println("\nFiltered Results -----");
		for(Flight flight: filterFlightResults)
		{
			System.out.println(
					(filterFlightResults.indexOf(flight) + 1) + " | " +
					flight.toString()
					);
		}
		logger.trace("Flight search results filtered");
		
		System.out.print("Select your flight : ");
		int selectedFlightIdx = scanner.nextInt();scanner.nextLine();
		
		Flight selectedFlight = filterFlightResults.get(selectedFlightIdx - 1);
		System.out.println("\nFlight Selected -----");
		System.out.println(selectedFlight.toString());
		logger.debug("Flight Selected: {}", selectedFlight.toString());
		
		IFlightReservation flightReservation = ReservationFactory.createFlightReservation(selectedFlight);
		logger.debug("Flight reservation initiated : {}", flightReservation.getReservationId());
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		flightReservation.getCustomer().setCustomerName(customerName);
		logger.debug("Customer Name: {}", customerName);
		
		String customerEmail = MenuHelper.requestCustomerEmail();
		flightReservation.getCustomer().setCustomerEmail(customerEmail);
		logger.debug("Customer Email: {}", customerEmail);
		
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		flightReservation.getCustomer().setCustomerPhone(customerPhone);
		logger.debug("Customer Phone: {}", customerPhone);
		
		Seat seat = MenuHelper.requestSeatNumber(selectedFlight, customerEmail);
		flightReservation.setSeat(seat);
		logger.debug("Seat Selected: {}", seat.toString());
		
		System.out.print("needSpecialAssistance : ");
		Boolean needSpecialAssistance = scanner.nextBoolean();scanner.nextLine();
		flightReservation.setNeedSpecialAssistance(needSpecialAssistance);
		logger.debug("needSpecialAssistance: {}", needSpecialAssistance);
		
		System.out.print("needMealService : ");
		Boolean needMealService = scanner.nextBoolean();scanner.nextLine();
		flightReservation.setNeedMealService(needMealService);
		logger.debug("needMealService: {}", needMealService);
		
		try {
			flightReservation.confirmReservation();
			System.out.println(flightReservation.toString());
			logger.info("Flight is reserved: {}", flightReservation.toString());
		} catch (MissingInputException e) {
			flightReservation = null;
			System.out.println("\nMissingInputException : " + e.getMessage());
			logger.error("Flight cannot be reserved. MissingInputException : {}", e.getMessage());
		}
		return flightReservation;
	}
	
	private static IHotelReservation hotelReservationMenuItem() {
		
		logger.trace("Hotel Reservation started");
		System.out.print("Enter location : ");
		String location = scanner.nextLine();
		logger.debug("location: {}", location);
		
		System.out.print("Enter date of stay : ");
		String dateOfStay = scanner.nextLine();
		logger.debug("dateOfStay: {}", dateOfStay);
		
		List<Hotel> searchHotelResults = Hotel.search(location, dateOfStay);
		System.out.println("\nSearch Results -----");
		
		for(Hotel hotel: searchHotelResults)
		{
			System.out.println(
					(searchHotelResults.indexOf(hotel) + 1) + " | " +
					hotel.toString()
					);
		}
		logger.trace("Hotel search results fetched");
		
		System.out.println("\nSet Filters : ");
		System.out.print("Enter max price : ");
		double maxPrice = scanner.nextDouble(); scanner.nextLine();
		logger.debug("maxPrice: {}", maxPrice);
		
		System.out.print("Enter a room type : ");
		String roomType = scanner.nextLine();
		logger.debug("roomType: {}", roomType);
		
		List<Hotel> filteredHotelResults = Hotel.filter(searchHotelResults, maxPrice, roomType);
		System.out.println("\nFiltered results: ");
		
		for(Hotel hotel: filteredHotelResults) 
		{
			System.out.println(
					(filteredHotelResults.indexOf(hotel) + 1) + " | " +
						hotel.toString()
					);
		}
		logger.trace("Hotel search results filtered");
		
		System.out.print("Select your hotel : ");
		int selectedHotelIdx = scanner.nextInt();scanner.nextLine();
		
		logger.info("Hotel Selected");
		Hotel selectedHotel = filteredHotelResults.get(selectedHotelIdx - 1);
		System.out.println("\nHotel Selected -----");
		System.out.println(selectedHotel.toString());
		logger.debug("Hotel Selected: {}", selectedHotel.toString());
		
		IHotelReservation hotelReservation = ReservationFactory.createHotelReservation(selectedHotel);
		logger.debug("Hotel reservation initiated : {}", hotelReservation.getReservationId());
		
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		hotelReservation.getCustomer().setCustomerName(customerName);
		logger.debug("Customer Name: {}", customerName);
		
		String customerEmail = MenuHelper.requestCustomerEmail();
		hotelReservation.getCustomer().setCustomerEmail(customerEmail);
		logger.debug("Customer Email: {}", customerEmail);
		
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		hotelReservation.getCustomer().setCustomerPhone(customerPhone);
		logger.debug("Customer Phone: {}", customerPhone);
		
		System.out.print("needFreeBreakfast : ");
		boolean needFreeBreakfast = scanner.nextBoolean(); scanner.nextLine();
		hotelReservation.setNeedFreeBreakfast(needFreeBreakfast);
		logger.debug("needFreeBreakfast: {}", needFreeBreakfast);
		
		System.out.print("needFreeInternet : ");
		boolean needFreeInternet = scanner.nextBoolean(); scanner.nextLine();
		hotelReservation.setNeedFreeInternet(needFreeInternet);
		logger.debug("needFreeInternet: {}", needFreeInternet);
	
		try {
			hotelReservation.confirmReservation();
			System.out.println(hotelReservation.toString());
			logger.info("Hotel is reserved: {}", hotelReservation.toString());
		} catch (MissingInputException e) {
			hotelReservation = null;
			System.out.println("\nMissingInputException : " + e.getMessage());
			logger.error("Hotel cannot be reserved. MissingInputException : {}", e.getMessage());
		}
		return hotelReservation;
	}
	
	private static ICarReservation carReservationMenuItem() throws MissingInputException {
		
		logger.trace("Car Reservation started");
		System.out.print("Enter location : ");
		String location = scanner.nextLine();
		logger.debug("location: {}", location);
		
		System.out.print("Enter pickupDate : ");
		String pickupDate = scanner.nextLine();
		logger.debug("pickupDate: {}", pickupDate);
		
		System.out.print("Enter dropOffDate : ");
		String dropOffDate = scanner.nextLine();
		logger.debug("dropOffDate: {}", dropOffDate);
		
		List<Car> searchCarResults = Car.search(location, pickupDate, dropOffDate);
		System.out.println("\nSearch Results -----");
		for(Car car: searchCarResults)
		{
			System.out.println(
					(searchCarResults.indexOf(car) + 1) + " | " +
					car.toString()
					);
		}
		logger.trace("Car search results filtered");
		
		System.out.println("\nSet Filters : ");
		System.out.print("Enter max price : ");
		double maxPrice = scanner.nextDouble(); scanner.nextLine();
		logger.debug("maxPrice: {}", maxPrice);
		
		System.out.print("Enter a carType : ");
		String carType = scanner.nextLine();
		logger.debug("carType: {}", carType);
		
		List<Car> filteredCarResults = Car.filter(searchCarResults, maxPrice, carType);
		System.out.println("\nFiltered results: ");

		for(Car car: filteredCarResults)
		{
			System.out.println(
					(filteredCarResults.indexOf(car) + 1) + " | " +
					car.toString()
					);
		}
		logger.trace("Car search results filtered");
		
		System.out.print("Select your car : ");
		int selectedCarIdx = scanner.nextInt();scanner.nextLine();
		
		Car selectedCar = filteredCarResults.get(selectedCarIdx - 1);
		System.out.println("\nCar Selected -----");
		System.out.println(selectedCar.toString());
		logger.debug("Flight Selected: {}", selectedCar.toString());
		
		ICarReservation carReservation = ReservationFactory.createCarReservation(selectedCar);
		logger.debug("Car reservation initiated : {}", carReservation.getReservationId());
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		carReservation.getCustomer().setCustomerName(customerName);
		logger.debug("Customer Name: {}", customerName);
		
		String customerEmail = MenuHelper.requestCustomerEmail();
		carReservation.getCustomer().setCustomerEmail(customerEmail);
		logger.debug("Customer Email: {}", customerEmail);
		
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		carReservation.getCustomer().setCustomerPhone(customerPhone);
		logger.debug("Customer Phone: {}", customerPhone);
		
		System.out.print("needCarSeat : ");
		boolean needCarSeat = scanner.nextBoolean(); scanner.nextLine();
		carReservation.setNeedCarSeat(needCarSeat);
		logger.debug("needCarSeat: {}", needCarSeat);
		
		try {
			carReservation.confirmReservation();
			System.out.println(carReservation.toString());
			logger.info("Car is reserved: {}", carReservation.toString());
		} catch (MissingInputException e) {
			carReservation = null;
			System.out.println("\nMissingInputException : " + e.getMessage());
			logger.error("Car cannot be reserved. MissingInputException : {}", e.getMessage());
		}
		return carReservation;
	}
	
	private static void addMoreTripReservations() throws MissingInputException {
		System.out.print("\nDo you want to add more reservations to this trip : ");
		Boolean response = scanner.nextBoolean();scanner.nextLine();
		
		if(response == true) {
			mainMenu();
		}
	}
	
	private static void mainMenu() throws MissingInputException {
		
		logger.info("Presenting Main Menu");
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
			case 3: trip.addCarReservation(carReservationMenuItem()); addMoreTripReservations(); break;
			default: break;
			
		}
	}
	
	
	public static void main(String[] args) throws MissingInputException {	
		
		mainMenu();
		Trip.printTrip(trip);
		scanner.close();
				
	}

}
