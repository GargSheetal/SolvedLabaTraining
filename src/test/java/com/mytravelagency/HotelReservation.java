package com.mytravelagency;

import java.time.LocalDate;

public class HotelReservation extends Reservation {

	private String hotelName;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private String roomType;
	private boolean addBreakfastService;
	
	public HotelReservation(String hotelName, LocalDate checkInDate, LocalDate checkOutDate, String roomType, double price) {
		super(price);
		this.setHotelName(hotelName);
		this.setCheckInDate(checkInDate);
		this.setCheckOutDate(checkOutDate);
		this.setRoomType(roomType);
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean getAddBreakfastService() {
		return addBreakfastService;
	}

	public void setAddBreakfastService(boolean addBreakfastService) {
		this.addBreakfastService = addBreakfastService;
	}

	@Override
	public void confirmReservation() {
		
		System.out.println(String.format("Hotel %s is booked from %s to %s for room type %s at a price of $%s",
				hotelName, checkInDate, checkOutDate.toString(), roomType, this.getPrice()));
		System.out.println("Hotel Reservation Confirmed !!");
		
	}

	@Override
	public void cancelReservation() {
		System.out.println("Hotel Reservation Canceled !!");
		
	}
	
	
	
	
	
	
	
}
