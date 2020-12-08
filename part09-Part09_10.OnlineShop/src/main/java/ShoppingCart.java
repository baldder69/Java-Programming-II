
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (items.containsKey(product)) {
            Item item = items.get(product);
            item.increaseQuantity();
        } else {
            Item item = new Item(product, 1, price);
            items.put(product, item);
        }
    }

    public int price() {
        int itemTotal = 0;
        for (Item item : items.values()) {
            itemTotal += item.price();
        }
        return itemTotal;
    }

    public void print() {
        for (Item item : items.values()) {
            System.out.println(item);
        }
    }

}
