package com.threadSafety;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Count count = new Count();
		for (int i = 0; i < 5; i++) {
			ThreadA task = new ThreadA(count);
			task.start();
		}
		
		try {
			Thread.sleep(100l);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("5个人干完活,最后的值:"+count.num);
	}

}
