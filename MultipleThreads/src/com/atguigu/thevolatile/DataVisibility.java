package com.atguigu.thevolatile;

// 资源类
class Data {
//	int number;
	volatile int number;
	
	void addTo60() {
		this.number=60;
	}
}

/*
 * 验证volatile的可见性
 *   1.1假如 int number=0; number变量之前根本没有添加 volatile关键字修饰,没有可见性
 *   1.2添加了 volatile,可以解决可见性问题
 *   
 * 验证volatile不保证原子性
 *   2.1原子性指的是什么意思?
 *     不可分割,完整性,也即某个线程正在做某个具体业务时,中间不可以酸加塞或者被分割。而要整体完整要么同时成功,要么同时失败
 * 
 * */
public class DataVisibility {

	public static void main(String[] args) { // main: 一切方法的运行入口
		Data d = new Data();
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t come in");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.addTo60();
			System.out.println(Thread.currentThread().getName()+"\t updated number value "+d.number);
		}, "Thread 1").start();

		// 第2个线程就是我们的main线程
		while (d.number == 0) {
			// 如果资源类成员number不加volatile修饰，main线程一直在这里等待循环，直到number值不再等于0
		}
		
		System.out.println(Thread.currentThread().getName()+"\tmission is over, main get the number value: "+d.number);
	}

}
