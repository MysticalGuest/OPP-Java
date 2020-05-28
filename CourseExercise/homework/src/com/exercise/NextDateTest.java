package com.exercise;

import java.util.Scanner;

public class NextDateTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		int year;
//		int month;
//		int day;
		System.out.print("请输入年份:");
		int year = input.nextInt();
		System.out.print("请输入月份:");
		int month =input.nextInt();
		System.out.print("请输入日期:");
		int day = input.nextInt();
		input.close();
//		int year=2010;
//		int month=2;
//		int day=28;
		if(NextDate(year,month,day)) {
			if((day==28&&month==2&&!isLeap(year))||(day==29&&month==2&&isLeap(year))) {
				day=1;
				month=3;
			}
			else if((day==30&&monthType(month))||(day==31&&!monthType(month))) {
				day=1;
				month++;
			}
			else day++;
			if(month>12) {
				month=1;
				++year;
			}
			System.out.println("Next date is:"+year+"-"+month+"-"+day);
		}
		else System.out.println("无效输入日期");

	}
	
	static boolean NextDate(int y,int m,int d) {
		if(d<1||d>31) {
//			System.out.println("无效输入日期");
			return false;
		}
		else if(m<1||m>12) {
//			System.out.println("无效输入日期");
			return false;
		}
		else if(y<1812||y>2012) {
//			System.out.println("无效输入日期");
			return false;
		}
		else return true;
			
	}
	
	static boolean isLeap(int y) {
		if((y%4==0&&y%100==0)||y%400==0)
			return true;
		return false;
	}
	
	static boolean monthType(int m) {
		if(m==4||m==6||m==9||m==11)
			return true;
		else
			return false;
	}
}
