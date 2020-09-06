package com.newthread;

public class Thread3 implements Runnable {
	
	@Override
	public void run() {
		// run方法线程体
		for (int i = 0; i < 20; i++) {
			System.out.print(String.format("%-3d", i) + "Hello    ");
		}
	}
	
	public static void main(String[] args) {
		// main方法主线程
		
		// 创建Runnable接口的实现类对象
		Thread3 thread3 = new Thread3();
		
		// 创建线程对象，通过线程对象来开启我们的线程
//		Thread thread = new Thread(thread3);
//		thread.start();
		
		new Thread(thread3).start();
		
		for (int i = 0; i < 800; i++) {
			System.err.print(String.format("%-3d", i) + "World    ");
		}
	}
}
