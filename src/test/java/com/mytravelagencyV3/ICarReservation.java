/**
 * 
 */
package com.mytravelagencyV3;

/**
 * @author sheetal
 *
 */
public interface ICarReservation extends IReservation {
	
	Car getCar();
	void setNeedCarSeat(boolean needCarSeat);
}
