/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business.rules;

import com.jobsity.bowling.model.Roll;

public interface RollRule {
	
	public boolean isSpare(Roll roll, Roll nextRoll);
	
	public boolean isStrike(Roll roll);
	
	public boolean isAValidRoll(String valueRoll);

}
