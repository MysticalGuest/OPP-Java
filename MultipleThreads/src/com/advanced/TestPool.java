package com.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
	public static void main(String[] args) {
		// 1.创建服务，创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(new PoolThread());
		executorService.execute(new PoolThread());
		executorService.execute(new PoolThread());
		executorService.execute(new PoolThread());
		
		// 2.关闭连接
		executorService.shutdown();
	}

}

class PoolThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}