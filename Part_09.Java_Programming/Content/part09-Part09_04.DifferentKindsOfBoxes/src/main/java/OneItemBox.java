import java.util.ArrayList;

public class OneItemBox extends Box {
    
    private ArrayList<Item> items;
    
    public OneItemBox(){
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.items.size() > 0){
            
        } else {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if (items.contains(item)){
            return true;
        } else {
            return false;
        }
    }
    
}
