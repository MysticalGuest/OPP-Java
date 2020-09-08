package com.threadSafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUsingLock {
	
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Create and launch 100 threads
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddAPennyTask());
		}
		
		executor.shutdown();
		
		// With until all task are finished
		while (!executor.isTerminated()) {
		}
		
		System.out.println("What is balance? " + account.getBalance());

	}
	
	// A thread for adding a penny to the account
	public static class AddAPennyTask implements Runnable {
		public void run() {
			account.deposit(1);
		}
	}
	
	public static class Account {
		private static Lock lock = new ReentrantLock(); // Create a lock
		private int balance;

		public void deposit(int amount) {
			lock.lock(); // Acquire the lock 获取该锁
			try {
				int newBalance = balance + amount;
				
				// This delay is deliberately to magnify the
				// data-corruption problem and make it easy to see
				// 这种延迟是有意放大数据损坏问题，并使其易于看到
				Thread.sleep(5);
				
				balance = newBalance;
			} catch (InterruptedException  ex) {
				System.err.println(ex);
			}
			finally { //无论异常是否产生,finally子句总是会被执行
				lock.unlock();  // 确保锁被释放
			}
		}

		public int getBalance() {
			return balance;
		}
		
	}

}
