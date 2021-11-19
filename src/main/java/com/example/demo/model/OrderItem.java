package com.example.demo.model;

import java.math.BigDecimal;

public class OrderItem {
	
	public OrderItem(int typeOfItem, String nameOfItem, BigDecimal price) {
		this.typeOfItem = typeOfItem;
		this.nameOfItem = nameOfItem;
		this.price = price;
	}
	
	private int typeOfItem;		//	1 beverage, 2 snack, 3 extras
	private String nameOfItem;
	private BigDecimal price;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getTypeOfItem() {
		return typeOfItem;
	}
	public void setTypeOfItem(int typeOfItem) {
		this.typeOfItem = typeOfItem;
	}
	public String getNameOfItem() {
		return nameOfItem;
	}
	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}

}
