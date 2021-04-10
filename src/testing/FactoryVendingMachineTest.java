package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import Factory.FactoryVendingMachine;
import Factory.Machine;
import vending.VendingMachine;
import vending.VendingMachineImpl;

public class FactoryVendingMachineTest {

	@Test
	public void testCreateVendingMachine() {
		FactoryVendingMachine factory = new FactoryVendingMachine();
		Machine machine = new Machine();
		VendingMachine vm = factory.create(machine);
		assertTrue(vm.getClass().isInstance(vm));
		assertEquals(VendingMachineImpl.class, vm.getClass());
	}

}
