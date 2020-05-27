package com.dao;

import java.util.ArrayList;

public class Basket {

	private ArrayList<Goods> goodsList = new ArrayList<>();
	
	public void addGoods(Goods goods) {
		goodsList.add(goods);
	}
	
	public ArrayList<Goods> getAllGoods() {
		return goodsList;
	}
	
	public boolean isEmpty() {
		return goodsList.isEmpty();
	}
	
	public void clear() {
		goodsList.clear();
	}
	
	public float getTotalPrice() {
		float totalPrice = 0;
		
		for (Goods good : goodsList) {
			totalPrice+=good.getPrice();
		}
		
		return totalPrice;
	}
}
