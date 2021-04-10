package com.calculator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SampleCalculatorTest extends TestCase
{
	/*public void setUp(){ 
		SampleCalculator calculator = new SampleCalculator();
	}*/
	
	public void testAdd()
	{
		SampleCalculator calculator = new SampleCalculator();
		int result = calculator.add(50 , 20);
		assertEquals(70 , result);
	}
	
	public void testSubtration()
	{
		SampleCalculator calculator = new SampleCalculator();
		int result = calculator.subtration(50 , 20);
		assertEquals(30 , result);	
	}
	
	public static Test suite() {
		return new TestSuite(SampleCalculatorTest.class); 
	}
}
