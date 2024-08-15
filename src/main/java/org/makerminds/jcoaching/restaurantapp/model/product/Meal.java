package org.makerminds.jcoaching.restaurantapp.model.product;

public class Meal extends Product {
	
	private String description;
	
	public Meal (int id, String name, double price) {
		super(id, name, price);
	}
	
	public Meal (int id,  String name, double price, String description) {
		this(id,name,price);
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


}
