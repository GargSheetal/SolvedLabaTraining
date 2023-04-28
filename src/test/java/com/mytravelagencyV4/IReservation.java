/**
 * 
 */
package com.mytravelagencyV4;

import com.travelagency.customexceptions.MissingInputException;

/**
 * @author sheetal
 *
 */
public interface IReservation {

	void confirmReservation() throws MissingInputException;
	void cancelReservation();
	String getReservationId();
	String toString();
	Customer getCustomer();
}
