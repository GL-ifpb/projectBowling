package com.jobsity.bowling.model;

import java.util.List;

public class Game {
	
	private String playerName;
	
	private List<Frame> frames;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	
	

}
