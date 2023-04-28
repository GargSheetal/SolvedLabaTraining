package com.mytravelagencyV4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.travelagency.customexceptions.InvalidStateException;

/**
 * @author sheetal
 *
 */

public final class Flight {
	
	private final String originAirport;
	private final String destinationAirport;
	private final String departureTimestamp;
	private final String arrivalTimestamp;
	private final String flightNumber;
	private final double price;
	private final int noOfStops;
	
	public Map<Seat, String> seatOccupancyMap = new HashMap<>();
	private static final Logger logger = LogManager.getLogger(Flight.class);
	
	public Flight( String flightNumber, String originAirport, String destinationAirport, String departureTimestamp, 
			String arrivalTimestamp, int noOfStops, double price) {
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.departureTimestamp = departureTimestamp;
		this.arrivalTimestamp = arrivalTimestamp;
		this.flightNumber = flightNumber;
		this.noOfStops = noOfStops;
		this.price = price;
		this.seatOccupancyMap.put(new Seat("A1"), "mg@gmail.com");
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public String getDepartureTimestamp() {
		return departureTimestamp;
	}

	public String getArrivalTimestamp() {
		return arrivalTimestamp;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public double getPrice() {
		return price;
	}

	public int getNoOfStops() {
		return noOfStops;
	}

	public static List<Flight> search(String originAirport, String destinationAirport, String departureDate) {
		
		List<Flight> matchingFlights = new ArrayList<>();
		
		for(Flight flight: readFlightsFromCsv(new File("./src/test/resources/com/mytravelagency/testdata/flightsData.csv")))
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
	
	@Override
	public boolean equals(Object o)
	{
		if(o == this)
		{
			return true;
		}
		if(!(o instanceof Flight))
		{
			return false;
		}
		
		Flight f = (Flight)o;
		return Objects.equals(originAirport, f.originAirport) &&
				Objects.equals(destinationAirport, f.destinationAirport) &&
				Objects.equals(departureTimestamp, f.departureTimestamp) &&
				Objects.equals(arrivalTimestamp, f.arrivalTimestamp) &&
				Objects.equals(flightNumber, f.flightNumber) &&
				Objects.equals(price, f.price) &&
				Objects.equals(noOfStops, f.noOfStops);
		
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(originAirport, destinationAirport, departureTimestamp, arrivalTimestamp, flightNumber, price, noOfStops);
    }
	
	// method to return the stringify version of the flight object
	@Override
	public final String toString() {
		String s = (
				getFlightNumber() + " from " +
				getOriginAirport() + " (" +
				getDepartureTimestamp() + ") to " +
				getDestinationAirport() + " (" +
				getArrivalTimestamp() + ") with " +
				getNoOfStops() + " stops, $ " +
				getPrice()
		);	
		return s;
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
	
	public void addSeatOccupancy(Seat seat, String customerEmail) throws InvalidStateException {
        
		if (seatOccupancyMap.containsKey(seat)) {
            throw new InvalidStateException(seat.toString() + " is occupied!");
        } else {
            seatOccupancyMap.put(seat, customerEmail);
        }
    }
	
	public static List<Flight> readFlightsFromCsv(File file) {
	    List<Flight> flights = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;

	        while ((line = reader.readLine()) != null) {
	            String[] values = line.split(",");

	            String flightNumber = values[0];
	            String origin = values[1];
	            String destination = values[2];
	            String departureTime = values[3];
	            String arrivalTime =values[4];
	            int noOfStops = Integer.parseInt(values[5]);
	            double price = Double.parseDouble(values[6]);

	            Flight flight = new Flight(flightNumber, origin, destination, departureTime, arrivalTime, noOfStops, price);
	            flights.add(flight);
	        }

	    } catch (IOException e) {
	    	System.out.println("Error while fetching Flight List: " + e.getMessage());
	        logger.fatal("Error while fetching Flight List: {}", e.getMessage());
	        System.exit(1);
	    }

	    return flights;
	}
}
