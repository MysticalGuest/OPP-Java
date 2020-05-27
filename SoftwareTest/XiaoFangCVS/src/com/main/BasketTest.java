package com.main;

import junit.framework.TestCase;

import com.dao.*;

public class BasketTest extends TestCase {
	private Basket basket = new Basket();
	private Goods goods = new Goods();
	
	public void testAddGoods() {
		goods.setName("Bread");
		basket.addGoods(goods);
		assertEquals("Bread", basket.getAllGoods().get(0).getName());
	}
	
	public void testIsEmpty() {
		basket = new Basket();
		assertEquals(true, basket.isEmpty());
	}
	
	public void testClear() {
		goods.setName("Bread");
		basket.addGoods(goods);
		basket.clear();
		assertEquals(true, basket.isEmpty());
	}
	
	public void testGetTotalPrice() {
//		goods.setName("Bread");
//		goods.setPrice(1f);
//		basket.addGoods(goods);
//		goods.setName("Notebook");
//		goods.setPrice(3f);
//		basket.addGoods(goods);
		basket.addGoods(new Goods("Bread",1f));
		basket.addGoods(new Goods("Notebook",3f));
		assertEquals(4f, basket.getTotalPrice());
	}

}
