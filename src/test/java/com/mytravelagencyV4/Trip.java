package com.mytravelagencyV4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trip implements ITrip {

	private String tripId;
	private static double ONLINE_BOOKING_FEE;
	private double totalAmount;
	List<IFlightReservation> flightReservations = new ArrayList<>();
	List<IHotelReservation> hotelReservations = new ArrayList<>();
	List<ICarReservation> carReservations = new ArrayList<>();
	
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
	
	@Override
	public void addFlightReservation(IFlightReservation flightReservation) {
		if(flightReservation != null)
		{
			createTripIfNotExist();
			this.flightReservations.add(flightReservation);
			this.setTotalAmount(this.totalAmount + flightReservation.getFlight().getPrice());
		}
	}
	
	@Override
	public void addHotelReservation(IHotelReservation hotelReservation) {
		if(hotelReservation != null)
		{
			createTripIfNotExist();
			this.hotelReservations.add(hotelReservation);
			this.setTotalAmount(this.totalAmount + hotelReservation.getHotel().getPrice());
		}
	}
	
	@Override
	public void addCarReservation(ICarReservation carReservation) {
		if(carReservation != null)
		{
			createTripIfNotExist();
			this.carReservations.add(carReservation);
			this.setTotalAmount(this.totalAmount + carReservation.getCar().getPrice());
		}
	}
	
	public static void printTrip(Trip trip) {
		System.out.println("\n\n============= Receipt ==============");
		if(trip.getTripId() == null)
		{
			System.out.println("No reservations");
			return;
		}
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
