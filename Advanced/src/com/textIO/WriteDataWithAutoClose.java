package com.textIO;

public class WriteDataWithAutoClose {

	public static void main(String[] args) throws Exception {
		java.io.File file = new java.io.File("scoresPrint.txt");
		if (file.exists()) {
			System.out.println("File already exits");
			System.exit(0);
		}
		
		try (
			// Create a file
			java.io.PrintWriter output = new java.io.PrintWriter(file);
		) {
			// Write formatted output to the file
			output.print("John Smith ");
			output.print(78);
			output.print("Eric K Jones ");
			output.print(98);
		}

	}

}
