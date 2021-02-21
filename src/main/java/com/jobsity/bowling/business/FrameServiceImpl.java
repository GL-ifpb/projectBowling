/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Roll;

@Service
public class FrameServiceImpl implements FrameService {

	
	public int prepareFrameStrike(int sumFrame, List<Frame> frames, Roll... rolls) {
		
		   Roll currentRoll = rolls[0];
		   Roll nextRoll = rolls[1];
		   Roll nextNextRoll = rolls[2];
		   
		   int sumFrameAux = currentRoll.getScoreValue() + nextRoll.getScoreValue() + nextNextRoll.getScoreValue();
			
		   sumFrame += sumFrameAux;
		   
		   Frame frame = new Frame();				   
		   frame.setSum(sumFrame);
		   
		   populateFrame(frame, false, true, currentRoll);
		   
		   frames.add(frame);
		   
		   return sumFrameAux;
	}
	
	public int prepareFrameStrikeThreeRolls(int sumFrame, List<Frame> frames, Roll... rolls) {
		
		   Roll currentRoll = rolls[0];
		   Roll nextRoll = rolls[1];
		   Roll nextNextRoll = rolls[2];
		   			   
		   int sumFrameAux = currentRoll.getScoreValue() + nextRoll.getScoreValue() + nextNextRoll.getScoreValue();
				  
		   sumFrame += sumFrameAux;
		   
		   Frame frame = new Frame();				   
		   frame.setSum(sumFrame);
		   
		   populateFrame(frame, false, true, currentRoll, nextRoll, nextNextRoll);
		   
		   frames.add(frame);
		   
		   return sumFrameAux;
	}
	
	public int prepareFrameSpare(int sumFrame, List<Frame> frames, Roll... rolls) {
		
		   Roll currentRoll = rolls[0];
		   Roll nextRoll = rolls[1];
		   Roll nextNextRoll = rolls[2];	   		  
			   
		   int sumFrameAux = currentRoll.getScoreValue() + nextRoll.getScoreValue() + nextNextRoll.getScoreValue();
		   
		   sumFrame += sumFrameAux;
		   
		   Frame frame = new Frame();				   
		   frame.setSum(sumFrame);
		   
		   populateFrame(frame, true, false, currentRoll, nextRoll, nextNextRoll);
		   
		   frames.add(frame);
		   
		   return sumFrameAux;
		
	}
	
	public int prepareFrame(int sumFrame, List<Frame> frames, Roll... rolls) {
		
		   Roll currentRoll = rolls[0];
		   Roll nextRoll = rolls[1];
		
		   int sumFrameAux = currentRoll.getScoreValue() + nextRoll.getScoreValue();
		
		   sumFrame += sumFrameAux;
		   
		   Frame frame = new Frame();				   
		   frame.setSum(sumFrame);
		   
		   populateFrame(frame, false, false, currentRoll, nextRoll);
		   
		   frames.add(frame);
		   
		   return sumFrameAux;
		 
	}
	
	private void populateFrame(Frame frame, boolean isSpare, boolean isStrike, Roll... rolls) {
		
		frame.setStrike(isStrike);
		frame.setSpare(isSpare);
		frame.setListRoll(Arrays.asList(rolls));
		
	}
	
}
