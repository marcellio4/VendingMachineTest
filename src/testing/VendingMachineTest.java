package testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import Factory.Machine;
import vending.Coin;
import vending.Item;
import vending.VendingMachineImpl;

/**
 * @author Marcel Zacharias
 */
public class VendingMachineTest {

    private Machine machine;
    private VendingMachineImpl vm;

    @Before
    public void setUp() {
        machine = new Machine();
        machine.setCashIn();
        machine.setItems();
        vm = new VendingMachineImpl(machine);
    }

    @Test
    public void testTotalAmountCashInventory() {
        machine.setCashIn();
        Double total = vm.totalAmountCashInventory();
        assertTrue(24.78 == total);
    }

    @Test
    public void testRefund() {
        List<String> expected = new ArrayList<>();
        expected.add("£1");
        expected.add("25p");
        expected.add("1p");
        List<String> collectedCoins = new ArrayList<>();
        assertEquals(expected, vm.refund(1.26, collectedCoins));
    }

    @Test
    public void testInsertCoin() {
        vm.insertCoin(Coin.FIFTYPENCE);
        assertEquals(7, vm.getCashInventory().getQuantity(Coin.FIFTYPENCE));
        assertTrue(0.50 == vm.getCurrentBallance());
    }

    @Test
    public void testSetItemAndGetPrice() {
        assertTrue(0.35 == vm.setItemAndGetPrice(Item.PEPSI));
        assertEquals(5, vm.getItemInventory().getQuantity(Item.PEPSI));
        assertEquals(Item.PEPSI, vm.getCurrentItem());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetItemAndGetPriceThrowException() {
        for (int i = 0; i < 6; i++) {
            vm.getItemInventory().deduct(Item.COKE);
        }
        vm.setItemAndGetPrice(Item.COKE);
    }

    @Test
    public void testUnsufficientAmountForChange() {
        System.out.println(vm.getCurrentBallance());
        assertFalse(vm.unsufficientAmountForChange());
        vm.reset();
        vm.getCashInventory().put(Coin.ONEPOUND, 1);
        vm.insertCoin(Coin.ONEPOUND);
        vm.setCurrentBalance(3.0);
        assertTrue(vm.unsufficientAmountForChange());
    }

    @Test
    public void testGetCurrentBallance() {
        assertTrue(0.00 == vm.getCurrentBallance());
    }
}
