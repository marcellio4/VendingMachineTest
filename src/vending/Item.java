package vending;

/**
 * Holds data about created items 
 * 
 * @param 
 * @author Marcel Zacharias
 *
 */
public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	

}
