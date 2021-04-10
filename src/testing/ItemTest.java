package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import vending.Item;

public class ItemTest {

	@Test
	public void testGetName() {
		assertEquals("Pepsi", Item.PEPSI.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(0.35, Item.PEPSI.getPrice(), 0.35);
	}

}
