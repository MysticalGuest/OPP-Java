 package com.newthread;

 /**
 * @author MysteryGuest
 * @date 2021/04/22
 * 使用with()方法和notify()方法实现交替打印
 */
public class AlternateWithWait {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Print p = new Print();
        
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.printf1();
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                }
            }
        }.start();
        
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p.printf2();
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                }
            }
        }.start();
        
    }

}

class Print {

    boolean flag = false;
    
    public void printf1() throws InterruptedException {
        // 这个参数里面是锁对象
        synchronized (Print.class) {
            if (this.flag) {
                System.out.println("111");
                Print.class.wait();
            }
            this.flag = !this.flag;
            Print.class.notify();
        }
    }
    
    public void printf2() throws InterruptedException {
        // 这个参数里面是锁对象
        synchronized (Print.class) {
            if (!this.flag) {
                System.out.println("222");
                Print.class.wait();
            }
            this.flag = !this.flag;
            Print.class.notify();
        }
    }
    
}
