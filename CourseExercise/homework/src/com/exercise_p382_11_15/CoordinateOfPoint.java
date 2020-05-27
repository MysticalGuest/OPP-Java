package com.exercise_p382_11_15;

public class CoordinateOfPoint {
	
	private double x,y;
	
	public CoordinateOfPoint() {
		this(0.0,0.0);
	}

	public CoordinateOfPoint(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		 return x;
	}
	
	public double getY(){
		 return y;
	}

}

