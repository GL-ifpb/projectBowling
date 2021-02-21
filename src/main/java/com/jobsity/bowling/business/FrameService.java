package com.jobsity.bowling.business;

import java.util.List;

import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Roll;

public interface FrameService {
	
	public int prepareFrameStrike(int sumFrame, List<Frame> frames, Roll... rolls);
	
	public int prepareFrameStrikeThreeRolls(int sumFrame, List<Frame> frames, Roll... rolls);
	
	public int prepareFrameSpare(int sumFrame, List<Frame> frames, Roll... rolls);
	
	public int prepareFrame(int sumFrame, List<Frame> frames, Roll... rolls);

}
