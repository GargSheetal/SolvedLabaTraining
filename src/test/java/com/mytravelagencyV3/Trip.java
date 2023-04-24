package com.mytravelagencyV3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trip implements ITrip{

	private final String tripId;
	private final static double ONLINE_BOOKING_FEE;
	private double totalAmount;
	List<IFlightReservation> flightReservations = new ArrayList<>();
	List<IHotelReservation> hotelReservations = new ArrayList<>();
	List<ICarReservation> carReservations = new ArrayList<>();
	
	static {
		ONLINE_BOOKING_FEE = 0.55;
	}
	
	public Trip() {
		UUID uuid = UUID.randomUUID();
		this.tripId = uuid.toString();
		this.totalAmount += ONLINE_BOOKING_FEE;
	}

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
	
	@Override
	public void addFlightReservation(IFlightReservation flightReservation) {
		this.flightReservations.add(flightReservation);
		this.setTotalAmount(this.totalAmount + flightReservation.getFlight().getPrice());
	}
	
	@Override
	public void addHotelReservation(IHotelReservation hotelReservation) {
		this.hotelReservations.add(hotelReservation);
		this.setTotalAmount(this.totalAmount + hotelReservation.getHotel().getPrice());
	}
	
	@Override
	public void addCarReservation(ICarReservation carReservation) {
		this.carReservations.add(carReservation);
		this.setTotalAmount(this.totalAmount + carReservation.getCar().getPrice());
	}
	
	public static void printTrip(Trip trip) {
		System.out.println("\n\n==========================================================");
		System.out.println("----- Trip Id : " + trip.getTripId() + " -----");
		for(IFlightReservation flightReservation: trip.flightReservations) {
			System.out.println(flightReservation.toString());		
		}
		for(IHotelReservation hotelReservation: trip.hotelReservations) {
			System.out.println(hotelReservation.toString());
		}
		for(ICarReservation carReservation: trip.carReservations) {
			System.out.println(carReservation.toString());
		}
		System.out.println("\n----- Total Amount : $" + trip.totalAmount + " -----");
	}

}
