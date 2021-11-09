 package com.enterpriseQuestions;

 /**
 * @author MysteryGuest
 * @date 2021/11/01
 */
public class StringFinal {
    /** 提示：String是final修饰的
     * 考点：静态变量和静态块额加载时期、字符串常量的+拼接、字符串常量池、成员变量和局部变量
     */
    public static final String A = "123";
    public static final String B;// The blank final field B may not have been initialized
    /**
     * 静态常量在创建时要进行赋值
     * B在创建时并没有赋值， 静态变量。
     * 当字符串常量（A）与字符串变量（B）用+号连接时，会在堆里s的引用指向常量池里面的"123456"，因此比较时是false
     * 后面的s是创建的，两个常量字符串相加，就直接指向常量池"123456"，所以是true.
     * */
    
    static {
        B = "456";
        s = A + B;
    }
    
    final static String s;
    
    public static void main(String[] args) {
        System.out.println(s);
        System.out.println(s=="123456");
        String s = A + "456";
        System.out.println(s);
        
        System.out.println(s=="123456");
        
    }
}
