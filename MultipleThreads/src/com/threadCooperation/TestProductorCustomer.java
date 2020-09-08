package com.threadCooperation;


/* 管程法：利用缓冲区解决
 * 需要：生产者、消费者、产品、缓冲区
 */
public class TestProductorCustomer {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		new Productor(buffer).start();
		new Customer(buffer).start();
	}
}

// 生产者
class Productor extends Thread {
	// 需要一个容器
	Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	// 生产
	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			buffer.push(new Goods(i));
			System.out.println("生产了第"+i+"个商品！");
		}
	}
	
}

// 消费者
class Customer extends Thread {
	Buffer buffer;
	
	public Customer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	// 消费
	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			System.out.println("消费了第" + buffer.pop().getID() + "个商品！");
		}
	}
}

// 产品
class Goods extends Thread {
	
	private int ID;
	
	public Goods(int id) {
		this.ID = id;
	}

	public int getID() {
		return ID;
	}
}

// 缓冲区
class Buffer extends Thread {
	// 需要一个容器大小
	Goods[] goods = new Goods[10];
	
	int count=0;
	
	// 生产者放入产品
	public synchronized void push(Goods good) {
		// 如果容器满了，就需要等待消费者消费
		if(count==goods.length) {
			// 通知消费者消费，生产等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 如果没有满就需要放入产品
		goods[count] = good;
		count++;
		
		// 可以通知消费者消费了
		this.notifyAll();
	}
	
	// 消费者消费产品
		public synchronized Goods pop() {
			// 如果容器是否为空
			if(count==0) {
				// 通知生产者生产，消费等待
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// 如果可以消费
			count--;
			Goods good = goods[count];
			
			// 可以通知生产者生产了
			this.notifyAll();
			return good;
		}
	
}