 package com.keyword;

 /**
 * @author MysteryGuest
 * @date 2021/07/10
 */
//public strictfp class StrictfpCase {
public class StrictfpCase {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        double aDouble = 0.0555500333333212d;
        float aFloat = 0.0333000000222f;
        
        caculateWithStrictfp(aDouble, aFloat);
        System.out.println("-----------------------------");
        caculate(aDouble, aFloat);

    }

    public static strictfp void caculateWithStrictfp(double d, float f) {
        double res = d / f;
        
        System.out.println("使用strictfp修饰：");
        System.out.println("Double: " + d);
        System.out.println("Float: " + f);
        System.out.println("Result: " + res);
    }
    
    public static void caculate(double d, float f) {
        double res = d / f;
        
        System.out.println("未使用strictfp修饰：");
        System.out.println("Double: " + d);
        System.out.println("Float: " + f);
        System.out.println("Result: " + res);
    }
}
