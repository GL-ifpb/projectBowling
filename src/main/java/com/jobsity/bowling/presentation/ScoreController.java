/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.presentation;

import java.util.List;
import java.util.Map;

import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;

public interface ScoreController {
	
	public Score formatScore(Map<String, List<Roll>> mapPlayersRolls);

}
