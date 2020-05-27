package com.exercise;

import java.util.Scanner;

public class exercise5_1 {

	public static void main(String[] args) {
		System.out.print("Enter an integer, the input ends if it is 0: ");
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		int positives = 0 , negatives = 0 , numOfInput = 0;
		float total = 0 ;
		
		while(num!=0) {
			if(num>0)
				positives++;
			else if(num<0)
				negatives++;
			
			numOfInput++;
			
			total += num;
			
			num = input.nextInt();
		}
		
		System.out.println("The number of positives is " + positives);
		System.out.println("The number of negatives is " + negatives);
		System.out.println("The total is " + total);
		System.out.println("The average is " + total/numOfInput);
		
		input.close();

	}

}
