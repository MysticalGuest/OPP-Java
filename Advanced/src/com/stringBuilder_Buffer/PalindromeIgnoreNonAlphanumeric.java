package com.stringBuilder_Buffer;

import java.util.Scanner;

public class PalindromeIgnoreNonAlphanumeric {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// prompt the user to enter a string
		System.out.println("Enter a string: ");
		String s = input.nextLine();
		
		System.out.println("Ignoring nonalphanumeric characters, \nis "
				+ s + "a palindrome? " + isPalindrome(s));
		
		
		input.close();
	}
	
	/** Return true if a string is a palindrome **/
	public static boolean isPalindrome(String s) {
		// Create a new string by eliminating nonalphanumeric chars
		// 通过消除非字母数字字符来创建新字符串
		String s1 = filter(s);
		
		String s2 = reverse(s1);
		
		return s2.equals(s1);
		
	}
	
	/** Create a new string by eliminating nonalphanumeric chars **/
	/** 通过消除非字母数字字符来创建新字符串 **/
	public static String filter(String s) {
		StringBuilder stringBuilder = new StringBuilder(); // 构建一个容量为16的空字符串构建器
		
		// Examine each char in the string to skip alphanumeric char
		// 检查字符串中的每个字符以跳过字母数字字符
		for (int i = 0; i < s.length(); i++) {
			if(Character.isLetterOrDigit(s.charAt(i))) {
				stringBuilder.append(s.charAt(i));
			}
		}
		
		// Return a new filtered string
		// 返回一个新的过滤字符串
		return stringBuilder.toString();
		
	}
	
	/** Create a new string by reversing a specified string **/
	/** 通过反转指定的字符串来创建新字符串 **/
	public static String reverse(String s) {
		StringBuilder stringBuilder = new StringBuilder(s);
		stringBuilder.reverse(); // Invoke reverse in StringBuilder 在StringBuilder中调用反向
		return stringBuilder.toString();
	}

}

