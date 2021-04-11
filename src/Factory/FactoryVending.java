package Factory;

import vending.VendingMachine;

/**
 * @author Marcel Zacharias
 */
public interface FactoryVending {
    public VendingMachine create(Machine machine);
}
