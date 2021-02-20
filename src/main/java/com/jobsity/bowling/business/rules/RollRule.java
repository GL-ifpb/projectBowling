package com.jobsity.bowling.business.rules;

import com.jobsity.bowling.model.Roll;

public interface RollRule {
	
	public boolean isSpare(Roll roll);
	
	public boolean isStrike(Roll roll);

}
