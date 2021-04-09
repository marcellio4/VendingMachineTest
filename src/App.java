import Factory.FactoryVendingMachine;
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
		System.out.println("Working ...");
		FactoryVendingMachine factory = new FactoryVendingMachine();
		VendingMachine vendingMachine = factory.create();
	}

}
