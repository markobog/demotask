package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.StampCard;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskDemoApplication  implements ApplicationRunner{
	
	private static final Map<Integer, OrderItem> orderItems = new HashMap<>();
	static {
		orderItems.put(1, new OrderItem(1, "Small coffee", new BigDecimal("2.5")));
		orderItems.put(2, new OrderItem(1, "Medium coffee", new BigDecimal("3.0")));
		orderItems.put(3, new OrderItem(1, "Large coffee", new BigDecimal("3.5")));
		orderItems.put(4, new OrderItem(2, "Bacon roll", new BigDecimal("4.5")));
		orderItems.put(5, new OrderItem(1, "Freshly squeezed orange juice (0.25l)", new BigDecimal("3.95")));
		orderItems.put(6, new OrderItem(3, "Extra milk", new BigDecimal("0.3")));
		orderItems.put(7, new OrderItem(3, "Foamed milk", new BigDecimal("0.5")));
		orderItems.put(8, new OrderItem(3, "Special roast coffee", new BigDecimal("0.9")));

	}

	public static void main(String[] args) {
		SpringApplication.run(TaskDemoApplication.class, args);
	}
	
    @Override
    public void run( ApplicationArguments arguments ) throws Exception
    {
		Order order = new Order();
		StampCard stampCard = new StampCard();
		int beverages = 0;
		int snacks = 0;
		int extras = 0;
		String[] args = arguments.getSourceArgs();

		try {
			for (int i = 0; i < args.length - 1; i++) {
				if (args[i].equalsIgnoreCase("--spring.output.ansi.enabled=always")) continue;
				OrderItem orderItem = orderItems.get(Integer.parseInt(args[i]));
				order.setOrder(orderItem);
				if (orderItem.getTypeOfItem() == 1)
					beverages++;
				if (orderItem.getTypeOfItem() == 2)
					snacks++;
				if (orderItem.getTypeOfItem() == 3)
					extras++;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Order values must be integers: " + nfe.getMessage());
		}

		try {
			if(args.length>0)
				stampCard.setNumberOfBeverages(Integer.parseInt(args[args.length - 1]));
		} catch (NumberFormatException nfe) {
			System.out.println("Number of stamps must be integer: " + nfe.getMessage());
		}
		calculateBill(order, stampCard, beverages, snacks, extras);
	}

	private static void calculateBill(Order order, StampCard stampCard, int beverages, int snacks, int extras) {
		List<String> billString = new ArrayList<String>();
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (int i = 0; i < order.getOrder().size(); i++) {
			OrderItem orderItem = order.getOrder().get(i);
			if (orderItem.getTypeOfItem() == 1) {
				stampCard.setNumberOfBeverages(stampCard.getNumberOfBeverages() + 1);
				if (stampCard.getNumberOfBeverages() == 5) {
					billString.add("Item: " + orderItem.getNameOfItem() + " price: " + BigDecimal.ZERO);
					stampCard.setNumberOfBeverages(0);
				} else {
					billString.add("Item: " + orderItem.getNameOfItem() + " price: " + orderItem.getPrice());
					totalPrice = totalPrice.add(orderItem.getPrice());
				}
			} else if (orderItem.getTypeOfItem() == 2 || orderItem.getTypeOfItem() == 3) {
				if (beverages > 0 && snacks > 0) {
					if (orderItem.getTypeOfItem() == 3) {
						billString.add("Item: " + orderItem.getNameOfItem() + " price: " + BigDecimal.ZERO);
						beverages--;
						snacks--;
					} else {
						billString.add("Item: " + orderItem.getNameOfItem() + " price: " + orderItem.getPrice());
						totalPrice = totalPrice.add(orderItem.getPrice());
					}
				}
			}
		}
		for (int i = 0; i < billString.size(); i++) {
			System.out.println(billString.get(i));
		}
		System.out.println("Total: " + totalPrice);
	}
	
}