package com.jobsity.bowling.business.rules;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.model.Roll;

@Component
public class RollRuleImpl implements RollRule {
	
	public boolean isSpare(Roll roll, Roll nextRoll) {
		
		return roll.getScoreValue() + nextRoll.getScoreValue() == 10;
		
	}
	
	public boolean isStrike(Roll roll) {
		
		return roll.getScoreValue() == 10;
		
	}
	
}
