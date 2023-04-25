package com.mytravelagencyV3;

import java.util.List;
import java.util.Scanner;


public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static Trip trip = new Trip();
	
	private static IFlightReservation flightReservationMenuItem() {
		System.out.print("Enter origin airport : ");
		String originAirport = scanner.nextLine();
		

		System.out.print("Enter destination airport : ");
		String destinationAirport = scanner.nextLine();
		

		System.out.print("Enter departure date (yyyy-MM-dd) : ");
		String departureDate = scanner.nextLine();

		
		List<Flight> searchFlightResults = Flight.search(originAirport, destinationAirport, departureDate);
		System.out.println("\nSearch Results -----");
		for(Flight flight: searchFlightResults)
		{
			System.out.println(
					(searchFlightResults.indexOf(flight) + 1) + " | " +
					flight.toString()
					);
		}
		
		System.out.println("\nSet Filters : ");
		
		System.out.print("Enter max price : ");
		double maxPrice = scanner.nextDouble();scanner.nextLine();
		
		System.out.print("Enter max number of stops : ");
		int maxNoOfStops = scanner.nextInt();scanner.nextLine();
		
		List<Flight> filterFlightResults = Flight.filter(searchFlightResults, maxPrice, maxNoOfStops);
		System.out.println("\nFiltered Results -----");

		for(Flight flight: filterFlightResults)
		{
			System.out.println(
					(filterFlightResults.indexOf(flight) + 1) + " | " +
					flight.toString()
					);
		}
		
		System.out.print("Select your flight : ");
		int selectedFlightIdx = scanner.nextInt();scanner.nextLine();
		
		Flight selectedFlight = filterFlightResults.get(selectedFlightIdx - 1);
		System.out.println("\nFlight Selected -----");
		System.out.println(selectedFlight.toString());
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		System.out.print("Customer Email : ");
		String customerEmail = scanner.nextLine();
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		
		System.out.print("Select 1st seat : ");
		String selectedSeat1 = scanner.nextLine();
		selectedFlight.seatOccupancyMap.put(new Seat(selectedSeat1), customerName);
		System.out.println("1st Seat : " + selectedSeat1 + " | Occupied seat count : " + selectedFlight.seatOccupancyMap.size());
		
		System.out.print("Select 2nd seat : ");
		String selectedSeat2 = scanner.nextLine();
		selectedFlight.seatOccupancyMap.put(new Seat(selectedSeat2), customerName);
		System.out.println("2nd Seat : " + selectedSeat2 + " | Occupied seat count : " + selectedFlight.seatOccupancyMap.size());
			
		System.out.print("needSpecialAssistance : ");
		Boolean needSpecialAssistance = scanner.nextBoolean();scanner.nextLine();
		System.out.print("needMealService : ");
		Boolean needMealService = scanner.nextBoolean();scanner.nextLine();
	
		IFlightReservation flightReservation = ReservationFactory.createFlightReservation(selectedFlight);
		flightReservation.getCustomer().setCustomerName(customerName);
		flightReservation.getCustomer().setCustomerEmail(customerEmail);
		flightReservation.getCustomer().setCustomerPhone(customerPhone);
		flightReservation.setNeedSpecialAssistance(needSpecialAssistance);
		flightReservation.setNeedMealService(needMealService);
		flightReservation.confirmReservation();
		System.out.println(flightReservation.toString());
		return flightReservation;
		
	}
	
	private static IHotelReservation hotelReservationMenuItem() {
		
		System.out.print("Enter location : ");
		String location = scanner.nextLine();
		
		System.out.print("Enter date of stay : ");
		String dateOfStay = scanner.nextLine();
		
		List<Hotel> searchHotelResults = Hotel.search(location, dateOfStay);
		System.out.println("\nSearch Results -----");
		
		for(Hotel hotel: searchHotelResults)
		{
			System.out.println(
					(searchHotelResults.indexOf(hotel) + 1) + " | " +
					hotel.toString()
					);
		}
		
		System.out.println("\nSet Filters : ");
		System.out.print("Enter max price : ");
		double maxPrice = scanner.nextDouble(); scanner.nextLine();
		
		System.out.print("Enter a room type : ");
		String roomType = scanner.nextLine();
		
		List<Hotel> filteredHotelResults = Hotel.filter(searchHotelResults, maxPrice, roomType);
		System.out.println("\nFiltered results: ");
		
		for(Hotel hotel: filteredHotelResults) 
		{
			System.out.println(
					(filteredHotelResults.indexOf(hotel) + 1) + " | " +
						hotel.toString()
					);
		}
		
		System.out.print("Select your hotel : ");
		int selectedHotelIdx = scanner.nextInt();scanner.nextLine();
		
		Hotel selectedHotel = filteredHotelResults.get(selectedHotelIdx - 1);
		System.out.println("\nHotel Selected -----");
		System.out.println(selectedHotel.toString());
		
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
		
		IHotelReservation hotelReservation = ReservationFactory.createHotelReservation(selectedHotel);
		hotelReservation.getCustomer().setCustomerName(customerName);
		hotelReservation.getCustomer().setCustomerEmail(customerEmail);
		hotelReservation.getCustomer().setCustomerPhone(customerPhone);
		hotelReservation.setNeedFreeBreakfast(needFreeBreakfast);
		hotelReservation.setNeedFreeInternet(needFreeInternet);
		hotelReservation.confirmReservation();
		System.out.println(hotelReservation.toString());
		
		return hotelReservation;
	}
	
	private static ICarReservation carReservationMenuItem() {
		
		System.out.print("Enter location : ");
		String location = scanner.nextLine();
		
		System.out.print("Enter pickupDate : ");
		String pickupDate = scanner.nextLine();
		
		System.out.print("Enter dropOffDate : ");
		String dropOffDate = scanner.nextLine();
		
		List<Car> searchCarResults = Car.search(location, pickupDate, dropOffDate);
		System.out.println("\nSearch Results -----");
		for(Car car: searchCarResults)
		{
			System.out.println(
					(searchCarResults.indexOf(car) + 1) + " | " +
					car.toString()
					);
		}
		
		System.out.println("\nSet Filters : ");
		System.out.print("Enter max price : ");
		double maxPrice = scanner.nextDouble(); scanner.nextLine();
		
		System.out.print("Enter a carType : ");
		String carType = scanner.nextLine();
		
		List<Car> filteredCarResults = Car.filter(searchCarResults, maxPrice, carType);
		System.out.println("\nFiltered results: ");

		for(Car car: filteredCarResults)
		{
			System.out.println(
					(filteredCarResults.indexOf(car) + 1) + " | " +
					car.toString()
					);
		}
		
		System.out.print("Select your car : ");
		int selectedCarIdx = scanner.nextInt();scanner.nextLine();
		
		Car selectedCar = filteredCarResults.get(selectedCarIdx - 1);
		System.out.println("\nCar Selected -----");
		System.out.println(selectedCar.toString());
		
		System.out.print("\nCustomer Name : ");
		String customerName = scanner.nextLine();
		System.out.print("Customer Email : ");
		String customerEmail = scanner.nextLine();
		System.out.print("Customer Phone : ");
		String customerPhone = scanner.nextLine();
		
		System.out.print("needCarSeat : ");
		boolean needCarSeat = scanner.nextBoolean(); scanner.nextLine();
		System.out.print("Confirm Reservation : ");
		scanner.nextBoolean(); scanner.nextLine();
		
		ICarReservation carReservation = ReservationFactory.createCarReservation(selectedCar);
		carReservation.getCustomer().setCustomerName(customerName);
		carReservation.getCustomer().setCustomerEmail(customerEmail);
		carReservation.getCustomer().setCustomerPhone(customerPhone);
		carReservation.setNeedCarSeat(needCarSeat);
		carReservation.confirmReservation();
		System.out.println(carReservation.toString());
		
		return carReservation;
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
			case 3: trip.addCarReservation(carReservationMenuItem()); addMoreTripReservations(); break;
			default: break;
			
		}
	}
	
	
	public static void main(String[] args) {	
		
		mainMenu();
		Trip.printTrip(trip);
		scanner.close();
				
	}

}
