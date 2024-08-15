package org.makerminds.jcoaching.restaurantapp.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.controller.order.AbstractOrderCalculator;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Drink;
import org.makerminds.jcoaching.restaurantapp.model.product.Meal;

public class AbstractOrderCalculatorTest {
	
	Menu menu = new Menu();
	
	//1. create Mock object
	AbstractOrderCalculator abstractOrderCalculatorMock = new AbstractOrderCalculator() {
		
		@Override
		public double getVATRate() {
			return 0.12;
		}
		
		@Override
		public double getSizeRateAmount(OrderItemSize orderItemSize) {
			return 1;
		}
		
		
	};
	
	@Test
	public void calculateOrderItemPriceTest() {
		
		//2.create elements that we need for our method 
		Meal hamburger = (Meal) menu.getMenuItems().get(100);
		OrderItem orderItem = new OrderItem(hamburger, 2, OrderItemSize.MEDIUM);
		
		//3.calculate the method that need to be tested
		double totalOrderItemPrice = abstractOrderCalculatorMock.calculateOrderItemPrice(orderItem);
		
		//4.validate the results
		Assertions.assertEquals(9, totalOrderItemPrice);
		Assertions.assertEquals(4.5, orderItem.getOrderItemPrice());
		
	}
	
	@Test
	public void calculateTotalOrderAmountTest() {
		
		//step 2
		Meal hamburger = (Meal) menu.getMenuItems().get(100);
		OrderItem orderItem1 = new OrderItem(hamburger, 1, OrderItemSize.MEDIUM);
		Meal sandwich = (Meal) menu.getMenuItems().get(102);
		OrderItem orderItem2 = new OrderItem(sandwich, 1, OrderItemSize.MEDIUM);
		Drink cocacola = (Drink) menu.getMenuItems().get(200);
		OrderItem orderItem3 = new OrderItem(cocacola, 2, OrderItemSize.MEDIUM);
		Meal iceCream = (Meal) menu.getMenuItems().get(300);
		OrderItem orderItem4 = new OrderItem(iceCream, 2, OrderItemSize.MEDIUM);
		Order order = new Order();
		order.getOrderItems().add(orderItem1);
		order.getOrderItems().add(orderItem2);
		order.getOrderItems().add(orderItem3);
		order.getOrderItems().add(orderItem4);
		
		//step 3
		double totalOrderAmount = abstractOrderCalculatorMock.calculateTotalOrderAmount(order);
		
		//step 4
		Assertions.assertEquals(12, totalOrderAmount);
		
	}
	
	@Test
	public void calculateTotalOrderAmountVATTest() {
		
		//step 2
				Meal hamburger = (Meal) menu.getMenuItems().get(100);
				OrderItem orderItem1 = new OrderItem(hamburger, 1, OrderItemSize.MEDIUM);
				Meal sandwich = (Meal) menu.getMenuItems().get(102);
				OrderItem orderItem2 = new OrderItem(sandwich, 1, OrderItemSize.MEDIUM);
				Drink cocacola = (Drink) menu.getMenuItems().get(200);
				OrderItem orderItem3 = new OrderItem(cocacola, 2, OrderItemSize.MEDIUM);
				Meal iceCream = (Meal) menu.getMenuItems().get(300);
				OrderItem orderItem4 = new OrderItem(iceCream, 2, OrderItemSize.MEDIUM);
				Order order = new Order();
				order.getOrderItems().add(orderItem1);
				order.getOrderItems().add(orderItem2);
				order.getOrderItems().add(orderItem3);
				order.getOrderItems().add(orderItem4);
				
				double totalOrderAmount = abstractOrderCalculatorMock.calculateTotalOrderAmount(order);
				
				//Step 3
				double totalOrderAmountVat = abstractOrderCalculatorMock.calculateTotalOrderAmountVAT(totalOrderAmount);
				
				//Step 4
				Assertions.assertEquals(1.44, totalOrderAmountVat);
		
		
	}

}
