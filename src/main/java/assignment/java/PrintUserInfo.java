package assignment.java;
/*
 * Task:
 * Create a simple system.out app. Print info about the user that should be passed to the main function as a parameter. 
 * Compile and run the program from the command line using javac and java from JDK.
 * 
 * 
 * How to run this program from Terminal:
 * cd <path of the package where class is located>
 * javac <className.java>
 * java <className.java> <firstName> <lastName> <email> <age>
 */

/**
 * @author sheetal
 *
 */
public class PrintUserInfo {

	public static void main(String[] args) {
		
		String firstName = args[0];
		String lastName = args[1];
		String email = args[2];
		int age = Integer.parseInt(args[3]);
		
		System.out.println("User's Info: ");
		System.out.println("Firstname: " + firstName);
		System.out.println("Lastname: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("Age: " + age);

	}

}
