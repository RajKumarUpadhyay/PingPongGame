package com.rakuten.pingpong;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rakuten.pingpong.exceptions.StandardInvalidTimeSlotException;
import com.rakuten.pingpong.model.TimeSlotModel;

public class TimeSlotTest {

	@Test(expected=StandardInvalidTimeSlotException.class)
	public void shouldThrowInvalidTimeSlotException() throws StandardInvalidTimeSlotException {
		new TimeSlotModel(10, 10);
		new TimeSlotModel(11, 10);
	}
	public void shouldInstantiate() throws StandardInvalidTimeSlotException {
		new TimeSlotModel(9, 10);
	}
	@Test
	public void shouldBeEquals() throws StandardInvalidTimeSlotException {
		TimeSlotModel ts1=new TimeSlotModel(9, 10);
		TimeSlotModel ts2=new TimeSlotModel(9, 10);
		assertTrue(ts1.equals(ts2));
	}

}
