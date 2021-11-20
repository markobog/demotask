package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Order;
import com.example.demo.model.StampCard;

@SpringBootTest
class TaskDemoApplicationTests {
	
	  @Autowired
	  ApplicationArguments args;
		
    @Test
    void assertNumberOfItemsInMap_true() {
        assertEquals(8, TaskDemoApplication.orderItems.size());
    }

    @Test
    void assertNumberOfItemsInMap_false() {
    	assertNotEquals(7, TaskDemoApplication.orderItems.size());
    }
    
    @Test
    void testExpectedException_AssertionFailedError() {
    	assertThrows(AssertionFailedError.class, () -> {
    		assertEquals(7, TaskDemoApplication.orderItems.size());
    	});
    }
    
    @Test
    void testCalculateBill_runsOnce() {
    	TaskDemoApplication app = mock(TaskDemoApplication.class);
    	Order order = new Order();
    	order.setOrder(TaskDemoApplication.orderItems.get(1));
    	StampCard stampCard = new StampCard();
    	stampCard.setNumberOfBeverages(1);
    	verify(app, times(1)).calculateBill(order, stampCard, 1, 1, 1); 
    }
    
    @Test
    void testRun_runsOnce() throws Exception {
    	TaskDemoApplication app = mock(TaskDemoApplication.class);
    	verify(app, times(0)).run(args); 
    }
    
}
    