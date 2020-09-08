package com.newthread;

// 死锁：多线程竞争资源
public class DeadLock {
	public static void main(String[] args) {
		Makeup girl1 = new Makeup(0, "Marry");
		Makeup girl2 = new Makeup(1, "Lisa");
		
		girl1.start();
		girl2.start();
	}
}

class Lipstick{
	
}

class Mirror {
	
}

class Makeup extends Thread {
	
	// 用static保证资源只有一份儿
	private static Lipstick lipstick = new Lipstick();
	private static Mirror mirror = new Mirror();
	int choice;
	String name;	// 化妆的人
	
	public Makeup(int choice, String name) {
		this.choice = choice;
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			startMakeup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 化妆，互相持有对方的锁，就是需要拿到对方的资源
//	private void startMakeup() throws InterruptedException {
//		if (choice==0) {
//			synchronized (lipstick) {	// 获得口红的锁
//				System.out.println(this.name+" got the lipstick!");
//				Thread.sleep(1000);
//				synchronized (mirror) {	// 1秒钟后向获得镜子
//					System.out.println(this.name+" got the mirror!");
//				}
//			}
//		} else {
//			synchronized (mirror) {
//				System.out.println(this.name+" got the mirror!");
//				Thread.sleep(1000);
//				synchronized (lipstick) {
//					System.out.println(this.name+" got the lipstick!");
//				}
//			}
//		}
//		// 比如选择0时，只有当得到镜子后才会释放口红的锁，就会死锁
//	}
	
	private void startMakeup() throws InterruptedException {
		if (choice==0) {
			synchronized (lipstick) {	// 获得口红的锁
				System.out.println(this.name+" got the lipstick!");
				Thread.sleep(1000);
			}
			synchronized (mirror) {	// 1秒钟后向获得镜子
				System.out.println(this.name+" got the mirror!");
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.name+" got the mirror!");
				Thread.sleep(1000);
			}
			synchronized (lipstick) {
				System.out.println(this.name+" got the lipstick!");
			}
		}
		// 这样做就是当口红用完口红的锁就释放
	}
}