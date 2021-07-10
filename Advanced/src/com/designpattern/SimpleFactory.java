 package com.designpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MysteryGuest
 * @date 2021/05/14
 * 简单工厂模式示例
 */
public class SimpleFactory {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 去工厂拿产品对象，不用管工厂内部实现
        String purchase = Factory.createProduct("iPhone");
        System.out.println(purchase);

    }

}

class Factory {
    public static String createProduct(String kind) {
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
