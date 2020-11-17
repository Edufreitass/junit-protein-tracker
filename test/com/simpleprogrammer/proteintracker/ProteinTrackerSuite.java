package com.simpleprogrammer.proteintracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	HelloJUnitTest.class, 
	TrackingServiceTests.class
	})
public class ProteinTrackerSuite {

}
