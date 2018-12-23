package com.rakuten.pingpong;

import org.junit.Test;
import static org.junit.Assert.*;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;
import com.rakuten.pingpong.model.PingPong;
import com.rakuten.pingpong.model.PlayerModel;
import com.rakuten.pingpong.model.TimeSlotModel;
import com.rakuten.pingpong.pojo.Matches;

public class PingPongTest {

	@Test
	public void shouldCreatePlayersAvailibilityMap() throws StandardInvalidTimeSlotException {
				
				//Q2
				PlayerModel[]players = new PlayerModel[]{
						new PlayerModel("P1", 9, 10),
						new PlayerModel("P2", 9, 12),
						new PlayerModel("P3", 13, 15),
						new PlayerModel("P4", 10, 18),
				};
				TimeSlotModel officeTimeSlot = new TimeSlotModel(9, 18);
				PingPong pingPong = new PingPong(officeTimeSlot, players);
				assertEquals(officeTimeSlot.getMaxTime()-officeTimeSlot.getMinTime(), pingPong.getPlayersAvailibilityMap().size());
	}
	@Test
	public void shouldCalculateMatches() throws StandardInvalidTimeSlotException {
		TimeSlotModel officeTimeSlot = new TimeSlotModel(9, 18);
		//Q1
		PlayerModel[] players = {
				new PlayerModel("P1", 9, 10),
				new PlayerModel("P2", 9, 12)
		};
		PingPong pingPong = new PingPong(officeTimeSlot, players);
		Matches matches = pingPong.calculateMatches();
		assertEquals(1, matches.getSingles());
		assertEquals(0, matches.getDoubles());
		
		
		//Q2
		players = new PlayerModel[]{
				new PlayerModel("P1", 9, 10),
				new PlayerModel("P2", 9, 12),
				new PlayerModel("P3", 13, 15),
				new PlayerModel("P4", 10, 18),
		};
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(5, matches.getSingles());
		assertEquals(0, matches.getDoubles());
		
		//Q3
		players = new PlayerModel[]{
				new PlayerModel("P1", 9, 11),
				new PlayerModel("P2", 12, 14),
				new PlayerModel("P3", 13, 15),
				new PlayerModel("P4", 11, 18),
				new PlayerModel("P5", 14, 18),
				new PlayerModel("P6", 10, 14),
				new PlayerModel("P7", 15, 18),
		};
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(7, matches.getSingles());
		assertEquals(1, matches.getDoubles());
		
		//Q4
		players = new PlayerModel[]{
					new PlayerModel("P1", 9, 10),
					new PlayerModel("P2", 9, 12),
					new PlayerModel("P3", 14, 15),
					new PlayerModel("P4", 16, 18),
					new PlayerModel("P5", 14, 18),
					new PlayerModel("P6", 10, 13),
					new PlayerModel("P7", 15, 18),
					new PlayerModel("P8", 10, 14),
					new PlayerModel("P9", 9, 13),
			};	
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(6, matches.getSingles());
		assertEquals(2, matches.getDoubles());
		
		//Q5
		players = new PlayerModel[]{
					new PlayerModel("P1", 9, 14),
					new PlayerModel("P2", 15, 17),
					new PlayerModel("P3", 12, 13),
					new PlayerModel("P4", 16, 18),
					new PlayerModel("P5", 10, 15),
					new PlayerModel("P6", 14, 16),
					new PlayerModel("P7", 9, 13),
					new PlayerModel("P8", 9, 15),
			};
		pingPong = new PingPong(officeTimeSlot, players);
		matches = pingPong.calculateMatches();
		assertEquals(5, matches.getSingles());
		assertEquals(3, matches.getDoubles());
	}

}
