/**
 * 
 */
package com.mytravelagencyV2;


/**
 * @author sheetal
 *
 */
public class CarReservation extends Reservation {

	private Car car;
	private boolean needCarSeat;
	
	public CarReservation(Car car, String customerName, String customerEmail, String customerPhone) {
		super(customerName, customerEmail, customerPhone);
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean getNeedCarSeat() {
		return needCarSeat;
	}

	public void setNeedCarSeat(boolean needCarSeat) {
		this.needCarSeat = needCarSeat;
	}

	@Override
	public void confirmReservation() {
		System.out.println("\n[SYSTEM] - Car is Booked : ");
		
	}
	@Override
	public void cancelReservation() {
		System.out.println("\n[SYSTEM] - Car is Cancelled");
		
	}

	
	public static void printCarReservation(CarReservation carReservation) {
		System.out.println("\nCar Reservation Id : " + carReservation.getReservationId() + " -----");
		Car.printCar(carReservation.car);
		System.out.println(
				"Customer : " + 
				carReservation.customerName + " | " + 
				carReservation.customerEmail + " | " +
				carReservation.customerPhone
		);
		System.out.println(
				"Additional Services : " +
				"\n needCarSeat : " + carReservation.needCarSeat
		);
	}

}
