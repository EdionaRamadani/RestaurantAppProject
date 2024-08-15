package org.makerminds.jcoaching.restaurantapp.model;

public class Client {
	
	private String name;
	private String phoneNumber;
	
	public Client (String name, String phoneNumber) {
		setName(name);
		setPhoneNumber(phoneNumber);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
