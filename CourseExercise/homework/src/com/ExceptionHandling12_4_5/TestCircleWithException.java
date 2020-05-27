package com.ExceptionHandling12_4_5;

public class TestCircleWithException {
	public static void main(String[] args) {
		try {
			CircleWithException c1 = new CircleWithException(5);
			CircleWithException c2 = new CircleWithException(0);
			CircleWithException c3 = new CircleWithException(-5);
			CircleWithException c4 = new CircleWithException(2);
		}
		catch(IllegalArgumentException ex) {
			System.out.println(ex);
		}
		
		System.out.println("Number of objects created:" + CircleWithException.getNumberOfObject());
		System.out.println();
	}

}

