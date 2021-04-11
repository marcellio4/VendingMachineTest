package Factory;

import vending.VendingMachine;
import vending.VendingMachineImpl;

/**
 * Create vending machine
 * 
 * @author Marcel Zacharias
 *
 */
public class FactoryVendingMachine implements FactoryVending {

	@Override
	public VendingMachine create(Machine machine) {
		return new VendingMachineImpl(machine);
	}

}
