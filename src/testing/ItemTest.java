package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vending.Coin;
import vending.Item;

public class ItemTest {

	private Item item;

	@Before
	public void setUp() throws Exception {
		item = new Item("Pepsi", 0.25);
	}

	@Test
	public void testGetName() {
		assertEquals("Pepsi", item.getName());
		assertTrue("Coke" != item.getName());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(0.25, item.getPrice(), 0.25);
	}

}
