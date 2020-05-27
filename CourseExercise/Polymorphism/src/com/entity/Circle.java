package com.entity;

public class Circle 
		extends Shape {

	private String name;
	private double radius;
	
	public Circle() {	
	}
	
	public Circle(double radius , String name) {
		this.name = name;
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Shape : " + name;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public void drawSelf() {
		System.out.println(toString() + "My radius is " + radius);
	}
}
