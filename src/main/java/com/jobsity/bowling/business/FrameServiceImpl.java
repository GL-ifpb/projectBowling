package com.jobsity.bowling.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Roll;

@Service
public class FrameServiceImpl implements FrameService {

	
	public void prepareFrame(int sumFrame, List<Frame> frames, boolean isSpare, boolean isStrike, Roll... rolls) {
		
		   Roll currentRoll = rolls[0];
		   Roll nextRoll = rolls[1];
		   Roll nextNextRoll = rolls[2];
		   
		   if(isSpare || isStrike) {
			   
			   sumFrame += currentRoll.getScoreValue() + nextRoll.getScoreValue() + nextNextRoll.getScoreValue();
			   
		   }else {
			   
			   sumFrame += currentRoll.getScoreValue() + nextRoll.getScoreValue();
			   
		   }
		   
		   Frame frame = new Frame();				   
		   frame.setSum(sumFrame);
		   
		   populateFrame(frame, isSpare, isStrike, currentRoll, nextRoll, nextNextRoll);
		   
		   frames.add(frame);
	}
	
	private void populateFrame(Frame frame, boolean isSpare, boolean isStrike, Roll... rolls) {
		
		frame.setStrike(isStrike);
		frame.setSpare(isSpare);
		frame.setListRoll(Arrays.asList(rolls));
		
	}
	
}
