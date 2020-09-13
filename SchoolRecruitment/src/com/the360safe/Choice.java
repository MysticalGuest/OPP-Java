package com.the360safe;

// 一道选择题，判断作用域
public class Choice {

	public static void main(String[] args) {
		Field field = new Field(50);
		System.out.println(field.getNum());
	}
	
}

class Field {
	private int num=90;
	
	public Field(int num) {
		num = num;
	}
	
	public int getNum() {
		return num;
	}
}
