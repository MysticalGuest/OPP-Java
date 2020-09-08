package com.threadSafety;

import java.util.concurrent.*;

public class AccountWithoutSync {

	// 该账户中的初始余额为0
	private static Account account = new Account();
	
	public static void main(String[] args) {
		// 创建一个线程池,它会在必要的时候创建新的线程,
		// 但是如果之前创建的线程可用,则先重用之前创建的线程
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Create and lanuch 100 threads
		for (int i = 0; i < 100; i++) {
			// 调用execute(Runnable object)方法执行可允许的任务
			// 创建任务来给该用户增加一个便士,并且将该任务提交给执行器
			executor.execute(new AddAPennyTask());
		}
		
		// 关闭执行器,但是允许执行器中的任务执行完.
		// 一旦关闭,则不再接收新的任务
		executor.shutdown();
		
		// 如果池中的所有任务终止,则返回true
		// 目的是重复检验所有任务是否完成
		while (!executor.isTerminated()) {
		}
		
		System.out.println("What is balance? " + account.getBalance());
		// 当所有的线程都完成时,余额应该是100
		// 但是输出的结果并不是可预测的.
		// 当所有线程线程同时访问一个数据原时,就会出现数据破坏的问题
	}
	
	// 类AddAPennyTask和Account都是内部类
	
	// A thread for adding a penny to the account
	private static class AddAPennyTask implements Runnable {
		public void run() {
			account.deposit(1);
			
			// 用以下方法也可使线程安全
//			synchronized (account) {
//				account.deposit(1);
//			}
		}
	}
	
	// An inner class for accont
	private static class Account {
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		//临界区
		public void deposit(int amount) {
			// 代码块1开始
			int newBalance = balance +amount;
			
			// This delay is deliberately added to magnify the
			// data-corruption problem and make it easy to see.
			// 故意添加此延迟是为了扩大数据损坏问题并使其易于查看。
			try {
				Thread.sleep(5l);
			} catch (InterruptedException ex) {
				System.err.println(ex);
			}
			
			balance = newBalance;
			//代码块1结束
			
			/*设计代码块1
			  是为了故意放大数据破坏的可能性,使它更容易显现出来
			  */
			
			// 如果采用以下代码,输出结果会非常接近100
//			balance = balance + amount;
		}
		
		// 可以在deposit方法前加上关键字synchronized使Account类成为线程安全的
	}

}
