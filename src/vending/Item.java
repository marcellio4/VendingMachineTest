package vending;

/**
 * Holds data about created items
 * 
 * @author Marcel Zacharias
 *
 */
public enum Item {
	COKE("Coke", 0.25), PEPSI("Pepsi", 0.35), WATER("Water", 0.15);

	private String name;
	private double price;

	private Item(String name, double price) {
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
