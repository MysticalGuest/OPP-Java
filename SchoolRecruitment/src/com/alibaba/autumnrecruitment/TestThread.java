package com.alibaba.autumnrecruitment;

/// 阿里巴巴2017秋招研发工程师笔试题第9题

/*
 * 这道题是考线程的调用情况，线程的启动方式只能通过start这种方式启动才能真正的实现多线程的效果，
 * 如果是手动调用run方法和普通方法调用没有区别，所以这个还是按照顺序执行首先执行run方法之后，
 * 执行输出语句所以最终得到结果foobar.
 * */

public class TestThread {
	
	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			
			@Override
			public void run() {
				System.out.print("foo");
			}
		};
		Thread t = new Thread(runner);
		
		/*
		 * 调用start（）后，线程会被放到等待队列，等待CPU调度，并不一定要马上开始执行，
		 * 只是将这个线程置于可动行状态。然后通过JVM，线程Thread会调用run（）方法，执行本线程的线程体。
		 * 
		 * 1.start（）方法来启动线程，真正实现了多线程运行。
		 * 这时无需等待run方法体代码执行完毕，可以直接继续执行下面的代码；
		 * 2.run（）方法当作普通方法的方式调用。程序还是要顺序执行，
		 * 要等待run方法体执行完毕后，才可继续执行下面的代码， 这样就没有达到写线程的目的。
		 * */
		t.run();
		t.start();
		System.out.print("bar");
	}

}
