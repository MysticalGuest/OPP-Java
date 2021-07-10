 package com.designpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MysteryGuest
 * @date 2021/05/14
 */
public class TestAbstractFactory {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String purchasePhone = (new PhoneFactory()).createFactory("VIVO");
        System.out.println(purchasePhone);
        
        String purchaseComputer = (new ComputerFactory()).createFactory("Lenovo");
        System.out.println(purchaseComputer);
    }

}

// 抽象工厂
abstract class AbstractFactory {
    public abstract String createFactory(String kind);
}

// 手机工厂
class PhoneFactory extends AbstractFactory {

    /* (non-Javadoc)
     * @see com.designpattern.Factory#createFactory(java.lang.String)
     */
    @Override
    public String createFactory(String kind) {
        final Map<String, String> workshop = new HashMap<String, String>() {/**
            *
            */
           private static final long serialVersionUID = 1L;

       {
           put("iPhone", "Apple iPhone XS Max");
           put("HUAWEI", "HUAWEI Mate 30 5G");
           put("HONOR", "HONOR V40 5G");
           put("MI", "XIAOMI 10S");
           put("VIVO", "iQOO 5");
           put("OPPO", "OPPO Reno4 Pro");
       }};
       
       return workshop.get(kind);
    }
    
}

// 电脑工厂
class ComputerFactory extends AbstractFactory {

    /* (non-Javadoc)
     * @see com.designpattern.Factory#createFactory(java.lang.String)
     */
    @Override
    public String createFactory(String kind) {
        final Map<String, String> workshop = new HashMap<String, String>() {/**
            *
            */
           private static final long serialVersionUID = 1L;

       {
           put("HONOR", "MagicBook Pro 2020");
           put("Lenovo", "ThinkPad X1 Carbon 2020");
           put("MAC", "Apple MacBook Air 13.3");
           put("HUAWEI", "MateBook 13");
           put("ASUS", "ASUS ARTONE");
       }};
       
       return workshop.get(kind);
    }
    
}