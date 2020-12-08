import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {

    private List<Movable> herd;
    
    public Herd(){
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable){
        herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : herd){
            movable.move(dx, dy);
        }
    }

    public String toString() {
        
        String members = "";
        
        for (Movable movable : herd){
            members += movable + "\n";
        }
        
        return members;
    }

}
