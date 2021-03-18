package com.huawei;

public class test {

	public static void main(String[] args) {
		
		/**
		 * 	CharSequence与String都能用于定义字符串，
		 * 	但CharSequence的值是可读可写序列，而String的值是只读序列
		 */
		CharSequence str = "hello world";
	    CharSequence sub = str.subSequence(6,11);
	    System.out.println("str.subSequence(6,11): " + sub);
		
		StringBuilder stringBuilder = new StringBuilder("abc");
		
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
		stringBuilder.append(false);
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
//		System.out.println(stringBuilder==stringBuilder);
	}
}
