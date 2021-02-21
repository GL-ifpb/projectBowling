/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business.rules;

import org.springframework.stereotype.Component;

import com.jobsity.bowling.model.Roll;

@Component
public class RollRuleImpl implements RollRule {
	
	private String regexRoll = "F|[0-9]|10";
	
	public boolean isSpare(Roll roll, Roll nextRoll) {
		
		return roll.getScoreValue() + nextRoll.getScoreValue() == 10 && !isStrike(roll);
		
	}
	
	public boolean isStrike(Roll roll) {
		
		return roll.getScoreValue() == 10;
		
	}
	
	public boolean isAValidRoll(String valueRoll) {
		
		return valueRoll.matches(regexRoll);
		
	}
	
}
