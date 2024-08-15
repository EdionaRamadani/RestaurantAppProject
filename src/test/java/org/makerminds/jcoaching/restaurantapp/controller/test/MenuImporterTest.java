package org.makerminds.jcoaching.restaurantapp.controller.test;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.controller.MenuImporter;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class MenuImporterTest {
	
	
	private final String MENU_FILE_PATH = "/menu-file.txt";
	
	@Test
	//Testing 
	public void testImportMenu() {
		MenuImporter menuImporterMock = new MenuImporter();
		Menu importedMenu = menuImporterMock.importMenu(MENU_FILE_PATH);
		HashMap<Integer, Product> menuItems = importedMenu.getMenuItems();
		Assertions.assertEquals(8, menuItems.size());
	}

}
