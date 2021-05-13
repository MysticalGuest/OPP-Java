 package com.advanced;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @author MysteryGuest
 * @date 2021/04/29
 */
public class ThreadParameters {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        /*
         * Java通过Executors提供四种线程池，分别为：
         * newCachedThreadPool: 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         * newFixedThreadPool: 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * newScheduledThreadPool: 创建一个定长线程池，支持定时及周期性任务执行。
         * newSingleThreadExecutor: 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
         * */
        System.out.println("CachedThreadPool is as follows.");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            /*
             * 创建一个根据需要创建新线程的线程池，但在可用时将!!!!!重新使用以前构造的线程!!!!!。
             * 这些池通常会提高执行许多短暂异步任务的程序的性能。 调用execute将重用以前构造的线程（如果可用）。
             * 如果没有可用的线程，将创建一个新的线程并将其添加到该池中。 未使用六十秒的线程将被终止并从缓存中删除。
             * 因此，长时间保持闲置的池将不会消耗任何资源。
             * 请注意，可以使用ThreadPoolExecutor构造函数创建具有相似属性但不同详细信息的池（例如，超时参数）。 
             * */
            final int elem = i;
            cachedThreadPool.execute(new Runnable() {
                
                @Override
                public void run() {
                    // 这里将elem替换为i会报错: Local variable i defined in an enclosing scope must be final or effectively final
                    System.out.println(elem + " " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(elem*2000);
                        /*
                         * 加了这句话后面输出的线程名就不只有pool-1-thread-1了，正如上面所写的原理:
                         * 如果之前的线程正在运行，不可用，那么这里调用execute将不调用之前的线程了
                         * */
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                }
            });
            // 如果没有Thread.sleep(elem*2000);每次都是pool-1-thread-1，线程池为无限大? 当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
        }
        cachedThreadPool.shutdown();
        
        System.out.println("------------------------------\nScheduledThreadPool is as follows.");
        /*
         * 创建一个线程池，可以调度命令在给定的延迟之后运行，或定期执行。
         * */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        /*
         * public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
         * delay - 从现在开始延迟执行的时间 
         * unit - 延时参数的时间单位
         * */
        scheduledThreadPool.schedule(()-> System.out.println("delay 4 seconds"), 4, TimeUnit.SECONDS);
        /*
         * 我将scheduledThreadPool线程池放在fixedThreadPool线程池前面，发现scheduledThreadPool线程池中的线程不是立即就执行，总是延迟delay个时间单位后才执行
         * */
        
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 2 seconds, and excute every 3 seconds. "+sf.format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
            }
        }, 2, 3, TimeUnit.SECONDS);
        // 如果没有下面的语句，上面的System.out.println("delay 2 seconds, and excute every 3 seconds. "+sf.format(new Date()));没有输出，为什么？
        Thread.sleep(10000);
        
        scheduledThreadPool.shutdown();
        
        System.out.println("------------------------------\nFixedThreadPool is as follows.");
        /*
         * 创建一个线程池，该线程池重用固定数量的从共享无界队列中运行的线程。
         * 在任何时候，最多nThreads线程将处于主动处理任务。 
         * 如果所有线程处于活动状态时都会提交其他任务，则它们将等待队列中直到线程可用。
         * 如果任何线程由于在关闭之前的执行期间发生故障而终止，则如果需要执行后续任务，则新线程将占用它。
         * 池中的线程将存在，直到它明确地为shutdown 。 
         * */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 10; i++) {
            final int elem = i;
            // lamdba表示的匿名对象
//            fixedThreadPool.execute(() -> System.out.println(elem + " " + Thread.currentThread().getName()));
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        /*
                         * 因为线程池大小为3，每个任务输出后sleep2秒，所以每两秒打印3条语句?因为只有3个线程可以活动，3个线程都休眠2秒
                         * */
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                    System.out.println(elem + " " + Thread.currentThread().getName());
                }
            });
        }
        fixedThreadPool.shutdown();
        
        System.out.println("------------------------------\nSingleThreadPool is as follows.");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int elem = i;
            // 单线程顺序执行各个任务
            singleThreadExecutor.execute(()->System.out.println(elem + " " + Thread.currentThread().getName()));
        }
        
        
        /*
         * 线程池7个参数
         * public ThreadPoolExecutor(int corePoolSize,
         *                    int maximumPoolSize,
         *                    long keepAliveTime,
         *                    TimeUnit unit,
         *                    BlockingQueue<Runnable> workQueue,
         *                    ThreadFactory threadFactory,
         *                    RejectedExecutionHandler handler)
         * corePoolSize: 线程池中核心线程数量
         * workQueue: 当前线程数量等于corePoolSize的时候，新来的任务保存的地方，等着有空闲线程的时候再执行
         * maximumPoolSize: 当前线程数量等于corePoolSize且workQueue也满了，这时候就得额外创建线程了，
         *   创建之后线程池中的最大线程数就是由这个值决定的
         * keepAliveTime: 空闲线程能存活的时间数值
         * unit: 空闲线程能存活的时间单位
         * threadFactory: 创建线程的工厂，可以指定线程的名字啊等等
         * handler：当前线程数等于maximumPoolSize，并且workQueue也满了，对于新来的任务的处理策略(是丢掉呢还是抛出异常呢)
         * 
         * 总结：
         *   当前线程小于corePoolSize时，创建新线程执行任务
         *   当前线程等于corePoolSize且workQueue未满时，将任务放进workQueue，不创建新的线程
         *   当前线程等于corePoolSize且workQueue已满时，创建新的线程来执行任务
         *   当前线程等于maximumPoolSize且workQueue已满时，执行拒绝策略
         *   当任务变少，线程开始空闲，空闲时间超过设置，则销毁多余线程(除了核心线程数量的其他线程)
         * */

    }

}
