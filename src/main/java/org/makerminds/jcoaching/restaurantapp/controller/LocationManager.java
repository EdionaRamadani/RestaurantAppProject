package org.makerminds.jcoaching.restaurantapp.controller;

import org.makerminds.jcoaching.restaurantapp.model.enums.Location;

public class LocationManager {
	
	public static Location getLocationFromId(int locationId) {
		
		switch (locationId) {
		case 1: {
			
			return Location.KOSOVO;
		}
        case 2: {
			
			return Location.GERMANY;
		}
		default:
		
		throw new IllegalArgumentException("Invalid Location");		
	}
	}
}
