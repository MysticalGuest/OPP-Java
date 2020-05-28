package com.textIO;

import java.io.IOException;

public class WriteData {

	public static void main(String[] args) throws IOException{
		java.io.File file = new java.io.File("scores.txt");
		if (file.exists()) {
			System.out.println("File already exists");
//			System.exit(1);
		}
		
		// Create a file
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		// Write formatted output to the file
		output.print("John T Smith ");
		output.println(90);
		output.print("Eric K John ");
		output.print(85);
		System.out.println("Success!");
		// Close the file
		output.close();

	}

}
