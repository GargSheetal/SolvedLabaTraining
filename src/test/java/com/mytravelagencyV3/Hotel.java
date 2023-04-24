package com.mytravelagencyV3;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sheetal
 *
 */

public final class Hotel {

	private final String hotelName;
	private final String location;
	private final String roomType;
	private final String availableDate;
	private final double price;
	
	public Hotel(String hotelName, String location, String roomType, String availableDate, double price) {
		
		this.hotelName = hotelName;
		this.location = location;
		this.roomType = roomType;
		this.availableDate = availableDate;
		this.price = price;
	}

	public String getAvailableDate() {
		return availableDate;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public String getLocation() {
		return location;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public static List<Hotel> search(String location, String dateOfStay) {
		
		List<Hotel> matchingHotels = new ArrayList<>();
		
		for(Hotel hotel: hotels)
		{
			if(hotel.getLocation().equalsIgnoreCase(location) && hotel.getAvailableDate().equals(dateOfStay))
			{
				matchingHotels.add(hotel);
			}	
		}
		return matchingHotels;
				
	}
	
	// method to return the stringify version of the hotel object
	@Override
	public final String toString() {
		String s = (
				getHotelName() + " at " +
				getLocation() + " with " +
				getRoomType() + " Room on " +
				getAvailableDate() + " for $" +
				getPrice() + " per night"
		);	
		return s;
	}
	
	public static List<Hotel> filter(List<Hotel> hotels, double maxPrice, String roomType)
	{
		List<Hotel> matchingHotels = new ArrayList<>();
		
		for(Hotel hotel: hotels)
		{
			if(hotel.getPrice() <= maxPrice && hotel.getRoomType().equalsIgnoreCase(roomType))
			{
				matchingHotels.add(hotel);
			}
		}
		return matchingHotels;
	}
	
	
	static Hotel[] hotels = {
			new Hotel("Hilton", "Miami", "Queen", "2023-05-23", 101),
			new Hotel("Hyatt", "Miami", "King", "2023-05-23", 102),
			new Hotel("Marriot", "Miami", "Queen", "2023-05-23", 103),
			new Hotel("Holiday Inn", "Miami", "King", "2023-05-23", 104),
			new Hotel("Hampton Inn", "Miami", "Queen", "2023-05-23", 105),
			new Hotel("Sheraton", "Miami", "Queen", "2023-05-23", 106),
		};
	
	
}
