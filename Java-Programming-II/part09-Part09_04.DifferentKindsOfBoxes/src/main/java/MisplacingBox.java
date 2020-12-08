import java.util.ArrayList;

public class MisplacingBox extends Box {
    
    private ArrayList<Item> items;
    
    public MisplacingBox(){
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        this.items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        if (items.contains(item)){
            return false;
        } else {
            return false;
        }
    }
    
    
    
}
