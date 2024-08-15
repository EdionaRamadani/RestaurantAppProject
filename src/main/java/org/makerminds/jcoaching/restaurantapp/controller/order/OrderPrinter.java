package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderPrinter {

	//global variable
	//deklaru edhe inicializu
	StringBuilder stringBuilder = new StringBuilder();	
	
		
	
	
	public void printOrderInfoHeader(Client client) {
		
		//header		
				stringBuilder.append("Order from: ")
				.append(client.getName()).append(System.lineSeparator())
				.append("Contact number: " + client.getPhoneNumber()).append(System.lineSeparator())
				.append("------------------------").append(System.lineSeparator());
				
	}
	
	public void printOrderItemInfo(OrderItem orderItem) {
		
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		stringBuilder.append(orderItem.getQuantity())
		.append("x |" + product.getId())
		.append(". " + product.getName())
		.append(" | " )
		.append(orderItem.getOrderItemPrice())
		.append(" | " )
		.append(totalOrderItemPrice)
		.append(" Euro. " ).append(System.lineSeparator());
	}
	
	
	public void printOrderInfoFooter(Restaurant restaurant, OrderAmount orderAmount, int vatRate) {
		 //footer
		stringBuilder.append("------------------------").append(System.lineSeparator())
		.append("The price of order is: ").append(System.lineSeparator())
		.append("SUB TOTAL:" )
		.append(orderAmount.getTotalOrderAmount())
		.append("Euro").append(System.lineSeparator());
		stringBuilder.append("VAT ")
		.append(vatRate).append(": ")
		.append(orderAmount.getTotalOrderAmountVAT())
		.append("Euro.").append(System.lineSeparator())
		.append("TOTAL: " + orderAmount.getTotalOrderAmountWithVAT() + "Euro.").append(System.lineSeparator())
		.append("----------------------------").append(System.lineSeparator())
		.append(restaurant.getName() + " in " + restaurant.getAddress()).append(System.lineSeparator());
		System.out.println(stringBuilder);
		
	}
	

}
