 package com.construction;

 /**
 * @author MysteryGuest
 * @date 2021/05/26
 * Java构造方法的调用过程研究
 */
public class CallProcedure {
    public static void main(String[] args) {
        System.err.println("Static Block:");
        // 无输出
        Base base = null;
        // 有输出
        Base baseOut = new Base();
        System.err.println("-----------------------------\nProcedure of constructor:");
        new Derive();
    }

}

// 基类
class Base {
    
    private static String str = "Base static.";
    
    /*
     * static代码块:
     * static关键字还有一个比较关键的作用就是：用来形成静态代码块以优化程序性能。
     * static块可以置于类中的任何地方，类中可以有多个static块。
     * 在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。
     * static块可以用来优化程序性能，是因为它的特性:只会在类加载的时候执行一次。
     * */
    static {
        System.out.println(str);
    }
    
    public Base(){
        System.out.println("Base constructor.");
    }
}

// 派生类
class Derive extends Base {
    
    private static String str = "Derive static.";

    static {
        System.out.println(str);
    }
    
    public Derive(){
        System.out.println("Derive constructor.");
    }
}
