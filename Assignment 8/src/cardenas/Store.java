package cardenas;

import java.util.HashMap;
import java.util.Map;

public class Store {
	
	private Map<Integer, Textbook> inventory;
	
	public Store() {
		inventory = new HashMap<>();
	}
	
	public String addTextbook(int sku, String title, double price, int quantity) {
		//Checks if there is a textbook with same sku number
		if(inventory.containsKey(sku)){
			return "Error! This book is already in system!";
		}
		
		//Makes sure price is more than 0
		if(price <= 0) {
			return "Error! Price is less than or equal to 0";
		}
		
		//Makes sure if quantity is greater than or equal to 0
		if(quantity < 0) {
			return "Error! Quantity is less than 0";
		}
		
		//Adds textbook into inventory
		inventory.put(sku,new Textbook(sku,title,price,quantity));
		return "Textbook successfully added to inventory!";
	}
	
	public String removeTextbook(int sku) {
		//Checks if textbook is in inventory
		if(inventory.containsKey(sku)) {
			inventory.remove(sku);
			return "Textbook successfully removed from Inventory!";
		}
		// Error if textbook is not in Inventory
		else if(!inventory.containsKey(sku)) {
			return "Error! Textbook is not in Inventory";
		}
		// Error if anything happens
		else
			return "Error!";
	}
	
	//Outputs the toString of textbook with the sku number is given
	public String infoTextbook(int sku) {
		//Checks if inventory is empty
		if(inventory.isEmpty()){
			return "Error! Inventory is empty!";
		}
		//Outputs toString if sku is found in inventory
		else if(inventory.containsKey(sku)){
			Textbook book = inventory.get(sku);
			return book.toString();
		}
		else
			return "Error! There is an error!";
			
	}
	
	
	//Displays all that is in inventory
	public Map<Integer, Textbook> displayAll() {
		return inventory;
			
	}
	
	
	
}
