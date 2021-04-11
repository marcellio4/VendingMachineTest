import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Factory.FactoryVendingMachine;
import Factory.Machine;
import vending.Coin;
import vending.Item;
import vending.VendingMachine;

/**
 * @author Marcel Zacharias
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println();
		System.out.println("Initilizing Vending machine ...");
		DecimalFormat formatter = new DecimalFormat("##.00");
		FactoryVendingMachine factory = new FactoryVendingMachine();
		Machine machine = new Machine();
		machine.setCashIn();
		machine.setItems();
		VendingMachine vendingMachine = factory.create(machine);
		System.out.println("Vending machine set up and ready for use.");
		System.out.println();
		char answer = 'y';
		Scanner scanner = new Scanner(System.in);
		Double totalCost = 0.00;
		try {
			while (answer == 'y') {
				vendingMachine.displayItemsWithPriceAndQuantity();

				if (vendingMachine.unsufficientAmountOfItemsOrCash()) {
					System.out.println("Program will Terminate unsufficient Items or cash in the machine!");
					scanner.close();
					return;
				}

				System.out.println();
				System.out.print("Please type your favourite item: ");
				String choosenItem = scanner.nextLine().trim();
				Item item = Item.valueOf(choosenItem.toUpperCase());
				try {
					totalCost += vendingMachine.setItemAndGetPrice(item);
				} catch (Exception e) {
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
				}

				System.out.println("You have choosen: " + choosenItem + " - price: " + item.getPrice());
				System.out.println();
				System.out.println(
						"Accepted coins are: onepound, twopound, fiftypence, twentyfivepence, twentypence, tenpence, fivepence, twopence, penny");
				System.out.println();
				if (vendingMachine.getCurrentBallance() < totalCost) {
					System.out.println("Total inserted amount of coins: "
							+ Double.valueOf(formatter.format(vendingMachine.getCurrentBallance()))
							+ " is not sufficient to purchase your items!");
					System.out.println("Total Cost -> " + Double.valueOf(formatter.format(totalCost)));
					while (true) {
						System.out.print("Please type name of the coin from above to purchase your Item: ");
						String insertedCoin = scanner.nextLine().trim();
						Coin coin = Coin.valueOf(insertedCoin.toUpperCase());
						vendingMachine.insertCoin(coin);
						System.out.println();
						System.out.println("Total inserted amount of coins -> " + vendingMachine.getCurrentBallance());
						if (vendingMachine.getCurrentBallance() >= item.getPrice()) {
							break;
						}
					}
				}

				while (true) {
					System.out.println();
					System.out.print("Would you like to buy another drink? Y/N  ->  ");
					answer = scanner.nextLine().toLowerCase().trim().charAt(0);
					if (answer == 'y' || answer == 'n') {
						break;
					}
				}

			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Program terminate with message -> " + e.getMessage());
			return;
		}

		System.out.println();
		System.out.println(
				"Total inserted coins: " + Double.valueOf(formatter.format(vendingMachine.getCurrentBallance())));
		System.out.println("Total cost is: " + Double.valueOf(formatter.format(totalCost)));
		System.out.println();
		List<String> collectedCoins = new ArrayList<>();
		List<String> change = vendingMachine.refund(vendingMachine.getCurrentBallance() - totalCost, collectedCoins);

		System.out.print("Your change back are: ");
		if (change.isEmpty()) {
			System.out.print("0");
		} else {
			change.forEach(money -> {
				System.out.print(money + " ");
			});
		}

		System.out.println();
		scanner.close();
	}

}
