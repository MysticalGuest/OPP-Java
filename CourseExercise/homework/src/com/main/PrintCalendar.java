package com.main;

import java.util.Scanner;
public class PrintCalendar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter full year (e.g.,2018):");
		int year = input.nextInt();
		System.out.print("Enter month as number between 1 and 12 :");
		int month = input.nextInt();
		printMonthTitle(month,year);
		printMonthBody(getStartDay(month,year),getNumberOfDaysInMonth(month,year));
	}
	
	public static void printMonthTitle(int month,int year){
		switch(month){
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
		for(int i=0;i<50;i++)
			System.out.print("_");
		System.out.print("\n");
		for(int i=1;i<=7;i++){
			switch(i){
			case 1:System.out.print("Sun\t");break;
			case 2:System.out.print("Mon\t");break;
			case 3:System.out.print("Tue\t");break;
			case 4:System.out.print("Wed\t");break;
			case 5:System.out.print("Thu\t");break;
			case 6:System.out.print("Fri\t");break;
			case 7:System.out.print("Sat\t");break;
		    }
	    }
		System.out.print("\n");
    }
	public static int getStartDay(int month,int year){
		int t,num,year1,ayear=2018,allday=0;
		if(year>2018) {
			year1=year-2018;
			for(int i=0;i<year1;i++){
				if((ayear%4==0&&ayear%100!=0)||(ayear%400==0))
					allday = allday + 366;
				else
					allday = allday + 365;
				ayear++;
			}
	    }	
		else {
			year1=2018-year;
			for(int i=0;i<year1;i++){
				if((year%4==0&&year%100!=0)||(year%400==0))
					allday = allday + 366;
				else
					allday = allday + 365;
				year++;
		    }
		}
		for(int i=1;i<month;i++){
			if((i==1)||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12))
				allday=allday+31;
			else if((i==4)||(i==6)||(i==9)||(i==11))
				allday=allday+30;
			else if((i==2)&&(year%4==0&&year%100!=0)||(year%400==0))
				allday=allday+29;
			else
				allday=allday+28;
		}
		num = (allday+1)%7;
	    return num;
	}
	public static int getNumberOfDaysInMonth(int month,int year){
		if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
			return 31;
		else if((month==4)||(month==6)||(month==9)||(month==11))
		    return 30;
		else if((month==2)&&(year%4==0&&year%100!=0)||(year%400==0))
			return 29;
		else
			return 28;
	}
	public static void printMonthBody(int num,int days){
		int t;
		if(days==31){
			for(int i=0;i<num;i++)
				System.out.printf("\t");
			for(int i=1;i<=31;i++){
				System.out.print(i+"\t");
				t=num+i;
				if(t%7==0)
					System.out.printf("\n");
			}
		}
		else if(days==30){
			for(int i=0;i<num;i++)
				System.out.printf("\t");
			for(int i=1;i<=30;i++){
				System.out.print(i+"\t");
				t=num+i;
				if(t%7==0)
					System.out.printf("\n");
			}
		}
		else if(days==29){
			for(int i=0;i<num;i++)
				System.out.printf("\t");
			for(int i=1;i<=29;i++){
				System.out.print(i+"\t");
				t=num+i;
				if(t%7==0)
					System.out.printf("\n");
			}
		}
		else{
			for(int i=0;i<num;i++)
				System.out.printf("\t");
			for(int i=1;i<=28;i++){
				System.out.print(i+"\t");
				t=num+i;
				if(t%7==0)
					System.out.printf("\n");
			}
		}
	}
}

