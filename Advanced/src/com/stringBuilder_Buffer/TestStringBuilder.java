package com.stringBuilder_Buffer;

public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder();
		s1.append("Welcome");
		s1.append(" ");
		s1.append("to java",0,2); // 追加一个字符数组中的子数组到字符串构建器
		
		// 将一个基本类型的值作为字符串追加到字符串构造器
		s1.append(2);
		s1.append(true);
		s1.append(2.33e-3);
		s1.append('s');
		
		System.out.println(" s1.capacity(): " + s1.capacity());
		System.out.println(" s1: " + s1);
		System.out.println(" s1.replace(): " + s1.replace(1, 3, "NEW"));
		System.out.println(" s1.reverse(): " + s1.reverse());
		System.out.println(" s1.reverse().replace(): " + s1.replace(1, 3, "NEW"));

	}

}

