package com.mytravelagencyV3;


/**
 * @author sheetal
 *
 */

public class HotelReservation extends Reservation implements IHotelReservation {


	private final Hotel hotel;
	private boolean needFreeBreakfast;
	private boolean needFreeInternet;

	public HotelReservation(Hotel hotel) {
		
		this.hotel = hotel;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public boolean getNeedFreeBreakfast() {
		return needFreeBreakfast;
	}
	
	@Override
	public void setNeedFreeBreakfast(boolean needFreeBreakfast) {
		this.needFreeBreakfast = needFreeBreakfast;
	}

	public boolean getNeedFreeInternet() {
		return needFreeInternet;
	}

	@Override
	public void setNeedFreeInternet(boolean needFreeInternet) {
		this.needFreeInternet = needFreeInternet;
	}

	@Override
	public void confirmReservation() {
		System.out.println("\n[SYSTEM] - Hotel Reservation Confirmed : ");
		System.out.println(this.hotel.toString());
		
	}

	@Override
	public void cancelReservation() {
		System.out.println("\n[SYSTEM] - Hotel Reservation Canceled !!");
		
	}
	
	// overriding toString method to return stringify version of Hotel Reservation details
	@Override
	public String toString() {
		
		String s = 
				"\nHotel Reservation Id : " + this.getReservationId() + " -----" +
				"\n" + 
				this.hotel.toString() + 
				"\n" + 
					"Customer : " +
				this.customer.getCustomerName() + " | " + 
				this.customer.getCustomerEmail() + " | " +
				this.customer.getCustomerPhone()
				+
				"\n" + 
				"Additional Services : " +
				"\n needFreeBreakfast" + this.getNeedFreeBreakfast() +
				"\n freeInternet" + this.getNeedFreeInternet()
				;
		
		return s;
	}

	
//	public static void printHotelReservation(HotelReservation hotelReservation) {
//		System.out.println("\nHotel Reservation Id : " + hotelReservation.getReservationId() + " -----");
//		Hotel.printHotel(hotelReservation.hotel);
//		System.out.println(
//				"Customer : " + 
//				hotelReservation.customerName + " | " + 
//				hotelReservation.customerEmail + " | " +
//				hotelReservation.customerPhone
//		);
//		System.out.println(
//				"Additional Services : " +
//				"\n freeBreakfast : " + hotelReservation.freeBreakfast +
//				"\n freeInternet : " + hotelReservation.freeInternet
//		);
//	}
	
}
