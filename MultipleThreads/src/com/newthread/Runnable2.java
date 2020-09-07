package com.newthread;

// 多线程同时操作同一个对象
// 买火车票的例子
// 发现问题：多个线程操作同一资源的情况下，线程不安全，数据紊乱
public class Runnable2 implements Runnable {

	private int ticketNum = 10;		// 票数
	
	@Override
	public void run() {
		while (true) {
			if (ticketNum <= 0) {
				break;
			}
			// 模拟延时
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNum--+"票");
			
		}
		
	}
	
	public static void main(String[] args) {
		Runnable2 ticket = new Runnable2();
		
		new Thread(ticket, "Tom").start();
		new Thread(ticket, "Teacher").start();
		new Thread(ticket, "Vendor").start();
	}
}
