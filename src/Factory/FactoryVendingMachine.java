package Factory;

import vending.VendingMachine;
import vending.VendingMachineImpl;

/**
 * Create vending machine and set up
 * 
 * @author Marcel Zacharias
 *
 */
public class FactoryVendingMachine {

	public VendingMachine create(Machine machine) {
		return new VendingMachineImpl(machine);
	}

}
