package com.simpleprogrammer.proteintracker;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackingServiceTests {

	@Test
	public void testNewTrackingServiceTotalIsZero() {
		TrackingService service = new TrackingService();
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}

}
