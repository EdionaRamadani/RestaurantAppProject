package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeExceptions;
import org.makerminds.jcoaching.restaurantapp.model.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public abstract class AbstractOrderCalculator implements IOrderCalculator {
	
	public AbstractOrderCalculator() {
		
	}
	
	public double calculateTotalOrderAmount (Order order) {
		//switched from array to arraylist
		List<OrderItem> orderItems = order.getOrderItems();
		
		double totalOrderAmount = orderItems.stream()
				.mapToDouble(this::calculateOrderItemPrice)
                .sum();
		
		return totalOrderAmount;
		
	}
	
	 public double calculateOrderItemPrice(OrderItem orderItem) {
		 
		 double sizeRateAmount = 1;
		 try {
	     sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		 }
		 catch(InvalidOrderItemSizeExceptions e) {
			 System.out.println("No valid order item size for " + orderItem.getProduct().getName() + ". Default size rate amount (100%) will be applied.");
		 }
	    	Product product = orderItem.getProduct();
	    	double totalOrderItemPriceSingle = product.getPrice() * sizeRateAmount;
	    	orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
	    	
	    	return totalOrderItemPriceSingle * orderItem.getQuantity();
	    }
	 
	 public abstract double getSizeRateAmount(OrderItemSize orderItemSize);

	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
			
			return totalOrderAmount * getVATRate();
		}
	
	public double getVATRate(boolean decimal ) {
		if(decimal) {
			return getVATRate();
		}
		else 
		{
			return getVATRate() * 100;
		}
	}
	
	public abstract double getVATRate();
		
	 public OrderAmount calculateOrderAmount(Order order) {
			
			double totalOrderAmount = calculateTotalOrderAmount(order);
			
			double totalOrderAmountVAT = calculateTotalOrderAmountVAT(totalOrderAmount);
			
			double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
			
			OrderAmount orderAmount = new OrderAmount(totalOrderAmount, totalOrderAmountVAT, totalOrderAmountWithVAT);
			
			return orderAmount;
		}

}
