package org.makerminds.jcoaching.restaurantapp.model.product;

public class Drink extends Product {
	
	private boolean sugarFree;
	
	public Drink(int id, String name, double price) {
		super(id, name, price);
	}
	
	public Drink(int id, String name, double price, boolean sugarFree) {
		this(id, name, price);
		this.sugarFree = sugarFree;
	}
	
	public boolean isSugarFree() {
		return sugarFree;
	}
	
	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}
	

}
