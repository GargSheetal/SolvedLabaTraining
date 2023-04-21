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
		System.out.println("Cab is Booked");
		
	}
	@Override
	public void cancelReservation() {
		System.out.println("Cab is Cancelled");
		
	}


}
