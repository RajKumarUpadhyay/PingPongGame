package com.rakuten.pingpong;

import org.junit.Test;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;
import com.rakuten.pingpong.model.PlayerModel;

public class PlayerTest {

	@Test(expected=StandardInvalidTimeSlotException.class)
	public void shouldThrowInvalidTimeSlotException() throws StandardInvalidTimeSlotException {
		new PlayerModel("P1", 10, 9);
	}
	
	@Test
	public void shouldInstantiate() throws StandardInvalidTimeSlotException {
		new PlayerModel("P1", 9, 18);
	}
}
