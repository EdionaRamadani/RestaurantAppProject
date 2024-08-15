package org.makerminds.jcoaching.restaurantapp.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderCalculatorKS;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorKSTest {
	
	//Mock 
	OrderCalculatorKS orderCalculatorKSMock = new OrderCalculatorKS();
	
	@Test
	public void getVATRateTest() {
		
		
		double vatRate = orderCalculatorKSMock.getVATRate();
		
		Assertions.assertEquals(0.18, vatRate);
	}
	
	@Test
	public void getSizeRateAmountTest() {
		
		double sizeRateAmountSmall = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.75, sizeRateAmountSmall);
		
		double sizeRateAmountMedium = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1, sizeRateAmountMedium);
		
		double sizeRateAmountLarge = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.25, sizeRateAmountLarge);
		
		double sizeRateAmountXXL = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.3, sizeRateAmountXXL);
	}

}
