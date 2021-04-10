package com.tests;

import junit.framework.*;

/**
 * TestSuite that runs all the JUnit tests
 *
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	
	public static Test suite() {
		TestSuite suite= new TestSuite("Framework Tests");
		suite.addTest(com.tests.framework.AllTests.suite());
		suite.addTest(com.tests.runner.AllTests.suite());
		suite.addTest(com.tests.extensions.AllTests.suite());
		return suite;
	}
}