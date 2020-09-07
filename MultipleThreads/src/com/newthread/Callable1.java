package com.newthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable1 implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		for (int i = 0; i < 20; i++) {
			System.out.println(String.format("%-3d", i) + Thread.currentThread().getName());
		}
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable1 callable1 = new Callable1();
		Callable1 callable2 = new Callable1();
		Callable1 callable3 = new Callable1();
		
//		创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(3);

//		提交执行
		Future<Boolean> result1 = ser.submit(callable1);
		Future<Boolean> result2 = ser.submit(callable2);
		Future<Boolean> result3 = ser.submit(callable3);
		
//		获取结果
		boolean r1= result1.get();
		boolean r2= result2.get();
		boolean r3= result3.get();
		System.out.println(r1 + " "+ r2 + " " + r3);

//		关闭服务
		ser.shutdownNow();
	}
}
