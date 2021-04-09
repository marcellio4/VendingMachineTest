package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Factory.FactoryVendingMachine;
import vending.VendingMachine;
import vending.VendingMachineImpl;

public class FactoryVendingMachineTest {

	@Test
	public void testCreateVendingMachine() {
		FactoryVendingMachine factory = new FactoryVendingMachine();
		VendingMachine vm = factory.create();
		assertTrue(vm.getClass().isInstance(vm));
		assertEquals(VendingMachineImpl.class, vm.getClass());
	}

}
