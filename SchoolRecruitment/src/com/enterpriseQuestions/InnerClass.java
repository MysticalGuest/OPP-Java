 package com.enterpriseQuestions;

 /**
 * @author MysteryGuest
 * @date 2021/11/01
 * 考点：局部内部类的应用
 */
public class InnerClass {
    int a=1;
    public static void main(String[] args) {
        class Inner {
            /** 注意：这里不是"main"方法
             * 变长参数是Java的一个语法糖，本质上还是基于数组的实现
             * 与数组不同在于：
             * （1）数组作为参数，调用方法时一定要传参，或者传入null
             * （2）变长参数在方法调用时，
             *      - 可以传参：数组，null，1个或多个具体值
             *      - 可以不传参
             * @param a
             */
            public void main(String... a) {
                /**
                 * 根据Java就近原则可知，这里输出的a并不止全局变量a
                 * 而是该方法的可变参数的引用，引用存储的是对象的地址信息
                 * 所以输出的是一串引用类型的地址信息。
                 * */
                System.out.println(a);
            }
        }
        /**
         * 参数是0个，并不等价于传入null
         * */
        new Inner().main();
        new Inner().main(null);
        new Inner().main(String.valueOf(new char[] {'2', 'r'}));
    }

}
