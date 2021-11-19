package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<OrderItem> order = new ArrayList<OrderItem>();

	public List<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(OrderItem order) {
		this.order.add(order);
	}

}
