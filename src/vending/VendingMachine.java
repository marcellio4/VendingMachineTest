package vending;

import java.util.List;

/**
 * @author Marcel Zacharias
 *
 */
public interface VendingMachine {
	public List<String> refund(Double number, List<String> collectedCoins);

	public void reset();

	public void insertCoin(Coin coin);

	public Double setItemAndGetPrice(Item item);

	public void displayItemsWithPriceAndQuantity();

	public Boolean unsufficientAmountForChange();

	public Double totalAmountCashInventory();

	public Double getCurrentBallance();

	public Boolean unsufficientAmountOfItemsOrCash();
}
