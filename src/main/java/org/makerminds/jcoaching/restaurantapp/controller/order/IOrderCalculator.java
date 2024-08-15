package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeExceptions;
import org.makerminds.jcoaching.restaurantapp.model.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public interface IOrderCalculator {

	public double calculateTotalOrderAmount (Order order);
	public double calculateOrderItemPrice(OrderItem orderItem);
	public abstract double getSizeRateAmount(OrderItemSize orderItemSize);
	public double calculateTotalOrderAmountVAT(double totalOrderAmount);
	public double getVATRate(boolean decimal);
	public OrderAmount calculateOrderAmount(Order order);
}
