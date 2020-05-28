package com.threadCooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
	
	private static Account account = new Account();

	public static void main(String[] args) {
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		
		System.out.println("Thread 1\t\tThread 2\t\tBalance");

	}
	
	public static class DepositTask implements Runnable {
		@Override // Keep adding an amount to the account
		public void run() {
			try {
				// Purposely delay it to let the withdraw method proceed
				// 故意延迟它以使withdraw方法继续进行
				while (true) {
					account.deposit((int)(Math.random() * 10)+1);
					Thread.sleep(1000);
					
				}
				
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static class WithdrawTask implements Runnable {
		@Override // Keep adding an amount to the account
		public void run() {
			while (true) {
				account.withdraw((int)(Math.random() * 10)+1);
			}
		}
	}

	// An inner class for accout
	private static class Account {
		// Create a new lock
		// java.util.concurrent.locks.ReentrantLock;
		// ReentrantLock() 等价于ReentrantLock(false)
		// 根据给定的公平策略创建一个锁.如果fairness为真
		// 一个最长等待时间的线程将的到该锁.否则,没有特别的访问次序
		private static Lock lock = new ReentrantLock();
		
		// Create a condition
		// newCondition():Codition  返回一个绑定到该Lock实例的Condition实例
		// 创建一个锁,锁上名为newDeposit的条件
		private static Condition newDeposit = lock.newCondition();
		
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void withdraw(int amount) {
			lock.lock(); // Acquire the lock
			try {
				while (balance < amount) {
					System.out.println("\t\tWait for a deposit");
					newDeposit.await();
				}
				
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			finally {
				lock.unlock();
			}
		}
		
		public void deposit(int amount) {
			lock.lock();
			try {
				balance += amount;
				System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
				
				// Signal thread waiting on the condition  信号线程等待条件
				// java.util.concurrent.locks.Condition; Condition的signal():void
				// 唤醒一个等待线程
				// 就是存一次款,无论余额够不够,都唤醒取款任务比较一次
				// 在有新的钱存入之后通知所有newDeposit条件的等待线程
				newDeposit.signal();
			}
			finally {
				lock.unlock(); // Release the lock
			}
		}
	}
}
