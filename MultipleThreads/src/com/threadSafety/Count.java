package com.threadSafety;

public class Count {

	public int num = 0;
	public synchronized void add() {
		try {
			Thread.sleep(5l);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		num+=1;
		System.out.println(Thread.currentThread().getName() + "-"  + num);
	}
}
