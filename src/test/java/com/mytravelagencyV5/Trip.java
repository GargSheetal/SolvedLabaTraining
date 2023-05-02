package com.mytravelagencyV5;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trip<T> implements ITrip<T> {

	private String tripId;
	private static double ONLINE_BOOKING_FEE;
	private double totalAmount;
//	List<T> flightReservations = new ArrayList<>();
//	List<T> hotelReservations = new ArrayList<>();
//	List<T> carReservations = new ArrayList<>();
	List<T> reservations = new ArrayList<>();
	
	static {
		ONLINE_BOOKING_FEE = 0.55;
	}
	
	public Trip() {};

	public String getTripId() {
		return tripId;
	}

	@Override
	public double getTotalAmount() {
		return totalAmount;
	}

	private void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	private void createTripIfNotExist() {
		
		if(tripId == null)
		{
			UUID uuid = UUID.randomUUID();
			this.tripId = uuid.toString();
			this.totalAmount += ONLINE_BOOKING_FEE;
		}
	}
	
	public void addReservation(T reservation) {
		if(reservation != null)
		{
			createTripIfNotExist();
			this.reservations.add(reservation);
			this.setTotalAmount(this.totalAmount);
		}
	}
	
	
//	@Override
//	public void addFlightReservation(T flightReservation) {
//		if(flightReservation != null)
//		{
//			createTripIfNotExist();
//			this.flightReservations.add(flightReservation);
//			this.setTotalAmount(this.totalAmount + ((IFlightReservation) flightReservation).getFlight().getPrice());
//		}
//	}
//	
//	@Override
//	public void addHotelReservation(T hotelReservation) {
//		if(hotelReservation != null)
//		{
//			createTripIfNotExist();
//			this.hotelReservations.add(hotelReservation);
//			this.setTotalAmount(this.totalAmount + ((IHotelReservation) hotelReservation).getHotel().getPrice());
//		}
//	}
//	
//	@Override
//	public void addCarReservation(T carReservation) {
//		if(carReservation != null)
//		{
//			createTripIfNotExist();
//			this.carReservations.add(carReservation);
//			this.setTotalAmount(this.totalAmount + ((ICarReservation) carReservation).getCar().getPrice());
//		}
//	}
	
//	public void printTrip(Trip trip) {
//		System.out.println("\n\n============= Receipt ==============");
//		if(trip.getTripId() == null)
//		{
//			System.out.println("No reservations");
//			return;
//		}
//		System.out.println("----- Trip Id : " + trip.getTripId() + " -----");
//		
//		for(T flightReservation: this.flightReservations) {
//			System.out.println(flightReservation.toString());		
//		}
//		for(T hotelReservation: this.hotelReservations) {
//			System.out.println(hotelReservation.toString());
//		}
//		for(T carReservation: this.carReservations) {
//			System.out.println(carReservation.toString());
//		}
//		System.out.println("\n----- Total Amount : $" + trip.totalAmount + " -----");
//	}
	
	public void printTrip(Trip trip) {
		System.out.println("\n\n============= Receipt ==============");
		if(trip.getTripId() == null)
		{
			System.out.println("No reservations");
			return;
		}
		System.out.println("----- Trip Id : " + trip.getTripId() + " -----");
		
		for(T reservation: this.reservations) {
			System.out.println(reservation.toString());
		}
//		for(T hotelReservation: this.reservations) {
//			System.out.println(hotelReservation.toString());
//		}
//		for(T carReservation: this.reservations) {
//			System.out.println(carReservation.toString());
//		}
		System.out.println("\n----- Total Amount : $" + trip.totalAmount + " -----");
	}

}
