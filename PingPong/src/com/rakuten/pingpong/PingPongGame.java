package com.rakuten.pingpong;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;
import com.rakuten.pingpong.model.PingPong;
import com.rakuten.pingpong.model.PlayerModel;
import com.rakuten.pingpong.model.TimeSlotModel;
import com.rakuten.pingpong.pojo.Matches;

public class PingPongGame {

	public static void main(String[] args) {
		try{
			
			//Q1
//			PlayerModel[] playersModel = {
//					new PlayerModel("P1", 9, 10),
//					new PlayerModel("P2", 9, 12)
//			};

//			//Q2
//			PlayerModel[] playersModel = {
//					new PlayerModel("P1", 9, 10),
//					new PlayerModel("P2", 9, 12),
//					new PlayerModel("P3", 13, 15),
//					new PlayerModel("P4", 10, 18),
//			};
			
//			//Q3
//			PlayerModel[] playersModel = {
//					new PlayerModel("P1", 9, 11),
//					new PlayerModel("P2", 12, 14),
//					new PlayerModel("P3", 13, 15),
//					new PlayerModel("P4", 11, 18),
//					new PlayerModel("P5", 14, 18),
//					new PlayerModel("P6", 10, 14),
//					new PlayerModel("P7", 15, 18),
//			};
				
				//Q4
				PlayerModel[] playersModel = {
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

//				//Q5
//				PlayerModel[] playersModel = {
//						new PlayerModel("P1", 9, 14),
//						new PlayerModel("P2", 15, 17),
//						new PlayerModel("P3", 12, 13),
//						new PlayerModel("P4", 16, 18),
//						new PlayerModel("P5", 10, 15),
//						new PlayerModel("P6", 14, 16),
//						new PlayerModel("P7", 9, 13),
//						new PlayerModel("P8", 9, 15),
//				};	
			
			TimeSlotModel officeTimeSlot = new TimeSlotModel(9, 18);
			PingPong pingPong = new PingPong(officeTimeSlot, playersModel);
			Matches matches = pingPong.calculateMatches();
			
			System.out.println("INPUT");
			System.out.println(playersModel.length);
			
			for (PlayerModel player : playersModel) {
				System.out.println(player);
			}
			
			System.out.println("\nOUTPUT");
			System.out.println(matches.getSingles() + " " + matches.getDoubles());
			
			} catch (StandardInvalidTimeSlotException e) {
				System.out.println(e.getMessage());
			}
	}
}
