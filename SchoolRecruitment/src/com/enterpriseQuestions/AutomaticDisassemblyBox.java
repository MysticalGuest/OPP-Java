 package com.enterpriseQuestions;

import org.junit.Test;

/**
 * @author MysteryGuest
 * @date 2021/11/21
 */
public class AutomaticDisassemblyBox {

    public static void main(String[] args) {
        Integer a1 = new Integer(123);
        int a2 = new Integer(123);
        Integer a3 = new Integer(123);
        Integer a4 = 123;
        int a5 = 123;
        
        // 我认为以下输出：true, false, false, true, true
        System.out.println(a1==a2);
        System.out.println(a1==a3);
        System.out.println(a1==a4);
        System.out.println(a1==a5);
        System.out.println(a2==a4);
        
        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a3));
        System.out.println(a1.equals(a4));
        System.out.println(a1.equals(a5));
    }
    
    /**
     * 下面代码是否编译出错？输出多少？
     * */
    @Test
    public void test() {
        boolean a = 1.0F == 1.0;
        boolean b = 1.1F == 1.1;
        System.out.println(a+", "+b);
        // 我的理解是，计算机用2进制来存储一个数，所以精度不同，他们的值会不同
        // 例如：1.100000000000, 1.10000000000000000000001
    }
}
