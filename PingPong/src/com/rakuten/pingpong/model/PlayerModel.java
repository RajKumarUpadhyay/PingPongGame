package com.rakuten.pingpong.model;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;

public class PlayerModel {

	private String name;
	private TimeSlotModel timeSlotModel;

	public PlayerModel(String name, int startTime, int endTime) throws StandardInvalidTimeSlotException{
		this.name = name;
		this.timeSlotModel = new TimeSlotModel(startTime, endTime);
	}

	public String getName() {
		return name;
	}

	public TimeSlotModel getTimeSlot() {
		return timeSlotModel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" ");
		sb.append(getTimeSlot());
		return sb.toString();
	}
	@Override
	public int hashCode() {
		int code = 31 * (timeSlotModel.hashCode() + name.hashCode());
		return code;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this) {
			return true;
		}
		if (!(obj instanceof PlayerModel)) {
			return false;
		}
		PlayerModel p= (PlayerModel) obj;
		return p.getTimeSlot().equals(this.getTimeSlot()) && p.getName().equalsIgnoreCase(this.getName());
	}
}
