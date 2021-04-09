package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vending.Coin;

/**
 * 
 * @author Marcel Zacharias
 *
 */
public class CoinTest {

	@Test
	public void testCoinValues() {
		Double penny = 0.01, twoPence = 0.02, fivePence = 0.05, tenPence = 0.10, twentyPence = 0.20,
				twentyFivePence = 0.25, fiftyPence = 0.50, onePound = 1.00, twoPound = 2.00;
		assertEquals(penny, Coin.PENNY.getDenomination());
		assertEquals(twoPence, Coin.TWOPENCE.getDenomination());
		assertEquals(fivePence, Coin.FIVEPENCE.getDenomination());
		assertEquals(tenPence, Coin.TENPENCE.getDenomination());
		assertEquals(twentyPence, Coin.TWENTYPENCE.getDenomination());
		assertEquals(twentyFivePence, Coin.TWENTYFIVEPENCE.getDenomination());
		assertEquals(fiftyPence, Coin.FIFTYPENCE.getDenomination());
		assertEquals(onePound, Coin.ONEPOUND.getDenomination());
		assertEquals(twoPound, Coin.TWOPOUND.getDenomination());
	}

	@Test
	public void testGetDenominationIsTypeOfDouble() {
		assertSame(Double.class, Coin.TWENTYPENCE.getDenomination().getClass());
	}

}
