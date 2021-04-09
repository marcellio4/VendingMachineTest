package vending;

import java.util.List;

/**
 * 
 * 
 * @author Marcel Zacharias
 *
 */
public class VendingMachineImpl implements VendingMachine {
	private Inventory<Coin> cashInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();

	@Override
	public List<Coin> refund(float number, List<Coin> collectedCoins) {
		// TODO Auto-generated method stub
		return collectedCoins;
	}

	@Override
	public List<Coin> insertedCoins(Coin coin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coin> withdrawCoins() {
		// TODO Auto-generated method stub
		return null;
	}

}
