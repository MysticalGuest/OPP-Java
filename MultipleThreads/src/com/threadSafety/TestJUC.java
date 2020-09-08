package com.threadSafety;

import java.util.concurrent.CopyOnWriteArrayList;

// JUC即java.util.concurrent包
public class TestJUC {
	public static void main(String[] args) {
		// 安全类型的集合
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		try {
			Thread.sleep(1000);	// 方法问题
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());	// 2个或更多线程同时add方法，就会覆盖
	}

}
