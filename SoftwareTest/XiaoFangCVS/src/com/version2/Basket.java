package com.version2;

import java.util.ArrayList;

/**
 * 一个购物篮，包含了已经选择的东西
 *
 */
public class Basket {
    
    private ArrayList<Goods> goodsList = new ArrayList<Goods>();
    
    /**
     * 往购物篮中添加更多的商品
     * @param goods 商品
     */
    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }
    
    /**
     * 取得购物篮中所有的商品信息
     * @return
     */
    public ArrayList<Goods> getAllGoods() {
        return this.goodsList;
    }
    
    /**
     * 判断购物篮是否为空
     * @return
     */
    public boolean isEmpty() {
        return goodsList.size() == 0;
    }
    
    /**
     * 清空购物篮
     */
    public void clear() {
        goodsList.clear();
    }
    
    /**
     * 取得购物篮中所有货品的价格
     * @return 所有物品的价格
     */
    public float getTotalPrice() {
        float total = 0f;
        for (Goods goods : goodsList) {
            total += goods.getPrice();
        }
        return total;
    }
    
}
