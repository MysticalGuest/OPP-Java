package com.exercise;

public class StringCompare {

	public static void main(String[] args) {
		String s1 = "Hello World";
		String s2 = new String("Hello World");
		String s3 = "Hello World";
		String s4 = "Java Class";
		String s5 = new String("Hello World");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s5);
	    String s6 = s1+s4;
		System.out.println(s6==s1);

	}

}

