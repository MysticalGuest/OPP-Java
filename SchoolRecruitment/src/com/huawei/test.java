package com.huawei;

public class test {

	public static void main(String[] args) {
		
		StringBuilder stringBuilder = new StringBuilder("abc");
		
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
		stringBuilder.append(false);
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.capacity());
//		System.out.println(stringBuilder==stringBuilder);
	}
}
