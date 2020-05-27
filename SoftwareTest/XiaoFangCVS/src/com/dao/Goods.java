package com.dao;

public class Goods {

	private String name;
	private float price;
	
	public Goods() {
		super();
	}
	
	public Goods(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
