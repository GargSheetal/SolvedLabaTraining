/**
 * 
 */
package com.mytravelagencyV3;

/**
 * @author sheetal
 *
 */
public interface IFlightReservation extends IReservation {
	
	Flight getFlight();
	void setNeedSpecialAssistance(boolean needSpecialAssistance);
	void setNeedMealService(boolean needMealService);
}
