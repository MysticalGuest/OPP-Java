package com.entity;

public class Rectangle 
		extends Shape {

	private java.util.Date dateCreated;
	private String name;
	private double width,height;
	
	public Rectangle() {
		//this(1.0,1.0,"Rectangle");
	}
	
	public Rectangle(double width , double height , String name) {
		this.name = name;
		this.width = width;
		this.height = height;
		dateCreated =new java.util.Date();
	}
	
	@Override
	public String toString() {
		return "Shape : " + name + ": Created on " + dateCreated;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPrimeter() {
		return 2*(width+height);
	}
	
	public void drawSelf() {
		System.out.println(toString() + "My width is " + width + " and height is " + height);
	}
}

