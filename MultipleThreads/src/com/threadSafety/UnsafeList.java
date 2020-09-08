package com.threadSafety;

import java.util.ArrayList;
import java.util.List;

// List是不安全的
public class UnsafeList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
				
//				synchronized (list) {  // 使安全
//					list.add(Thread.currentThread().getName());
//				}
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
