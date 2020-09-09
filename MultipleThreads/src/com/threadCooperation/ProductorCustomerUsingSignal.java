package com.threadCooperation;

public class ProductorCustomerUsingSignal {
	public static void main(String[] args) {
		Show show = new Show();
		new Actor(show).start();
		new Audience(show).start();
	}

}

// 生产者演员
class Actor extends Thread {
	private Show show;
	public Actor(Show show) {
		this.show = show;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i%2==0) {
				this.show.play("Happy Camp!");
			} else {
				this.show.play("TikTok!");
			}
		}
	}
}

// 消费者观众
class Audience extends Thread {
	private Show show;
	public Audience(Show show) {
		this.show = show;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			this.show.watch();
		}
	}
}

// 资源节目
class Show {
	// 演员表演，观众等待	T
	// 观众观看，演员等待	F
	private boolean flag = true;
	String display;	// 表演的节目
	
	// 表演
	public synchronized void play(String display) {
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Actors show the "+display);
		// 通知观众观看
		this.notifyAll();
		this.display = display;
		this.flag = !this.flag;
	}
	
	// 表演
	public synchronized void watch() {
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Audience watch the "+display);
		// 通知演员表演
		this.notifyAll();
		this.flag = !this.flag;
	}
}