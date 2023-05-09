package miscellaneous;

import java.time.LocalDate;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.LocalTime;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class DateFormatExample {

	  public static void main(String[] args) {
		  		  
		LocalDateTime localDate = LocalDateTime.now(); //now() method gets the current value whether used w/ LocalDate/LocalTime/LocalDateTime
		System.out.println("Before formatting : " + localDate);
		
		DateTimeFormatter dateFormatterObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = localDate.format(dateFormatterObj);
		System.out.println("After formatting : " + formattedDate);
		
		// Printing current date
		LocalDate dateObj = LocalDate.now();
		System.out.println("Current date : " + dateObj);
		
		// Printing current time
		LocalTime timeObj = LocalTime.now();
		System.out.println("Current time : " + timeObj);
		
	  }
	
	
}
