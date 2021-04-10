package com.stack;

import static org.junit.Assert.assertEquals;

import junit.framework.Test;
import junit.framework.TestSuite;

public class StackTest {

	private MyStack ms;

	public void testPop()
	{
		ms = new MyStack();
		ms.push("zhangsan");
		assertEquals("zhangsan",ms.pop());
	}

	public void testPeek()
	{
		ms = new MyStack();
		ms.push("zhangsan");
		assertEquals("zhangsan",ms.peek());
	}

	public void testEmpty()
	{
		ms = new MyStack();
		ms.push("zhangsan");
		ms.pop();
		assertEquals(true,ms.empty());
	}
	
	public static Test suite() {
		return new TestSuite(StackTest.class); 
	}
}
