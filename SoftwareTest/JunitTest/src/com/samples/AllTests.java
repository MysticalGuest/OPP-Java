package com.samples;

import junit.framework.*;

/**
 * TestSuite that runs all the sample tests
 *
 */
public class AllTests {

	public static void main (String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	public static Test suite ( ) {
		TestSuite suite= new TestSuite("All JUnit Tests");
		suite.addTest(VectorTest.suite());
		suite.addTest(new TestSuite(com.samples.money.MoneyTest.class));
		suite.addTest(com.tests.AllTests.suite());
	    return suite;
	}
}
