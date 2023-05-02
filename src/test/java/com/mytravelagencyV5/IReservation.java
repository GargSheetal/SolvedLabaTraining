/**
 * 
 */
package com.mytravelagencyV5;

import com.travelagency.customexceptions.MissingInputException;

/**
 * @author sheetal
 * 
 *
 */
public interface IReservation {

	void confirmReservation() throws MissingInputException;
	void cancelReservation();
	String getReservationId();
	String toString();
	Customer getCustomer();
}
