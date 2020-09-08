package com.threadSafety;

public class Bank {
	
	public static void main(String[] args) {
		Account account = new Account(100, "Deposit");
		
		Drawing husband = new Drawing(account, 50, "husband");
		Drawing wife = new Drawing(account, 100, "wife");
		
		husband.start();
		wife.start();
	}

}

class Account {
	int money;
	String name;
	
	public Account(int money, String name) {
		this.money = money;
		this.name = name;
	}
}

class Drawing extends Thread {
	
	Account account;
	
	int drawingMoney;
	
	int nowMoney;
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
//	@Override
//	public synchronized void run() {
//		if(account.money-drawingMoney<0) {
//			System.out.println(Thread.currentThread().getName()+" Money is not enough!");
//			return;
//		}
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		// 卡内余额
//		account.money = account.money - drawingMoney;
//		// 手里的现金
//		nowMoney = nowMoney + drawingMoney;
//		
//		System.out.println(account.name + " balance is "+account.money);
//		System.out.println(this.getName()+"'s cash now is "+nowMoney);
//	}
	
	/* 同步块指定锁住的对象
	 * 可以锁住任何对象
	 * 如果用上面的方法上锁，锁住的是husband和wife对象，也就是有两把锁了
	 * 只能用下面的方法锁住变化的量，才有用
	 */
	
	@Override
	public void run() {
		
		synchronized (account) {
			if(account.money-drawingMoney<0) {
				System.out.println(Thread.currentThread().getName()+" Money is not enough!");
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			account.money = account.money - drawingMoney;

			nowMoney = nowMoney + drawingMoney;
			
			System.out.println(account.name + " balance is "+account.money);
			System.out.println(this.getName()+"'s cash now is "+nowMoney);
		}
	}
}