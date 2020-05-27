package com.ExceptionHandling12_4_5;


public class CircleWithException {
	
	private double radius;
	
	private static int numberOfObject = 0;
	
	public CircleWithException() {
		this(1.0);
	}
	
	public CircleWithException(double newRadius) {
		setRadius(newRadius);
		numberOfObject++;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double newRadius) 
			throws IllegalArgumentException{
		if(newRadius >= 0)
			radius = newRadius;
		else
			throw new IllegalArgumentException("Radius cannot be negative!");
	}
	
	public static int getNumberOfObject() {
		return numberOfObject;
	}
	
	public double findArea() {
		return radius * radius * Math.PI;
	}

}

