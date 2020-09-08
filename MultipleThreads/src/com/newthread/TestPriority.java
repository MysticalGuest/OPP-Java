package com.newthread;

// 测试线程的优先级
public class TestPriority {
	public static void main(String[] args) {
		// 主线程默认优先级
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		
		MyPriority myPriority = new MyPriority();
		
		Thread t1 = new Thread(myPriority);
		Thread t2 = new Thread(myPriority);
		Thread t3 = new Thread(myPriority);
		Thread t4 = new Thread(myPriority);
		Thread t5 = new Thread(myPriority);
		
		t1.start();
		
		t2.setPriority(2);	// 先设置优先级再启动
		t2.start();
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
		
		try {
			t4.setPriority(-1);
			t4.start();
			
			t5.setPriority(11);
			t5.start();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}

class MyPriority implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		
	}
	
}
