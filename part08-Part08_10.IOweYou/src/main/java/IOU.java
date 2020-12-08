import java.util.HashMap;

public class IOU {
    
    private HashMap<String, Double> ious;
    
    public IOU(){
        this.ious = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        ious.put(toWhom, amount);
        
    }
    
    public double howMuchDoIOweTo(String toWhom){
        double amountOwed = ious.getOrDefault(toWhom, 0.0);
        
        return amountOwed;
    }
    
    
    
    
}
