package Factory;

import java.util.ArrayList;
import java.util.List;
import vending.Coin;
import vending.Item;

/**
 * Just helper class to set items and coins
 * 
 * @author Marcel Zacharias
 */
public class Machine {
    private List<Coin> cashIn = new ArrayList<>();
    private List<Item> itemsIn = new ArrayList<>();


    public void setItems() {
        for (Item i : Item.values()) {
            itemsIn.add(i);
        }
    }

    public void setCashIn() {
        for (Coin c : Coin.values()) {
            cashIn.add(c);
        }
    }

    public List<Coin> getCashIn() {
        return cashIn;
    }

    public List<Item> getItemsIn() {
        return itemsIn;
    }

}
