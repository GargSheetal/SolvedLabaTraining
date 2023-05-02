package com.mytravelagencyV5;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.travelagency.customexceptions.InputDoesNotMatchException;
import com.travelagency.customexceptions.InvalidInputException;

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
	
}
