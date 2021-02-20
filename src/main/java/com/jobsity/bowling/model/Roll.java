package com.jobsity.bowling.model;


public class Roll {

	private int scoreValue;
	
	private String stringValueTemp;
	
	private static final String SPARE = "/";
	
	private static final String STRIKE = "X";
	
	private static final String FOUL = "F";
	
	public Roll(String stringValueTemp) {
		this.stringValueTemp = stringValueTemp;
	}

	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	public String getStringValueTemp() {
		return stringValueTemp;
	}

	public void setStringValueTemp(String stringValueTemp) {
		this.stringValueTemp = stringValueTemp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + scoreValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roll other = (Roll) obj;
		if (scoreValue != other.scoreValue)
			return false;
		return true;
	}
	
	
	
	
}
