 package com.base;

 /**
 * @author MysteryGuest
 * @date 2022/12/29
 * 16,10进制转换
 */
public class Hexadecimal {
    public static void main(String[] args) {
        System.out.println(0xc0000000);
        System.out.println(0xc0000002);
        System.out.println(0Xc0000002);
        System.out.println(0Xc0000002);
        System.out.println(0xc1);
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
//        十六进制转成十进制
        System.out.println(Integer.valueOf("FFFF",16));
        System.out.println(Integer.valueOf("C000000",16));
        
        System.out.println(Integer.parseInt("-2147483648", 10));
        System.out.println(Integer.parseInt("C000000", 16));
    }
}
