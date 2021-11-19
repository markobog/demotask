package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.OrderItem;

@SpringBootTest
class TaskDemoApplicationTests {
	
	private Map<Integer, OrderItem> orderItems = new HashMap<>();

	@BeforeEach
	void initializeMap(){
		orderItems.put(1, new OrderItem(1, "Small coffee", new BigDecimal("2.5")));
		orderItems.put(2, new OrderItem(1, "Medium coffee", new BigDecimal("3.0")));
		orderItems.put(3, new OrderItem(1, "Large coffee", new BigDecimal("3.5")));
		orderItems.put(4, new OrderItem(2, "Bacon roll", new BigDecimal("4.5")));
		orderItems.put(5, new OrderItem(1, "Freshly squeezed orange juice (0.25l)", new BigDecimal("3.95")));
		orderItems.put(6, new OrderItem(3, "Extra milk", new BigDecimal("0.3")));
		orderItems.put(7, new OrderItem(3, "Foamed milk", new BigDecimal("0.5")));
		orderItems.put(8, new OrderItem(3, "Special roast coffee", new BigDecimal("0.9")));
	}
	
    @Test
    void assertNumberOfItemsInMap_true() {
        assertEquals(8, orderItems.size());
    }

    @Test
    void assertNumberOfItemsInMap_false() {
        assertEquals(7, orderItems.size());
    }
    
}
