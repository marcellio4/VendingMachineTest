package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vending.Inventory;
import vending.Item;

/**
 * 
 * @author Marcel Zacharias
 *
 */
public class InventoryTest {
	private Inventory<Item> itemInventory;

	@Before
	public void setUp() throws Exception {
		itemInventory = new Inventory<Item>();
	}

	@Test
	public void testGetQuantity() {
		Item item = new Item("Pepsi", 0.25);
		itemInventory.put(item, 5);
		assertEquals(5, itemInventory.getQuantity(item));
	}

	@Test
	public void testAdd() {
		Item item = new Item("Pepsi", 0.25);
		itemInventory.put(item, 1);
		itemInventory.add(item);
		assertEquals(2, itemInventory.getQuantity(item));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddThrowException() {
		Item item = new Item("Water", 0.25);
		itemInventory.add(item);
	}

	@Test
	public void testDeduct() {
		Item item = new Item("Pepsi", 0.25);
		itemInventory.put(item, 2);
		itemInventory.deduct(item);
		assertEquals(1, itemInventory.getQuantity(item));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeductThrowException() {
		Item item = new Item("Water", 0.25);
		itemInventory.deduct(item);
	}

	@Test
	public void testHasItem() {
		Item item = new Item("Pepsi", 0.25);
		itemInventory.put(item, 1);
		assertTrue(itemInventory.hasItem(item));
	}

	@Test
	public void testClear() {
		Item item = new Item("Pepsi", 0.25);
		itemInventory.put(item, 1);
		assertTrue(itemInventory.hasItem(item));
		itemInventory.clear();
		assertFalse(itemInventory.hasItem(item));
	}

	@Test
	public void testPut() {
		Item item = new Item("Pepsi", 0.25);
		itemInventory.put(item, 1);
		assertTrue(itemInventory.hasItem(item));
		assertFalse(itemInventory.hasItem(new Item("Water", 0.10)));
	}

}
