package com.textIO;

import java.util.Scanner;

public class ReadData {

	public static void main(String[] args) throws Exception {
		// Create a file instance
		java.io.File file = new java.io.File("scores.txt");
		
		// Create a Scanner for the file
		Scanner input = new Scanner(file); //可能会抛出I/O异常
		
		// Read data from a file
		while(input.hasNext()) {
			String firstName = input.next();
			String mi = input.next();
			String lastNameString = input.next();
			int score = input.nextInt();
			System.out.println(
					firstName + " " + mi + " " + lastNameString + " " + score);
		}
		
		// Close the file
		input.close();

	}

}
