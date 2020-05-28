package com.binaryIO;

import java.io.*;

public class PrintWriterLearn {
	public static void main(String[] args) {
		try {
			PrintWriter output = new PrintWriter("temp.txt");
			output.print("Java 101");
			output.close();
			System.out.println("success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}

}
