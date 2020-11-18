package com.simpleprogrammer.proteintracker;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techventus.server.voice.Voice;
import com.techventus.server.voice.datatypes.records.SMSThread;

public class IntegrationTest {

	private Voice voice;
	private String userName = "test@email.com";
	private String password = "password";
	private String numberToMessage = "1234567890";
	
	@Before
	public void setUp() throws IOException {
		voice = new Voice(userName, password, numberToMessage);
	}
	
	@Test
	public void GoalMetShouldSendNotification() throws IOException, InvalidGoalException {
		TrackingService service = new TrackingService(new SMSNotifier(userName, password, numberToMessage));
		service.setGoal(50);
		service.addProtein(51);
		
		assertTrue(voice.getSMS().contains("goal met"));
	}
	
	@After
	public void tearDown() throws IOException {
		for (SMSThread thread : voice.getSMSThreads()) {
			voice.deleteMessage(thread.getId());
		}
	}
	
}
