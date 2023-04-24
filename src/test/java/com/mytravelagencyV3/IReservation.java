/**
 * 
 */
package com.mytravelagencyV3;

/**
 * @author sheetal
 *
 */
public interface IReservation {

	void confirmReservation();
	void cancelReservation();	
	String toString();
	Customer getCustomer();
}
