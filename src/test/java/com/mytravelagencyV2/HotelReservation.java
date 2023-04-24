package com.mytravelagencyV2;


/**
 * @author sheetal
 *
 */

public class HotelReservation extends Reservation {


	private Hotel hotel;
	private boolean freeBreakfast;
	private boolean freeInternet;

	public HotelReservation(Hotel hotel, String customerName, String customerEmail, String customerPhone) {
		super(customerName, customerEmail, customerPhone);
		this.hotel = hotel;
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public boolean isFreeBreakfast() {
		return freeBreakfast;
	}

	public void setFreeBreakfast(boolean freeBreakfast) {
		this.freeBreakfast = freeBreakfast;
	}

	public boolean isFreeInternet() {
		return freeInternet;
	}

	public void setFreeInternet(boolean freeInternet) {
		this.freeInternet = freeInternet;
	}

	@Override
	public void confirmReservation() {
		System.out.println("\n[SYSTEM] - Hotel Reservation Confirmed : ");
		Hotel.printHotel(this.hotel);
		
	}

	@Override
	public void cancelReservation() {
		System.out.println("\n[SYSTEM] - Hotel Reservation Canceled !!");
		
	}
	
	
	public static void printHotelReservation(HotelReservation hotelReservation) {
		System.out.println("\nHotel Reservation Id : " + hotelReservation.getReservationId() + " -----");
		Hotel.printHotel(hotelReservation.hotel);
		System.out.println(
				"Customer : " + 
				hotelReservation.customerName + " | " + 
				hotelReservation.customerEmail + " | " +
				hotelReservation.customerPhone
		);
		System.out.println(
				"Additional Services : " +
				"\n freeBreakfast : " + hotelReservation.freeBreakfast +
				"\n freeInternet : " + hotelReservation.freeInternet
		);
	}
	
	
	
	
}
