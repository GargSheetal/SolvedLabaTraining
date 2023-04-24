/**
 * 
 */
package com.mytravelagencyV3;


/**
 * @author sheetal
 *
 */
public class CarReservation extends Reservation implements ICarReservation {

	private final Car car;
	private boolean needCarSeat;
	
	public CarReservation(Car car) {
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}
	
	public boolean getNeedCarSeat() {
		return needCarSeat;
	}

	@Override
	public void setNeedCarSeat(boolean needCarSeat) {
		this.needCarSeat = needCarSeat;
	}

	@Override
	public void confirmReservation() {
		System.out.println("\n[SYSTEM] - Car is Booked : ");
		System.out.println(this.car.toString());
	}
	
	@Override
	public void cancelReservation() {
		System.out.println("\n[SYSTEM] - Car Reservation Cancelled !!");
		
	}

//	public static void printCarReservation(CarReservation carReservation) {
//		System.out.println("\nCar Reservation Id : " + carReservation.getReservationId() + " -----");
//		Car.printCar(carReservation.car);
//		System.out.println(
//				"Customer : " + 
//				carReservation.customerName + " | " + 
//				carReservation.customerEmail + " | " +
//				carReservation.customerPhone
//		);
//		System.out.println(
//				"Additional Services : " +
//				"\n needCarSeat : " + carReservation.needCarSeat
//		);
//	}
	
	// overriding toString method to return stringify version of Car Reservation details
	@Override
	public String toString() {
		String s = 
				"\nCar Reservation Id : " + this.getReservationId() + " -----" +
				"\n" +
				this.car.toString() +
				"\n" + 
				
					"Customer : " +
					this.customer.getCustomerName() + " | " +
					this.customer.getCustomerEmail() + " | " +
					this.customer.getCustomerPhone() +
				"\n" + 
				"Additional Services : " +
				""
					
				;
		return s;
	}

}
