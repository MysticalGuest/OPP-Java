 package com.trendmicro;

import java.util.Scanner;

/**
 * @author MysteryGuest
 * @date 2021/05/08
 * 题目描述：在一个含有m个数字字符的字符串中，去掉n(n<=m)个数字，得到的字符串最小
 * 保证字符串不会以0开头
 */
public class MinNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        /*
         * 输入用例：
         * 第一行：1432319
         * 第二行：3
         * 输出：1219
         * */
        
        /*
         * 输入用例：
         * 第一行：2020
         * 第二行：1
         * 输出：20
         * */

        Scanner input = new Scanner(System.in);
        
        String numString = input.nextLine();
        int n = input.nextInt(), len=numString.length();
        int rate = len-n; // 结果为几位数
        int result = (int)((numString.charAt(0)-'0') * Math.pow(10, rate-1)), final_result=0;
        int temp=0;
        int start=1;
        
        while (rate>0) {
            for (int i = start; i < len; i++) {
                if (rate<=len-i) { // 后面的字符够补位
                    temp=(int)((numString.charAt(i)-'0') * Math.pow(10, rate-1));
                    System.err.println(temp+ "   "+result);
                    if (temp<result) {
                        result=temp;
                        start=i;
                    }
                }
                
            }
            n--;
            if (n<=0) {
                String s = numString.substring(start);
                final_result+=Integer.parseInt(s);
                break;
            }
            System.err.println("asas:"+start);
            rate--;
            start++;
            final_result+=result;
//            result = (int)((numString.charAt(start)-'0') * Math.pow(10, rate));
        }
        System.out.println(final_result);
    }

}
