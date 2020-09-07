package com.newthread;

public class Runnable1 implements Runnable {
	
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
		Runnable1 runnable1 = new Runnable1();
		
		// 创建线程对象，通过线程对象来开启我们的线程
//		Thread thread = new Thread(thread3);
//		thread.start();
		
		new Thread(runnable1).start();
		
		for (int i = 0; i < 800; i++) {
			System.err.print(String.format("%-3d", i) + "World    ");
		}
	}
}
