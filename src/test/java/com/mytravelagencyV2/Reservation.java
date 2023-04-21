package com.mytravelagencyV2;

import java.util.UUID;

/**
 * @author sheetal
 *
 */

public abstract class Reservation implements IReservation {
	
	private String reservationId;
	protected String customerName;
	protected String customerEmail;
	protected String customerPhone;

	public Reservation(String customerName, String customerEmail, String customerPhone) {
		this.setReservationId();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	public String getReservationId() {
		return reservationId;
	}

	private void setReservationId() {
		UUID uuid = UUID.randomUUID();
		this.reservationId = uuid.toString();
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public abstract void confirmReservation();
	public abstract void cancelReservation();	
	
}
