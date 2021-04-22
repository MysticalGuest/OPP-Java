package com.newthread;

public class TaskThreadDemo {

	public static void main(String[] args) {
		//create task
		Runnable printA = new PrintChar('a',100);
		Runnable printB = new PrintChar('b',100);
		Runnable print100 = new PrintNum(100);
		
		//Create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		//Start threads
		thread1.start();
		thread2.start();
		
		thread3.start();
//		thread1.run();
//		thread2.run();
//		thread3.run();
 	}
}

class PrintChar implements Runnable {
	private char charToPrint; //The character to print
	private int times;  //The number of times to repeat
	
	/** 
	 * Construct a task with a specified character and number of times to print the character
	 * */
	public PrintChar(char c , int t) {
		charToPrint = c;
		times = t;
	}
	
	@Override 
	/** 
	 * Override the run() method to tell the system what task to perform
	 * */
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(charToPrint);
		}
	}
}

//The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {
	private int lastNum;
	
	/** 
	 * Construct a task for printing numbers from 1 to n for a given n
	 * */
	public PrintNum(int n) {
		lastNum = n;
	}
	
	@Override 
	/** 
	 * Override the run() method to tell the system
	 * what task to perform
	 * */
	public void run() {
//		for(int i = 0; i < lastNum; i++) {
//			System.out.print(""+i);
////			Thread.yield();
//		}
		try {
			for(int i = 0; i < lastNum; i++) {
				System.out.print(""+i);
				if(i>=50) Thread.sleep(1);
			}
		}
		catch(InterruptedException ex) {}
		
	}
}
