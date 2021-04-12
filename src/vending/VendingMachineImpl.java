package vending;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import Factory.Machine;

/**
 * Vending machine with implementation
 * 
 * @param cashInventory  {@link Inventory} holds all coins that are set from
 *                       other machine
 * @param itemInventory  {@link Inventory} holds all coins that are set from
 *                       other machine
 * @param currentBalance {@link Double} number that holds all money inserted by
 *                       the user
 * @param currentItem    {@link Item} holds current item that is inserted from
 *                       user
 * @author Marcel Zacharias
 */
public class VendingMachineImpl implements VendingMachine {
	private Inventory<Coin> cashInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();
	private double currentBalance;
	private Item currentItem;

	public VendingMachineImpl(Machine machine) {
		initialize(machine);
	}

	/**
	 * Starting point to set up vending machine for all items and coins that are set
	 * in Machine
	 * 
	 * @param machine
	 */
	private void initialize(Machine machine) {
		machine.getCashIn().forEach(cash -> {
			cashInventory.put(cash, 6);
		});

		machine.getItemsIn().forEach(item -> {
			itemInventory.put(item, 6);
		});

	}

	/**
	 * @param number         {@link Double} deducted number from total cost and
	 *                       total inserted coins
	 * @param collectedCoins {@link List} to collect string coins for display
	 * @return {@link List}
	 */
	@Override
	public List<String> refund(Double number, List<String> collectedCoins) {
		DecimalFormat formatter = new DecimalFormat("##.00");
		number = Double.valueOf(formatter.format(number));

		if (number >= Coin.TWOPOUND.getDenomination() && cashInventory.hasItem(Coin.TWOPOUND)) {
			cashInventory.deduct(Coin.TWOPOUND);
			collectedCoins.add("£2");
			refund((number - Coin.TWOPOUND.getDenomination()), collectedCoins);
		} else if (number >= Coin.ONEPOUND.getDenomination() && cashInventory.hasItem(Coin.ONEPOUND)) {
			cashInventory.deduct(Coin.ONEPOUND);
			collectedCoins.add("£1");
			refund((number - Coin.ONEPOUND.getDenomination()), collectedCoins);
		} else if (number >= Coin.FIFTYPENCE.getDenomination() && cashInventory.hasItem(Coin.FIFTYPENCE)) {
			cashInventory.deduct(Coin.FIFTYPENCE);
			collectedCoins.add("50p");
			refund((number - Coin.FIFTYPENCE.getDenomination()), collectedCoins);
		} else if (number >= Coin.TWENTYFIVEPENCE.getDenomination() && cashInventory.hasItem(Coin.TWENTYFIVEPENCE)) {
			cashInventory.deduct(Coin.TWENTYFIVEPENCE);
			collectedCoins.add("25p");
			refund((number - Coin.TWENTYFIVEPENCE.getDenomination()), collectedCoins);
		} else if (number >= Coin.TWENTYPENCE.getDenomination() && cashInventory.hasItem(Coin.TWENTYPENCE)) {
			cashInventory.deduct(Coin.TWENTYPENCE);
			collectedCoins.add("20p");
			refund((number - Coin.TWENTYPENCE.getDenomination()), collectedCoins);
		} else if (number >= Coin.TENPENCE.getDenomination() && cashInventory.hasItem(Coin.TENPENCE)) {
			cashInventory.deduct(Coin.TENPENCE);
			collectedCoins.add("10p");
			refund((number - Coin.TENPENCE.getDenomination()), collectedCoins);
		} else if (number >= Coin.FIVEPENCE.getDenomination() && cashInventory.hasItem(Coin.FIVEPENCE)) {
			cashInventory.deduct(Coin.FIVEPENCE);
			collectedCoins.add("5p");
			refund((number - Coin.FIVEPENCE.getDenomination()), collectedCoins);
		} else if (number >= Coin.TWOPENCE.getDenomination() && cashInventory.hasItem(Coin.TWOPENCE)) {
			cashInventory.deduct(Coin.TWOPENCE);
			collectedCoins.add("2p");
			refund((number - Coin.TWOPENCE.getDenomination()), collectedCoins);
		} else if (number >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
			cashInventory.deduct(Coin.PENNY);
			collectedCoins.add("1p");
			refund((number - Coin.PENNY.getDenomination()), collectedCoins);
		}
		return collectedCoins;
	}

	@Override
	public void reset() {
		currentBalance = 0;
		currentItem = null;
	}

	/**
	 * Insert coin into our inventory and add to current balance
	 * 
	 * @param coin {@link Coin}
	 */
	@Override
	public void insertCoin(Coin coin) {
		currentBalance += coin.getDenomination();
		cashInventory.add(coin);
	}

	/**
	 * Set inserted item and deduct from our inventory
	 * 
	 * @param item {@link Item}
	 * @return {@link Double} price of the item
	 */
	@Override
	public Double setItemAndGetPrice(Item item) {
		if (itemInventory.hasItem(item)) {
			currentItem = item;
			itemInventory.deduct(item);
			return currentItem.getPrice();
		}
		throw new IllegalArgumentException("Sold Out, Please buy another item!");
	}

	/**
	 * Calculate all coins that exist inside the vending machine
	 * 
	 * @return {@link Double}
	 */
	@Override
	public Double totalAmountCashInventory() {
		ArrayList<Double> total = new ArrayList<>();
		cashInventory.getInventory().forEach((coin, quantity) -> {
			double price = coin.getDenomination() * quantity;
			total.add(price);
		});

		return total.stream().mapToDouble(d -> d).sum();
	}

	/**
	 * Check if vending machine have enough money in inventory for change
	 * 
	 * @param insertedTotalCash
	 * @return Boolean
	 */
	@Override
	public Boolean unsufficientAmountForChange() {
		return (currentBalance > totalAmountCashInventory());
	}

	/**
	 * Display all information about our items available in vending machine
	 */
	@Override
	public void displayItemsWithPriceAndQuantity() {
		System.out.printf("%s%15s%15s", "Products", "Price", "Quantity");
		System.out.println();

		itemInventory.getInventory().forEach((item, quantity) -> {
			System.out.printf("%5s%18s%12s", item.getName(), item.getPrice(), quantity);
			System.out.println();
		});

	}

	/**
	 * @return {@link Double} all inserted coins from client
	 */
	@Override
	public Double getCurrentBallance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double num) {
		currentBalance = num;
	}

	public Inventory<Coin> getCashInventory() {
		return cashInventory;
	}

	public Inventory<Item> getItemInventory() {
		return itemInventory;
	}

	public Item getCurrentItem() {
		return currentItem;
	}

	/**
	 * Check if there are any itmes left to sell or any cash coins for change left
	 */
	@Override
	public Boolean unsufficientAmountOfItemsOrCash() {
		return (itemInventory.getInventory().isEmpty() || cashInventory.getInventory().isEmpty());
	}

}
