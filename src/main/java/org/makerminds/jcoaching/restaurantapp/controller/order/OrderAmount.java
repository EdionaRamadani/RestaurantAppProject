package org.makerminds.jcoaching.restaurantapp.controller.order;

public class OrderAmount {
	
	private double totalOrderAmount;
	private double totalOrderAmountVAT;
	private double totalOrderAmountWithVAT;
	
	public OrderAmount(double totalOrderAmount, double totalOrderAmountVAT, double totalOrderAmountWithVAT) {
		
		this.totalOrderAmount = totalOrderAmount;
		this.totalOrderAmountVAT = totalOrderAmountVAT;
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
		
	}
	
	//set nuk ka return ne metoden set
	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}
	
	//get
	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public double getTotalOrderAmountVAT() {
		return totalOrderAmountVAT;
	}

	public void setTotalOrderAmountVAT(double totalOrderAmountVAT) {
		this.totalOrderAmountVAT = totalOrderAmountVAT;
	}

	public double getTotalOrderAmountWithVAT() {
		return totalOrderAmountWithVAT;
	}

	public void setTotalOrderAmountWithVAT(double totalOrderAmountWithVAT) {
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}
	
	//generate getters and setters alt shift s 
      
}
