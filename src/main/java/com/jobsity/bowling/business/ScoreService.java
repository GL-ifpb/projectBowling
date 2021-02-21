/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business;

import java.util.List;
import java.util.Map;

import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;

public interface ScoreService {

	public Score formatScore(Map<String, List<Roll>> mapPlayersRolls) throws BusinessException;
	
}
