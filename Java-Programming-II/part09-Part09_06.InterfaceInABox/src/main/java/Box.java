
import java.util.ArrayList;

public class Box implements Packable {

    private double capacity;
    private ArrayList<Packable> packables;

    public Box(double capacity) {
        this.capacity = capacity;
        this.packables = new ArrayList<>();
    }

    public void add(Packable packable) {
        if (this.weight() + packable.weight() <= this.capacity){
            this.packables.add(packable);
        }
    }

    @Override
    public double weight() {
        
        double stored = 0;
        
        for (Packable pack : packables) {
            double weight = pack.weight();
            stored += weight;
        }
        return stored;
    }

    public String toString() {
        return "Box: " + packables.size() + " items, total weight " + this.weight()  + " kg";
    }

}
