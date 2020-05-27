package com.entity;

public abstract class Shape {
	private String name;
	private java.util.Date dateCreated;
	
	public Shape() {
		this("nunamed");
	}
	
	public Shape(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Shape : " + name + "Created on " + dateCreated;
	}
	
	public abstract void drawSelf();
	public abstract double getArea();

}

