
public class Sugar implements Packable {

    private double weight;
    
    public Sugar(double weight){
        this.weight = weight;
    }
    
    @Override
    public double weight() {
        return this.weight;
    }
    
}
