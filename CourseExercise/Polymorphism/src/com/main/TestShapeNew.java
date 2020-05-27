package com.main;

//import java.util.ArrayList;
import com.entity.*;

public class TestShapeNew {

	public static void main(String[] args) {
//		ArrayList<TestShape> shapes = new ArrayList<>();
		Shape[] shapes = new Shape[10];
		
		CreateShape(shapes);

		PrintShape(shapes);
	}
	
	public static void CreateShape(Shape s[]) {
		for(int i=0;i<s.length;i++)
			if(Math.random()>0.5)
				s[i]=new Circle(i,"Circle"+i);
			else
				s[i]=new Rectangle(i,i,"Rectangle"+i);
	}
	
	public static void PrintShape(Shape s[]) {
		for(int i=0;i<s.length;i++)
			System.out.println(s[i].toString());
	}

}

