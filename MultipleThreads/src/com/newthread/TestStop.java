package com.newthread;

public class TestStop implements Runnable {
	
	// 1.设置一个标志位
	private boolean flag = true;

	@Override
	public void run() {
		int i=0;
		while (flag) {
			System.out.println("run...Thread..."+i++);
			
		}
	}
	
	// 2.设置一个公开的方法停止线程，转换标志位
	public void stop() {
		this.flag = false;
	}
	
	public static void main(String[] args) {
		TestStop testStop = new TestStop();
		new Thread(testStop).start();
		
		for (int i = 0; i < 200; i++) {
			System.out.println("main...Thread..."+i);
			if(i==100) {
				// 调用stop方法停止线程
				testStop.stop();
				System.out.println("run...Thread...stoped...");
			}
		}
	}

}
