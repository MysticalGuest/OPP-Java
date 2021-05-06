 package com.advanced;


/**
 * @author MysteryGuest
 * @date 2021/04/29
 */
public class ThreadParameters {

    /**
     * @param args
     */
    public static void main(String[] args) {
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
