package com.mytravelagencyV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sheetal
 *
 */

public class Flight {
	
	private String originAirport;
	private String destinationAirport;
	private String departureTimestamp;
	private String arrivalTimestamp;
	private String flightNumber;
	private double price;
	private int noOfStops;

	public Flight( String flightNumber, String originAirport, String destinationAirport, String departureTimestamp, 
			String arrivalTimestamp, int noOfStops, double price) {
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.departureTimestamp = departureTimestamp;
		this.arrivalTimestamp = arrivalTimestamp;
		this.flightNumber = flightNumber;
		this.noOfStops = noOfStops;
		this.price = price;
	}

	public String getOriginAirport() {
		return originAirport;
	}


	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}


	public String getDestinationAirport() {
		return destinationAirport;
	}


	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}


	public String getDepartureTimestamp() {
		return departureTimestamp;
	}


	public void setDepartureTimestamp(String departureTimestamp) {
		this.departureTimestamp = departureTimestamp;
	}


	public String getArrivalTimestamp() {
		return arrivalTimestamp;
	}


	public void setArrivalTimestamp(String arrivalTimestamp) {
		this.arrivalTimestamp = arrivalTimestamp;
	}

	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoOfStops() {
		return noOfStops;
	}

	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}


	public static List<Flight> search(String originAirport, String destinationAirport, String departureDate) {
		
		List<Flight> matchingFlights = new ArrayList<>();
		
		for(Flight flight: flights)
		{
			if(
					flight.getOriginAirport().equalsIgnoreCase(originAirport) 
					&& flight.getDestinationAirport().equalsIgnoreCase(destinationAirport)
					&& flight.getDepartureTimestamp().substring(0, 10).equals(departureDate)
				)
			{
				matchingFlights.add(flight);
			}	
		}
		
		return matchingFlights;
			
	}
	
	public static void printFlightList(List<Flight> flights)
	{
		
		for(Flight flight: flights)
		{
			System.out.println(
					(flights.indexOf(flight) + 1) + " | " +
					flight.getFlightNumber() + " from " +
					flight.getOriginAirport() + " (" +
					flight.getDepartureTimestamp() + ") to " +
					flight.getDestinationAirport() + " (" +
					flight.getArrivalTimestamp() + ") with " +
					flight.getNoOfStops() + " stops, $ " +
					flight.getPrice()
					);
		}		
		
	}
	
	public static void printFlight(Flight flight)
	{
			System.out.println(
					flight.getFlightNumber() + " from " +
					flight.getOriginAirport() + " (" +
					flight.getDepartureTimestamp() + ") to " +
					flight.getDestinationAirport() + " (" +
					flight.getArrivalTimestamp() + ") with " +
					flight.getNoOfStops() + " stops, $ " +
					flight.getPrice()
			);	
		
	}
	
	public static List<Flight> filter(List<Flight> flights, double maxPrice, int maxNoOfStops) {
		
		List<Flight> matchingFlights = new ArrayList<>();
		
		for(Flight flight: flights)
		{
			if(
					flight.getPrice() <= maxPrice
					&& flight.getNoOfStops() <= maxNoOfStops
				)
			{
				matchingFlights.add(flight);
			}	
		}
		
		return matchingFlights;
		
	}
	
	static Flight[] flights = {
		new Flight("AI101", "EWR", "MIA", "2023-05-23T01:00:00.000Z", "2023-05-23T11:00:00.000Z", 1, 111),
		new Flight("AI102", "EWR", "MIA", "2023-05-23T02:00:00.000Z", "2023-05-23T12:00:00.000Z", 2, 222),
		new Flight("AI103", "EWR", "MIA", "2023-05-23T03:00:00.000Z", "2023-05-23T13:00:00.000Z", 3, 333),
		new Flight("AI104", "EWR", "MIA", "2023-05-23T04:00:00.000Z", "2023-05-23T14:00:00.000Z", 4, 444),
		new Flight("AI105", "EWR", "MIA", "2023-05-23T05:00:00.000Z", "2023-05-23T15:00:00.000Z", 5, 555),
		
	};
	
}
