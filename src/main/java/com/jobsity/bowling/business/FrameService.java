package com.jobsity.bowling.business;

import java.util.List;

import com.jobsity.bowling.model.Frame;
import com.jobsity.bowling.model.Roll;

public interface FrameService {
	
	public void prepareFrame(int sumFrame, List<Frame> frames, boolean isSpare, boolean isStrike, Roll... rolls);

}
