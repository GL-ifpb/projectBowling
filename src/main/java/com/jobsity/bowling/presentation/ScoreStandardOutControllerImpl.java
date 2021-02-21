package com.jobsity.bowling.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsity.bowling.business.ScoreStandardOutService;
import com.jobsity.bowling.model.Score;

@Service
public class ScoreStandardOutControllerImpl implements ScoreStandardOutController {

	@Autowired
	ScoreStandardOutService scoreStandardOutService;
	
	public String printToStandardOutput(Score score) {
		
		return scoreStandardOutService.printToStandardOutput(score)	;
		
	}
	
}
