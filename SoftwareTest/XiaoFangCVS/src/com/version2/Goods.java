package com.version2;

/**
 * 一个商品，包含了名称，价格信息
 */
public class Goods {
    private String name;
    private float price;
    
    /**
     * 通过名称和价格创建一个商品
     * @param name 商品名称
     * @param price 商品价格
     */
    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 取得商品名称
     * @return 商品名称
     */
    public String getName() {
        return name;
    }
    
    /**
     * 设置商品名称
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 取得商品价格
     * @return 商品价格
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * 设置商品价格
     * @param price　商品价格
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
}
