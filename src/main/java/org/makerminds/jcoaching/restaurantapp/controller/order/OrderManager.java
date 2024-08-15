package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Order;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderManager {
	
	private ArrayList<Order> orders = new ArrayList<>();
	private Location currentLocation;
	
	public OrderManager(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	
	public Order createOrder(Menu menu) {
		Order order = new Order();

		addOrder(order, menu.getMenuItems().get(100), OrderItemSize.SMALL, 1 );
		addOrder(order, menu.getMenuItems().get(102), OrderItemSize.MEDIUM, 2 );
		addOrder(order, menu.getMenuItems().get(200), OrderItemSize.LARGE, 1 );
		addOrder(order, menu.getMenuItems().get(300), OrderItemSize.XXL, 3 );
		
		return order;
		
 		}
	
	private void addOrder(Order order, Product product, OrderItemSize orderItemSize, int quantity) {
		
		OrderItem orderItemMeal = createOrderItemMeal(product, orderItemSize, quantity);
		order.getOrderItems().add(orderItemMeal);
	}


	private OrderItem createOrderItemMeal(Product product, OrderItemSize orderItemSize, int quantity) {
		
		return new OrderItem(product, quantity, orderItemSize);
	}
	
	public void calculateAndPrintOrderDetails(Restaurant restaurant, Client client, Order order) {
		//List<Product>
		IOrderCalculator orderCalculator = getOrderCalculator(currentLocation);
		OrderAmount orderAmount = orderCalculator.calculateOrderAmount(order);
		
		OrderPrinter orderPrinter = new OrderPrinter();
		  orderPrinter.printOrderInfoHeader(client);
		  ArrayList<OrderItem> orderItemArrayList = order.getOrderItems();
		  
		  //for each loop
		  for(OrderItem orderItem : orderItemArrayList) {
			  orderPrinter.printOrderItemInfo(orderItem);
		  }
		  int vatRate = (int)(orderCalculator.getVATRate(false));
		  orderPrinter.printOrderInfoFooter(restaurant, orderAmount, vatRate);
	}
	
       private IOrderCalculator getOrderCalculator(Location currentLocation) {
		
		switch(currentLocation) {
		case KOSOVO:
			return new OrderCalculatorKS();
		
		case GERMANY:
			return new OrderCalculatorGER();
			
		default:
			System.err.println("Current location is invalid");
			return null;
		}
		
	}
	
}
