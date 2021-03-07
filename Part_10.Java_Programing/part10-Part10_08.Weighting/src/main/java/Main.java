

public class Main {

    public static void main(String[] args) {
        Suitcase items = new Suitcase(40);
        
        items.addItem(new Item("Carrot", 3));
        items.addItem(new Item("Stick", 4));
        items.addItem(new Item("Cake", 4));
        
        items.printItems();
        
        
    }

}
