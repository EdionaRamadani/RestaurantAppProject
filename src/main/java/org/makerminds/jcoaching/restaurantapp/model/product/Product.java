package org.makerminds.jcoaching.restaurantapp.model.product;

public class Product {
	
	private int productId;
	private String name;
	private double price;
	
	
	public Product(int productId, String name, double price) {
	
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//getter and setters for Product class
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
