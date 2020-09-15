package com.huawei;

import java.util.Scanner;

/**
 * @author MysteryGuest
	每被咖啡5元，买咖啡5/10/20，根据面值找钱
	客户编号1开始
	5,5,5,10
	true/false
	5,20,5,10,5
 */
public class Program1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String seq = input.nextLine();
		
		String[] sArray = seq.split(",");
		
		int numOf5=0;
		
		boolean flag = true;
		
		for (int i = 0; i < sArray.length; i++) {

			if (sArray[i].equals("5")) {
				numOf5++;
			} else if(sArray[i].equals("10")) {
				numOf5--;
				if(numOf5<0) {
					flag = false;
					break;
				}
			} else {
				numOf5 -= 3;
				if(numOf5<0) {
					flag = false;
					break;
				}
			}
		}
		
		System.out.println(flag);
		
	}

}
