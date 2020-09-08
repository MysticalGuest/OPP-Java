package com.newthread;

// 测试插队
public class TestJoin implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("VIP thread comes..."+i);
		}
	}

	public static void main(String[] args) {
		TestJoin testJoin = new TestJoin();
		Thread thisThread = new Thread(testJoin);
		thisThread.start();
		
		for (int i = 0; i < 200; i++) {
			if (i==90) {
				try {
					thisThread.join();	// 插队
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main Thread..."+i);
		}
	}
	
}
