package com.entity;

public class Circle 
		extends Shape {

	private java.util.Date dateCreated;
	private String name;
	private double radius;
	
	public Circle() {	
	}
	
	public Circle(double radius , String name) {
		
		this.name = name;
		this.radius = radius;
		dateCreated=new java.util.Date();
	}
	
	@Override
	public String toString() {
		return "Shape : " + name + ": Created on " + dateCreated;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getPrimeter() {
		return 2*Math.PI*radius;
	}
	
	public void drawSelf() {
		System.out.println(toString() + "My radius is " + radius);
	}
}
