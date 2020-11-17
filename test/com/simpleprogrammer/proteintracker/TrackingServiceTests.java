package com.simpleprogrammer.proteintracker;

import org.junit.Test;
import static org.junit.Assert.*;

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
		service = new TrackingService();
	}

	@After
	public void tearDown() {
		System.out.println("After...");
	}
	
	@Test
	public void testNewTrackingServiceTotalIsZero() {
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}

	@Test
	public void testWhenAddingProteinTotalIncreaseByThatAmount() {
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}

	@Test
	public void testWhenRemovingProteinTotalRemainsZero() {
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}

}
