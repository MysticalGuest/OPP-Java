 package com.keyword;

 /**
 * @author MysteryGuest
 * @date 2021/05/28
 */
public class SwitchCase {

    public static void main(String[] args) {
        // int, short, byte, boolean, char, double, float, long, String
        int intKey = 1;
        switch (intKey) {
            case 1:
                System.out.println("support int value: "+intKey);
                break;
            case 2:
                System.out.println("support int value: "+intKey);
                break;
            default:
                break;
        }
        
        short shortKey = 2;
        switch (shortKey) {
            case 1:
                System.out.println("support short value: "+shortKey);
                break;
            case 2:
                System.out.println("support short value: "+shortKey);
                break;
            default:
                break;
        }
        
        // 在Java中，byte类型的数据是8位带符号的二进制数, 取值范围是[-128, 127]
        byte byteKey = 0b01111111;
        byteKey++;
        switch (byteKey) {
            case -128:
                System.out.println("support byte value: "+byteKey);
                break;
            case 127:
                System.out.println("support byte value: "+byteKey);
                break;
            default:
                break;
        }
        
        /*
         * 456的二进制表示是111001000，由于int是32位的二进制，所以在计算机中，实际上是00000000000……111001000，
         * 当int转成byte的时候，那么计算机会只保留最后8位，即11001000。
         * 然后11001000的最高位是1，那么表示是一个负数，而负数在计算机中都是以补码的形式保存的，
         * 所以我们计算11001000的原码为00111000，即56，所以11001000表示的是-56，所以最后intToByte的值为-56
         * */
        int intValue = 456;
        byte intToByte = (byte) intValue;
        System.out.println("Convert int value "+intValue+" to byte value is "+intToByte);
        
        String stringKey = "HelloWorld";
        switch (stringKey) {
            case "HelloWorld":
                System.out.println("support string value: "+stringKey);
                break;
            case "Java":
                System.out.println("support string value: "+stringKey);
                break;
            default:
                break;
        }
        
        // 无法打开布尔类型的值。只允许使用可转换的int值、字符串或枚举变量
//        boolean boolKey = false;
//        switch (boolKey) {
//            case false:
//                
//                break;
//            default:
//                break;
//        }
    }
}
