package com.mytravelagencyV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sheetal
 *
 */

public class Hotel {

	private String hotelName;
	private String location;
	private String roomType;
	private String availableDate;
	private double price;
	
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

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	

	public static List<Hotel> search(String dateOfStay, String location) {
		
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
	
	public static void printHotelList(List<Hotel> hotels)
	{
		for(Hotel hotel: hotels)
		{
			System.out.println(
					(hotels.indexOf(hotel) + 1) + " | " +
					hotel.getHotelName() + " at " +
					hotel.getLocation() + " with " +
					hotel.getRoomType() + " room on " +
					hotel.getAvailableDate() + ", $" +
					hotel.getPrice()
					);
		}
		
	}
	
	public static void printHotel(Hotel hotel)
	{
		System.out.println(
				hotel.getHotelName() + " at " +
				hotel.getLocation() + " with " +
				hotel.getRoomType() + " room on " +
				hotel.getAvailableDate() + ", $" +
				hotel.getPrice()
				);
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
