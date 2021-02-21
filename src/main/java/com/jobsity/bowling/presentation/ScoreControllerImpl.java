/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.presentation;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.business.ScoreService;
import com.jobsity.bowling.exceptions.BusinessException;
import com.jobsity.bowling.model.Roll;
import com.jobsity.bowling.model.Score;

@Service
public class ScoreControllerImpl implements ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	private Logger logger = LoggerFactory.getLogger(DataFileControllerImpl.class); 
	
	public Score formatScore(Map<String, List<Roll>> mapPlayersRolls) {
		
		try {
			
			return scoreService.formatScore(mapPlayersRolls);
			
		} catch(BusinessException dataException){
			
			logger.info(dataException.getMessage(), dataException);
			
		}
		
		return null;
		
	}
	
}
