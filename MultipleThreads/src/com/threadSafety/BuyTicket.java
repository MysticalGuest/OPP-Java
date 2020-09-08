package com.threadSafety;

public class BuyTicket {
	
	public static void main(String[] args) {
		Purchaser purchaser = new Purchaser();
		
		new Thread(purchaser, "Purchaser_1").start();
		new Thread(purchaser, "Purchaser_2").start();
		new Thread(purchaser, "Purchaser_3").start();
	}

}

class Purchaser implements Runnable {
	
	private int ticketNum = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				buy();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// synchronized默认锁的是this,就是对象本身
	private synchronized void buy() throws InterruptedException {
		if(ticketNum<=0) {
			flag = false;
			return;
		}
		Thread.sleep(300);
		System.out.println(Thread.currentThread().getName()+" got ticket NO."+ticketNum--);
	}
	
}