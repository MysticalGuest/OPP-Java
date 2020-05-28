package com.threadSafety;

public class ThreadA extends Thread {
	
	private Count count;

	public ThreadA(Count count) {
		// TODO Auto-generated constructor stub
		this.count = count;
	}
	
	public void run() {
		count.add();
	}


}
