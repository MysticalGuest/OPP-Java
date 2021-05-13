package com.advanced;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFixedThreadPool {
	public static void main(String[] args) {
	    /*
	     * Java.util.concurrent.ExecutorService接口代表一种异步执行机制，它能够在后台执行任务。
	     * ExecutorService的具体实现就是一个线程池的具体实现？
	     * 
	     * 通过newFixedThreadPool()工厂方法创建一个ExecutorService的实例。这个方法创建了一个可以有10个线程执行任务的线程池。
	     * Runnable接口的匿名实现类作为参数被传递给execute()方法。Runable将会被ExecutorService中的一个线程来执行。
	     * 
	     * Thread将一个线程委托一个任务给ExecutorService进行异步执行。
	     * 一旦，线程委托任务给ExecutorService，线程会独立任务的执行而继续自己之后的操作。
	     * */
		// 1.创建服务，创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(new PoolThread());
		executorService.execute(new PoolThread());
		executorService.execute(new PoolThread());
		executorService.execute(new PoolThread());
		
		/*
		 * execute(Runnable) 方法接受一个java.lang.Runable对象的实例，并异步执行之。
		 * 这种方式不能获得Runnable执行的结果，如果有这种需要，你将要使用Callable。
		 * */
		executorService.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});
		
		/*
		 * submit(Callable)方法与submit(Runnable)方法相似，除了接收的参数有所不同。
		 * Callable实例非常类似于Runnable,不同的是call方法可以返回一个结果，Runnable.run()方法不能返回一个结果。
		 * */
		Future<?> future = executorService.submit(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task with submit!");
		    }
		});

		try {
		    // future.get() returns null if the task has finished correctly.
		    System.out.println("future.get() = " + future.get());
        } catch (InterruptedException e) {
             e.printStackTrace();
        } catch (ExecutionException e) {
             e.printStackTrace();
        }
		
		/*
		 * 可以通过submit(Callable)方法返回的Future对象获取Callable的结果。
		 * */
		future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        System.out.println("Asynchronous Callable");
		        return "Callable Result";
		    }
		});

		try {
            System.out.println("future.get() = " + future.get());
        } catch (InterruptedException e) {
             e.printStackTrace();
        } catch (ExecutionException e) {
             e.printStackTrace();
        }


		
		// 2.关闭连接
		executorService.shutdown();
	}

}

class PoolThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}