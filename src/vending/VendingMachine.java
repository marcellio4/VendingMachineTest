package vending;

import java.util.List;

/**
 * @author Marcel Zacharias
 *
 */
public interface VendingMachine {
	public List<Coin> refund(float number, List<Coin> collectedCoins);
	public List<Coin> insertedCoins(Coin coin);
	public List<Coin> withdrawCoins();
}
