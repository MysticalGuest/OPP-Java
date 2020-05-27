package com.exercise_p382_11_15;

import java.util.Scanner;
import java.util.ArrayList;

public class ConvexPolygonArea {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<CoordinateOfPoint> XandY = new ArrayList<>();
		int numOfPoints;
		double x=0,y=0,area=0,side1,side2,side3,p;
		
		System.out.print("Enter the number of the points: ");
		numOfPoints = input.nextInt();
		
		System.out.println("Enter the coordinates of the points: ");
		for(int i=0 ; i < numOfPoints ; i++){
			x = input.nextDouble();
			y=  input.nextDouble();
			CoordinateOfPoint point = new CoordinateOfPoint(x,y);
			XandY.add(point);
		}
		
		for(int i=0 ; i < numOfPoints-2 ; i++){
			side1 = Math.sqrt(Math.pow(XandY.get(0).getX()-XandY.get(i+1).getX(),2)+Math.pow(XandY.get(0).getY()-XandY.get(i+1).getY(),2));
			side2 = Math.sqrt(Math.pow(XandY.get(0).getX()-XandY.get(i+2).getX(),2)+Math.pow(XandY.get(0).getY()-XandY.get(i+2).getY(),2));
			side3 = Math.sqrt(Math.pow(XandY.get(i+2).getX()-XandY.get(i+1).getX(),2)+Math.pow(XandY.get(i+2).getY()-XandY.get(i+1).getY(),2));
			p=(side1+side2+side3)/2;
			area += Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
		}
		System.out.println("The total area is " + area);
		
		input.close();

	}
}

