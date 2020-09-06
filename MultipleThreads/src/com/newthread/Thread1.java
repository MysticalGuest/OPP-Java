package com.newthread;

// 创建线程方式一：继承Thread类，重写run方法，调用start开启线程
public class Thread1 extends Thread {
	
	@Override
	public void run() {
		// run方法线程体
		for (int i = 0; i < 20; i++) {
			System.out.print(String.format("%-3d", i) + "Hello    ");
		}
	}
	
	public static void main(String[] args) {
		// main方法主线程
		
		// 创建一个线程对象
		Thread1 thread1 = new Thread1();
		
		// 调用start方法开启线程
		thread1.start();
		
		for (int i = 0; i < 800; i++) {
			System.err.print(String.format("%-3d", i) + "World    ");
		}
	}

}
