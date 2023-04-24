package com.mytravelagencyV2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trip {

	private String tripId;
	List<FlightReservation> flightReservations = new ArrayList<>();
	List<HotelReservation> hotelReservations = new ArrayList<>();
	List<CarReservation> carReservations = new ArrayList<>();
	private double totalAmount;
	
	public Trip() {
		this.setTripId();
	}

	public String getTripId() {
		return tripId;
	}

	private void setTripId() {
		UUID uuid = UUID.randomUUID();
		this.tripId = uuid.toString();
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	private void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void addFlightReservation(FlightReservation flightReservation) {
		this.flightReservations.add(flightReservation);
		this.setTotalAmount(this.totalAmount + flightReservation.getFlight().getPrice());
	}
	
	public void addHotelReservation(HotelReservation hotelReservation) {
		this.hotelReservations.add(hotelReservation);
		this.setTotalAmount(this.totalAmount + hotelReservation.getHotel().getPrice());
	}
	
	public void addCarReservation(CarReservation carReservation) {
		this.carReservations.add(carReservation);
		this.setTotalAmount(this.totalAmount + carReservation.getCar().getPrice());
	}
	
	public static void printTrip(Trip trip) {
		System.out.println("\n\n==========================================================");
		System.out.println("----- Trip Id : " + trip.tripId + " -----");
		for(FlightReservation flightReservation: trip.flightReservations) {
			System.out.println(flightReservation.toString());
//			FlightReservation.printFlightReservation(flightReservation);
		}
		for(HotelReservation hotelReservation: trip.hotelReservations) {
			HotelReservation.printHotelReservation(hotelReservation);
		}
		for(CarReservation carReservation: trip.carReservations) {
			CarReservation.printCarReservation(carReservation);
		}
		System.out.println("\n----- Total Amount : $" + trip.totalAmount + " -----");
	}

}
