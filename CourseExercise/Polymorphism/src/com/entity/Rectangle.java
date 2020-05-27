package com.entity;

public class Rectangle 
		extends Shape {

	private String name;
	private double width,height;
	
	public Rectangle() {
		//this(1.0,1.0,"Rectangle");
	}
	
	public Rectangle(double width , double height , String name) {
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Shape : " + name;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public void drawSelf() {
		System.out.println(toString() + "My width is " + width + " and height is " + height);
	}
}

