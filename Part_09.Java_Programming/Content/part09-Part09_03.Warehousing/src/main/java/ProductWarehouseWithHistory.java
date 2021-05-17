
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        history.add(initialBalance);
    }

    public String history() {
        return history.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(super.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        history.add(super.getBalance());
        return amountTaken; 
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName() + "\n"
                + "History: " + this.history() + "\n"
                        + "Largest amount of product: " + history.maxValue() + "\n"
                                + "Smallest amount of product: " + history.minValue() + "\n"
                                        + "Average: " + history.average());
    }

}
