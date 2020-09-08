package com.advanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 测试Lock锁
public class TestLock {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(ticket).start();
		new Thread(ticket).start();
		new Thread(ticket).start();
	}

}

class Ticket implements Runnable {
	int ticketNum = 10;
	
	private final ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();  // 加锁
				if (ticketNum>0) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(ticketNum--);
				} else {
					break;
				}
			} finally {
				lock.unlock();  // 解锁
			}
			
			
		}
	}

//	@Override
//	public void run() {
//		while (true) {
//			if (ticketNum>0) {
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(ticketNum--);
//			} else {
//				break;
//			}
//		}
//		// 不安全，出现-1或0
//	}
	
}