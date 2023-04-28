package com.mytravelagency.utilities;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.mytravelagencyV4.Flight;
import com.mytravelagencyV4.Seat;
import com.travelagency.customexceptions.InputDoesNotMatchException;
import com.travelagency.customexceptions.InvalidInputException;
import com.travelagency.customexceptions.InvalidStateException;

public class MenuHelper {
	
	private static Scanner scanner = new Scanner(System.in);
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	
	public static String readEmailInput(String prompt) {
		
		System.out.print(prompt);
		String email = scanner.nextLine();
		
		try {
			if(!(pattern.matcher(email).matches()))
				throw new InvalidInputException("Invalid Email. Please provide correct email !!");
		}
		catch(InvalidInputException e) 
		{
			System.out.println("InvalidInputException : " + e.getMessage());
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
			System.out.println("InputDoesNotMatchException : " + e.getMessage());
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
			System.out.println("InvalidStateException : " + e.getMessage());
			System.out.println("Enter input again....");
			seat = requestSeatNumber(flight, email);
		}
		return seat;
	}


}
