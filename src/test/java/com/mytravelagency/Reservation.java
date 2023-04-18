package com.mytravelagency;

import java.util.UUID;

/**
 * @author sheetal
 *
 */

public abstract class Reservation implements IReservation {
	
	private double price;
	private String reservationId;
	private Customer customer;
	
	public Reservation(double price) {
		
		this.setReservationId();
		this.setPrice(price);
	}
	
	public String getReservationId() {
		return reservationId;
	}

	private void setReservationId() {
		UUID uuid = UUID.randomUUID();
		this.reservationId = uuid.toString();
	}
	
	public double getPrice() {
		return price;
	}
	
	private void setPrice(double price) {
		this.price = price;
		
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	public abstract void confirmReservation();
	public abstract void cancelReservation();	
	
}
