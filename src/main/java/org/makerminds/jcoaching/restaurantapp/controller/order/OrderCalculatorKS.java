package org.makerminds.jcoaching.restaurantapp.controller.order;


import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeExceptions;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;


public class OrderCalculatorKS extends AbstractOrderCalculator {
	
	private final double VAT_RATE = 0.18; 
	
	@Override
	public double getSizeRateAmount(OrderItemSize orderItemSize) {
		
		switch(orderItemSize) {
		case SMALL:
			return 0.75;
		case MEDIUM:
			return 1;
		case LARGE:
			return 1.25;
		case XXL:
			return 1.3;
			default:
				
				throw new InvalidOrderItemSizeExceptions("Invalid order item size");
				
			
		}
	
	}

	@Override
	public double getVATRate() {
		return VAT_RATE;
	}

}
