package com.newthread;

public class TestDaemon {
	
	public static void main(String[] args) {
		God god = new God();
		Man man = new Man();
		
		Thread thread = new Thread(god);
		thread.setDaemon(true);  // 默认false表示用户线程，正常的线程都是用户线程
		
		thread.start();  // 守护线程启动
		
		new Thread(man).start();  // 用户线程挺停止
	}

}

class God implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("God bless you!");
		}
	}
	
}

class Man implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello World!");
		}
		System.err.println("Goodbye World!");
	}
	
}