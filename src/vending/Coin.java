package vending;

/**
 * Set up our coins used in UK
 * 
 * @author Marcel Zacharias
 *
 */
public enum Coin {

	PENNY(0.01), TWOPENCE(0.02), FIVEPENCE(0.05), TENPENCE(0.10), TWENTYPENCE(0.20), TWENTYFIVEPENCE(0.25),
	FIFTYPENCE(0.50), ONEPOUND(1.00), TWOPOUND(2.00);

	private final Double denomination;

	private Coin(Double denomination) {
		this.denomination = denomination;
	}

	public Double getDenomination() {
		return denomination;
	}

}
