/**
 * 
 */
package com.mytravelagencyV4;

/**
 * @author sheetal
 *
 */
public interface IHotelReservation extends IReservation {
	
	Hotel getHotel();
	void setNeedFreeBreakfast(boolean needFreeBreakfast);
	void setNeedFreeInternet(boolean needFreeInternet);
}
