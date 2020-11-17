package com.simpleprogrammer.proteintracker;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TrackingServiceTests {

	private TrackingService service;

	@BeforeClass
	public static void before() {
		System.out.println("Before Class...");
	}

	@AfterClass
	public static void after() {
		System.out.println("After Class...");
	}

	@Before
	public void setUp() {
		System.out.println("Before...");
		service = new TrackingService(new NotifierStub());
	}

	@After
	public void tearDown() {
		System.out.println("After...");
	}

	@Test
	@Category({GoodTestsCategory.class, BadCategory.class})
	public void testNewTrackingServiceTotalIsZero() {
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}

	@Test
//	@Ignore
	@Category(GoodTestsCategory.class)
	public void testWhenAddingProteinTotalIncreaseByThatAmount() {
		service.addProtein(10);
//		assertEquals("Protein amount was not correct", 10, service.getTotal());
//		assertThat(service.getTotal(), is(10));
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}

	@Test
	@Category(GoodTestsCategory.class)
	public void testWhenRemovingProteinTotalRemainsZero() {
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Test
	public void testWhenGoalIsMetHistoryIsUpdated() throws InvalidGoalException {
		
		Mockery context = new Mockery();
		final Notifier mockNotifier = context.mock(Notifier.class);
		service = new TrackingService(mockNotifier);
		
		context.checking(new Expectations() {{
			oneOf(mockNotifier).send("goal met");
			will(returnValue(true));
		}});
		
		service.setGoal(5);
		service.addProtein(6);
		
		HistoryItem result = service.getHistory().get(1);
		assertEquals("sent: goal met", result.getOperation());
		
		context.assertIsSatisfied();
	}

	@Test //(expected = InvalidGoalException.class)
	public void testWhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException {
		InvalidGoalException thrown = assertThrows(
				InvalidGoalException.class, 
				() -> service.setGoal(-5));
		assertEquals("Goal was less than zero!", thrown.getMessage());
	}

	@Test(timeout = 3000)
	public void badTest() {
		for (int i = 0; i < 1000; i++) {
			service.addProtein(1);
		}
	}
	
}
