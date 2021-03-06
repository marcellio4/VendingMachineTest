package vending;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class to hold all our Items and Coins
 * 
 * @author Marcel Zacharias
 *
 * @param <T>
 */
public class Inventory<T> {
	private Map<T, Integer> inventory = new HashMap<T, Integer>();

	public int getQuantity(T item) {
		Integer value = inventory.get(item);
		return value == null ? 0 : value;
	}

	public void add(T item) {
		if (!hasItem(item)) {
			throw new IllegalArgumentException("Such item " + item.getClass().getName() + " does not exist!");
		}
		int count = inventory.get(item);
		inventory.put(item, count + 1);
	}

	public void deduct(T item) {
		if (!hasItem(item)) {
			throw new IllegalArgumentException("Such item " + item.getClass().getName() + " does not exist!");
		}
		int count = inventory.get(item);
		inventory.put(item, count - 1);
	}

	public boolean hasItem(T item) {
		return getQuantity(item) > 0;
	}

	public void clear() {
		inventory.clear();
	}

	public void put(T item, int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater then 0!");
		}
		inventory.put(item, quantity);
	}

	public Map<T, Integer> getInventory() {
		return inventory;
	}

}
