
public class Container {

    private int container;

    public Container() {
        this.container = 0;
    }

    public int contains() {
        return container;
    }

    public void add(int amount) {
        if (amount >= 0) {
            this.container += amount;
            if (container > 100) {
                container = 100;
            }
        }

    }
    
    public void remove(int amount){
        if (amount > container){
            container = 0;
        }
        
        if (amount >= 0 && amount <= container){
            this.container -= amount;
        }
    }
    
    public String toString(){
        return container + "/100";
    }

}
