package com.threadSafety;

public class ThreadA extends Thread {
	
	private Count count;

	public ThreadA(Count count) {
		this.count = count;
	}
	
	public void run() {
		count.add();
	}
	
	public static void main(String[] args) {

		Count count = new Count();
		for (int i = 0; i < 5; i++) {
			ThreadA task = new ThreadA(count);
			task.start();
		}
		
		try {
			Thread.sleep(100l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("5个人干完活,最后的值:"+count.num);
	}

}
