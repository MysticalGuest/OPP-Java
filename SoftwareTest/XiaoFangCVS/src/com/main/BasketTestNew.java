package com.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dao.*;

public class BasketTestNew {
	private Basket basket;
	private Goods goods;
	
	@Before
	public void build() {
		basket = new Basket();
		goods = new Goods();
	}
	
	@Test
	public void testAddGoods() {
		goods.setName("Bread");
		basket.addGoods(goods);
		assertEquals("Bread", basket.getAllGoods().get(0).getName());
	}
	
	@Test
	public void testIsEmpty() {
		basket = new Basket();
		assertEquals(true, basket.isEmpty());
	}
	
	@Test
	public void testClear() {
		goods.setName("Bread");
		basket.addGoods(goods);
		basket.clear();
//		assertEquals(true, basket.isEmpty());
		assertTrue(basket.isEmpty());
	}
	
	@Test
	public void testGetTotalPrice() {
//		goods.setName("Bread");
//		goods.setPrice(1f);
//		basket.addGoods(goods);
//		goods.setName("Notebook");
//		goods.setPrice(3f);
//		basket.addGoods(goods);
		basket.addGoods(new Goods("Bread",1f));
		basket.addGoods(new Goods("Notebook",3f));
		assertEquals(4f, basket.getTotalPrice(),1);
	}
	
	@After
	public void after() {
		basket.clear();
	}

}
