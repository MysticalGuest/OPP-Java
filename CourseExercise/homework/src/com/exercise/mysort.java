package com.exercise;

import java.util.Scanner;

// P214_7_34
public class mysort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a string:");
		String s = input.next(); 
		System.out.print("The sorted string is " + sort(s));
		input.close();

	}
	public static String sort(String s){
		String s1="";
		char [] a=new char[s.length()];
		char temp;
		for(int i=0 ; i<s.length(); i++ )
			a[i]=s.charAt(i);
		for(int i=0 ; i<s.length(); i++ )
			for(int j=0 ; j<s.length()-i-1; j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		for(int i=0 ; i<s.length(); i++ )
			s1=s1+a[i];
		return s1;
	}


}
