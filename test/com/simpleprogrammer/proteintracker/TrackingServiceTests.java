package com.simpleprogrammer.proteintracker;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class TrackingServiceTests {

	private TrackingService service;

	@Before
	public void setUp() {
		System.out.println("Before...");
		service = new TrackingService();
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
