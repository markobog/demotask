package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskDemoApplicationTests {
		
    @Test
    void assertNumberOfItemsInMap_true() {
        assertEquals(8, TaskDemoApplication.orderItems.size());
    }

    @Test
    void assertNumberOfItemsInMap_false() {
    	assertNotEquals(7, TaskDemoApplication.orderItems.size());
    }
    
    @Test
    void testExpectedExceptionWithParentType() {
    	assertThrows(AssertionFailedError.class, () -> {
    		assertEquals(7, TaskDemoApplication.orderItems.size());
    	});
    }
    
}
