package com.jobsity.bowling.model;

import java.util.List;

public class Frame {
	
	private List<Roll> listRoll;
	
	private int sum;
	
	private boolean isSpare;
	
	private boolean isStrike;

	public List<Roll> getListRoll() {
		return listRoll;
	}

	public void setListRoll(List<Roll> listRoll) {
		this.listRoll = listRoll;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public boolean isSpare() {
		return isSpare;
	}

	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}

	public boolean isStrike() {
		return isStrike;
	}

	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}
	
	

}
