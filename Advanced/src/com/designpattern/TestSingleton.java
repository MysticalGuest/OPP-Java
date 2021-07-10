 package com.designpattern;

 /**
 * @author MysteryGuest
 * @date 2021/05/14
 * 单例模式示例
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1 == singletonLazy2);
    }

}

class Singleton {
    private final static Singleton instance = new Singleton();
    
    public static Singleton getInstance() {
        return instance;
    }
}

/*
 * 以上单例模式是在类加载的时候就创建了，这样会影响程序的启动速度，那如何实现单例模式的延迟加载？在使用时再创建？
 * 使用 synchronized 来保证，单例模式的线程安全代码
 * */
class SingletonLazy {
    private static SingletonLazy instance;
    
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
    
}