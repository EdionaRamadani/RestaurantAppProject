package org.makerminds.jcoaching.restaurantapp.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidMenuFileException;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Drink;
import org.makerminds.jcoaching.restaurantapp.model.product.Meal;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class MenuImporter {

	public Menu importMenu(String filePath) {
		
		Menu importedMenu = new Menu();
		try {
			//Reading a file
			List<String> fileLines = Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
			for(String menuItemsAsString : fileLines) {
				String[] menuItemStringArray = menuItemsAsString.split(",");
				
				int productId = Integer.valueOf(menuItemStringArray[0]);
				String productName = menuItemStringArray[1];
				double productPrice = Double.valueOf(menuItemStringArray[2]);
				String productCategory = menuItemStringArray[3];
				Product product = null;
				if("meal".equals(productCategory)) {
					product = new Meal(productId, productName, productPrice);
				}else if("drink".equals(productCategory)) {
					boolean sugarFree = Boolean.valueOf(menuItemStringArray[4]);
					product = new Drink(productId, productName, productPrice, sugarFree);
				}else {
					StringBuffer stringBuffer = new StringBuffer();
					stringBuffer.append("The menu file couldn't be proccessed as the file category from product")
					.append(productName).append("is invalid");
					
					throw new InvalidMenuFileException(stringBuffer.toString());
				}
				
				importedMenu.getMenuItems().put(productId, product);
			}
		} catch (IOException | URISyntaxException e) {
			
			throw new RuntimeException("Menu file couldn't be found." , e);
		}
		
		return importedMenu;
		
	}

}

