package com.mytravelagencyV5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.travelagency.customexceptions.InputDoesNotMatchException;
import com.travelagency.customexceptions.InvalidInputException;
import com.travelagency.customexceptions.InvalidStateException;

public class FlightReservationMenu {
	
	private static Scanner scanner = new Scanner(System.in);
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static String readOriginAirports() {
		HashSet<String> originAirports = Flight.getAirportCodes();
		logger.info("Enter Origin Airport " + originAirports.toString() + " :" + "");
		String selectedOriginAirport = scanner.nextLine();
		try {
			if(!(originAirports.contains(selectedOriginAirport)))
			{
				throw new InvalidInputException("Unknown Airport Code !");
			}
		}
		catch(InvalidInputException e)
		{
			System.out.println("InvalidInputException : " + e.getMessage());
			selectedOriginAirport = readOriginAirports();
		}
		
		return selectedOriginAirport;
	}
	
	public static String readDestinationAirports() {
		HashSet<String> originAirports = Flight.getAirportCodes();
		logger.info("Enter Destination Airport " + originAirports.toString() + " :");
		String selectedOriginAirport = scanner.nextLine();
		try {
			if(!(originAirports.contains(selectedOriginAirport)))
			{
				throw new InvalidInputException("Unknown Airport Code !");
			}
		}
		catch(InvalidInputException e)
		{
			System.out.println("InvalidInputException : " + e.getMessage());
			selectedOriginAirport = readDestinationAirports();
		}
		
		return selectedOriginAirport;
	}
	
	public static String readEmailInput(String prompt) {
		
		System.out.print(prompt);
		String email = scanner.nextLine();
		
		try {
			if(!(pattern.matcher(email).matches()))
				throw new InvalidInputException("Invalid Email. Please provide correct email !!");
		}
		catch(InvalidInputException e) 
		{
			System.out.println("\nInvalidInputException : " + e.getMessage());
			System.out.println("Enter Input again...");
			email = readEmailInput(prompt);
		}
		
		return email;
	}
	
	
	public static String requestCustomerEmail() {
		
		String customerEmail = readEmailInput("Customer Email : ");
		String confirmEmail = readEmailInput("Confirm Email : ");
		
		try {
			if(!(customerEmail.equals(confirmEmail)))
			{
				throw new InputDoesNotMatchException("Email Inputs do not match !!");
			}
		}
		catch(InputDoesNotMatchException e)
		{
			System.out.println("\nInputDoesNotMatchException : " + e.getMessage());
			System.out.println("Enter Inputs again");
			customerEmail = requestCustomerEmail();
		}
		return customerEmail;
		
	}
	
	public static Seat requestSeatNumber(Flight flight, String email) {

		System.out.print("Select a seat : ");

		String selectedSeat = scanner.nextLine();
		Seat seat = new Seat(selectedSeat);

		try {
			flight.addSeatOccupancy(seat, email);
			System.out.println("Seat selected : " + seat.getSeatNumber() + " | Occupied seat count : " + flight.seatOccupancyMap.size());
			System.out.println(flight.seatOccupancyMap.toString());
		} catch (InvalidStateException e) {
			System.out.println("\nInvalidStateException : " + e.getMessage());
			System.out.println("Enter input again....");
			seat = requestSeatNumber(flight, email);
		}
		return seat;
	}
	
	public static void requestAddToQueueForBusinessClassSeat(Flight flight, String customerEmail) {
		
		System.out.println("Queue for upgrade to business class before request : " + 
				flight.queueForUpgradeToBusinessClass.toString());
		System.out.print("\nDo you want an upgrade to Business Class Seat: ");
		boolean response = scanner.nextBoolean(); scanner.nextLine();
		if(response == true)
		{
			flight.addToQueueForUpgradeToBusinessClass(customerEmail);
		}
	}
	
	public static void requestAddBusinessClassSeat(Flight flight) throws InvalidStateException {
		
		System.out.println("Queue for upgrade to business class after request : " + 
				flight.queueForUpgradeToBusinessClass.toString());
		System.out.print("\nEnter new Business Class Seat for " + flight.getFlightNumber() + " :");
		String businessClassSeat = scanner.nextLine();
		String nextCustomerEmail = flight.getNextInQueueForUpgradeToBusinessClass();
		flight.removeSeatOccupancy(nextCustomerEmail);
		flight.addSeatOccupancy(new Seat(businessClassSeat), nextCustomerEmail);
		flight.removeFromQueueForUpgradeToBusinessClass(nextCustomerEmail);
		System.out.println("Current queue for upgrade to business class : " + 
				flight.queueForUpgradeToBusinessClass.toString());
		System.out.println("Seats reserved for flight " + flight.getFlightNumber() + " : " + flight.seatOccupancyMap.toString());
		
	}
}
