package com.jobsity.bowling.business.rules;

import org.springframework.stereotype.Service;

import com.jobsity.bowling.model.Roll;

@Service
public class RollRuleImpl implements RollRule {
	
	public boolean isSpare(Roll roll) {
		
		return roll.getStringValueTemp().equals(Roll.SPARE) ? true : false;
		
	}
	
	public boolean isStrike(Roll roll) {
		
		return roll.getStringValueTemp().equals(Roll.STRIKE) ? true : false;
		
	}
	
}
