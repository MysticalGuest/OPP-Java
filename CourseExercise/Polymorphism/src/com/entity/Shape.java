package com.entity;

public abstract class Shape {
	private String name;
	
	public Shape() {
		this("nunamed");
	}
	
	public Shape(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Shape : " + name;
	}
	
	public abstract void drawSelf();
	public abstract double getArea();

}

