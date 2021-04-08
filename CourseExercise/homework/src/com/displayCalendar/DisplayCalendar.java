package com.displayCalendar;

import java.util.Scanner;

public class DisplayCalendar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("请输入年份：");
		int year=input.nextInt();
		System.out.print("请输入代表该年第一天是星期几的数字：");
		int num=input.nextInt();
		int t,j,row1=0,row2=0;
		for(int i=1;i<=12;i++) {
		switch(i) {
		case 1:System.out.println("\t\tJanuary "+year);break;
		case 2:System.out.println("\t\tFebruary "+year);break;
		case 3:System.out.println("\t\tMarch "+year);break;
		case 4:System.out.println("\t\tApril "+year);break;
		case 5:System.out.println("\t\tMay "+year);break;
		case 6:System.out.println("\t\tJune "+year);break;
		case 7:System.out.println("\t\tJuly "+year);break;
		case 8:System.out.println("\t\tAugust "+year);break;
		case 9:System.out.println("\t\tSeptember "+year);break;
		case 10:System.out.println("\t\tOctober "+year);break;
		case 11:System.out.println("\t\tNovember "+year);break;
		case 12:System.out.println("\t\tDecember "+year);break;
		}
		headline();
		if((i==1)||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12)) {
		for(j=1;j<=num;j++) {
		System.out.printf("\t");
		}
		for(int k=1;k<=31;k++) {
		t=k+j-1;
		System.out.print(k+"\t");
		if(t%7==0) {
		if(k!=31) {
		System.out.printf("\n");
		row1++;
		}
		}
		}
		if(row1==4) {
		num=num+3;
		if(num==7)
		num=0;
		}
		else
		num=num-4;
		}
		else if((i==4)||(i==6)||(i==9)||(i==11)){
		for(j=1;j<=num;j++) {
		System.out.printf("\t");
		}
		for(int k=1;k<=30;k++) {
		t=k+j-1;
		System.out.print(k+"\t");
		if(t%7==0) {
		if(k!=30) {
		System.out.printf("\n");
		row2++;
		}
		}
		}
		if(row2==4) {
		num=num+2;
		if(num==7)
		num=0;
		}
		else
		num=1;
		}
		else if((i==2)&&((year%4==0&&year%100!=0)||(year%400==0))) {
		for(j=1;j<=num;j++) {
		System.out.printf("\t");
		}
		for(int k=1;k<=29;k++) {
		t=k+j-1;
		System.out.print(k+"\t");
		if(t%7==0)
		System.out.printf("\n");
		}
		num++;
		}
		else{
		for(j=1;j<=num;j++) {
		System.out.printf("\t");
		}
		for(int k=1;k<=28;k++) {
		t=k+j-1;
		System.out.print(k+"\t");
		if(t%7==0)
		System.out.printf("\n");
		}
		}
		row1=0;
		row2=0;
		System.out.print("\n");
		}
		}
		public static void headline() {
		for(int i=0;i<50;i++){
		System.out.print("_");
		}
		System.out.print("\n");
		for(int i=0;i<7;i++) {
		switch(i) {
		case 0:System.out.print("Sun\t");break;
		case 1:System.out.print("Mon\t");break;
		case 2:System.out.print("Tue\t");break;
		case 3:System.out.print("Wed\t");break;
		case 4:System.out.print("Thu\t");break;
		case 5:System.out.print("Fri\t");break;
		case 6:System.out.print("Sat\t");break;
		}
		}
		System.out.print("\n");
		}
}
