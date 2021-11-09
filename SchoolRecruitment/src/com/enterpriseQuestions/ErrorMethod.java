 package com.enterpriseQuestions;

import org.junit.Test;

/**
 * @author MysteryGuest
 * @date 2021/10/26
 * 异常
 */
public class ErrorMethod {

    /**
     * @param args
     * @implNote 下面代码是否编译出错？如果编译无误，输出结果是多少？说明理由
     */
    public static void main(String[] args) {
        System.out.println(mathod());

    }
    
    public static int mathod() {
        int num=0;
        try {
            num = 5 / num;
            return num;
        } catch (Exception e) {
            System.out.println("此时catch块中num的值为: " + num);
            return num++;
        } finally {
            // 值为1，说明catch块中的return语句中num++执行了，return并未执行成功，但finally块还是会执行
            System.out.println("此时finally块中num的值为: " + num);
            return ++num;
            /**
             * 当finall块中包含return语句时，
             * Eclipse会给出警告“finally block does not complete normally”，原因分析如下：
             *      1、不管try块、catch块中是否有return语句，finally块都会执行!!!!
             *      2、finally块中的return语句会覆盖前面的return语句（try块、catch块中的return语句），
             *      所以如果finally块中有return语句，
             *      Eclipse编译器会报警告“finally block does not complete normally”。
             *      3、如果finally块中包含了return语句，即使前面的catch块重新抛出了异常，则调用该方法的语句也不会获得catch块重新抛出的异常，而是会得到finally块的返回值，并且不会捕获异常。
             * 结论，应避免在finally块中包含return语句。如果你在前面的语句中包含了return语句或重新抛出了异常，
             * 又在finally块中包含了return语句，说明你概念混淆，没有理解finally块的意义。
             * */
        }
        
    }
    
    @Test
    public void testOperater() {
        int i = 5;
        i += i -= i *= i++;
        /** -15, 不同编译器结果不同？
         * 解释型语言是-15，编译型语言是0而且会有警告？
         * i += i -= i *= i++;-> i += i -= i *= 5;-> i += i -= 5 *= 5;->
         * i += 5 -= 25;-> 5 += -20;->-15;???是这样的吗？
         */
        System.out.println(i);
        int num=5;
        num++;
        num *= num;
        num -= num;
        num += num;
        System.out.println(num);
        int p = 5;
        p = p++;
        System.out.println(p);
        p = ++p;
        System.out.println(p);
        int q=5;
        q += q -= q *= ++q;
        /** -15, 不同编译器结果不同？
         * 解释型语言是-15，编译型语言是0而且会有警告？
         * q += q -= q *= ++q;-> q += q -= q *= 6;-> q += q -= 5 *= 6;->
         * i += 5 -= 30;-> 5 += -25;-> -20;???是这样的吗？
         */
        System.out.println(q);
        
    }

    /**
     * 下面代码编译运行的结果是？
     * 提示：long是8个字节，而float是4个字节
     * */
    @Test
    public void testLongAndFloat() {
        long l = 123456; // 结尾加不加l无所谓
        float f = 123.456F; // 结尾必须加f或F，因为它默认double，Type mismatch: cannot convert from double to float
        
//        l = f; // 报错，Type mismatch: cannot convert from float to long
        l = (long)f; // 123
        f = l; // 自动类型提升
//        f = (float)l;
        
        System.out.println(l);
        System.out.println(f);
        
    }
    
    @Test
    /**
     * 值传递与引用传递
     * */
    public void testString() {
        Str s = new Str();
        s.change(s.str, s.arr);
        System.out.println(s.str); // java
        System.out.println(s.arr); // apa
    }
}

class Str{
    String str = new String("java");
    char[] arr = {'a', 'p', 'p'};
    
    /**
     * 结论：string不变，数组变
     * */
    public void change(String str, char[] arr) {
        str = "oop";
        arr[2] = 'a';
    }
}