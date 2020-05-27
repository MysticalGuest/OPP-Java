package com.main;

import com.entity.*;

public class TestShape {

	public static void main(String[] args) {
		Shape  [] shape = new Shape[10];
		CreateShape(shape);
		Draw(shape);
	}

	public static void CreateShape(Shape s[]) {
		for(int i=0 ; i<s.length ; i++) {
			if(Math.random()<0.5)
				s[i] = new Circle(i,"Circle"+i);
			else
				s[i] = new Rectangle(i,i,"Rectangle"+i);
		}
	}
	public static void Draw(Shape s[]) {
		int i=0;
		for(Shape e:s) {
			System.out.println(e);
			s[i].drawSelf();
			i++;
		}
	}
}

