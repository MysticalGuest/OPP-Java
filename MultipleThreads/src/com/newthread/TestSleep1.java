package com.newthread;

// 模拟网络延时：放大问题的发生性
public class TestSleep1 implements Runnable {
private int ticketNum = 10;		// 票数
	
	@Override
	public void run() {
		while (true) {
			if (ticketNum <= 0) {
				break;
			}
			// 模拟延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNum--+"票");
			
		}
		
	}
	
	public static void main(String[] args) {
		TestSleep1 ticket = new TestSleep1();
		
		new Thread(ticket, "Tom").start();
		new Thread(ticket, "Teacher").start();
		new Thread(ticket, "Vendor").start();
	}

}
