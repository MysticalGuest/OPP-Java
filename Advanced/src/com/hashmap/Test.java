package com.hashmap;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("A", 1);
		hashMap.put("A", 2);
		hashMap.put("D", 3);
		hashMap.put("K", 8);
		hashMap.put("I", 6);
		
		System.out.println(hashMap);
		System.out.println(hashMap.get("A"));
		System.out.println(hashMap.get("B"));
		System.out.println(hashMap.containsKey("A"));
		System.out.println(hashMap.containsKey("C"));
		System.out.println(hashMap.containsValue(1));
		System.out.println(hashMap.containsValue(2));
		System.out.println(hashMap.size());
		System.out.println(hashMap.isEmpty());
		
//		Object clone = hashMap.clone();
		HashMap<String, Integer> clone = (HashMap<String, Integer>) hashMap.clone();
		System.out.println(clone);
		System.out.println(clone==hashMap);
		hashMap.put("A", 1);
		System.out.println("hashmap: "+hashMap+"<>clone"+clone);
	}
}
