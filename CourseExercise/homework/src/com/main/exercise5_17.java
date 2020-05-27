package com.main;

import java.util.Scanner;

public class exercise5_17 {

	public static void main(String[] args) {
		System.out.print("Enter the number of lines: ");
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		int n , flag = 1;

		for(int i = 0 ; i < num ; i++ ) {
			for(int j = 0 ; j < 60 - 2*i ; j++ )
				System.out.print(" ");
			
			n = i+1;
			
			for(int k = 0 ; k < 2*i+1 ; k++) {
				System.out.print(" " + n);
				if(flag == 1) {
					n--;
					if(n == 1)
						flag=0;
				}
				else
					n++;
			}
			flag = 1;
			System.out.println();
		}
	}

}
