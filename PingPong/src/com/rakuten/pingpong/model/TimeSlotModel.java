package com.rakuten.pingpong.model;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;

public class TimeSlotModel {

	private int minTime;
	private int maxTime;

	public TimeSlotModel(int minTime, int maxTime) throws StandardInvalidTimeSlotException{
		
		if (maxTime-minTime <=0) {
			throw new StandardInvalidTimeSlotException("Invalid time slot "+minTime+"-"+maxTime);
		}
		this.minTime = minTime;
		this.maxTime = maxTime;
	}
	public int getMinTime() {
		return minTime;
	}
	public int getMaxTime() {
		return maxTime;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMinTime());
		sb.append("-");
		sb.append(getMaxTime());
		return sb.toString();
	}
	@Override
	public int hashCode() {
		int code=17;
		code=31*code + minTime+maxTime;
		return code;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this) {
			return true;
		}
		if (!(obj instanceof TimeSlotModel)) {
			return false;
		}
		TimeSlotModel ts= (TimeSlotModel) obj;
		return ts.maxTime==this.maxTime && ts.minTime==this.minTime;
	}
	
}
