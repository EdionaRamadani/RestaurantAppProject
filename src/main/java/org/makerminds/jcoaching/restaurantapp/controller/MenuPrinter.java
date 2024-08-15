package org.makerminds.jcoaching.restaurantapp.controller;

import java.util.Map.Entry;

import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class MenuPrinter {
	
	public void printMenu(Menu menu) {
		System.out.println("-------------Menu--------------");
		for(Entry<Integer, Product> menuEntry : menu.getMenuItems().entrySet()) {
			Product menuItem = menuEntry.getValue();
			System.out.println(menuItem.getId() + " . " + menuItem.getName() + " | " + menuItem.getPrice() + " Euro ");
		}
		System.out.println("--------------------------------");
		System.out.println("");
	}
	
}
