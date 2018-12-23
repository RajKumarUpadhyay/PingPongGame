package com.rakuten.pingpong.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;
import com.rakuten.pingpong.pojo.Matches;

public class PingPong {

	private HashMap<TimeSlotModel, HashSet<PlayerModel>> mapOfficeTimeSlot;

	public PingPong(TimeSlotModel timeSlotModel, PlayerModel[] playersModel) throws StandardInvalidTimeSlotException {
		mapOfficeTimeSlot = new HashMap<>();
		for (int i = timeSlotModel.getMinTime(); i < timeSlotModel.getMaxTime(); i++) {

			mapOfficeTimeSlot.put(new TimeSlotModel(i, i + 1), new HashSet<>());
		}
		for (int i = 0; i < playersModel.length; i++) {
			PlayerModel p = playersModel[i];
			for (int j = p.getTimeSlot().getMinTime(); j < p.getTimeSlot().getMaxTime(); j++) {
				TimeSlotModel ts = new TimeSlotModel(j, j + 1);
				mapOfficeTimeSlot.get(ts).add(p);
			}
		}
	}

	public HashMap<TimeSlotModel, HashSet<PlayerModel>> getPlayersAvailibilityMap() {
		return mapOfficeTimeSlot;
	}

	public Matches calculateMatches() {
		int countSingles = 0;
		int countDoubles = 0;
		Iterator<TimeSlotModel> iterator = mapOfficeTimeSlot.keySet().iterator();
		while (iterator.hasNext()) {
			TimeSlotModel timeSlotModel = (TimeSlotModel) iterator.next();
			int size = mapOfficeTimeSlot.get(timeSlotModel).size();
			if (size >= 4) {
				countDoubles++;
			} else if (size > 1 && size < 4) {
				countSingles++;
			}
		}
		return new Matches(countSingles, countDoubles);
	}

}
