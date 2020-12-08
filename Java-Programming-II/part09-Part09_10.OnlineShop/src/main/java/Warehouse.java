
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Warehouse {
    
    private Map<String, Integer> products;
    private Map<String, Integer> stocks;
    
    public Warehouse(){
       this.products = new HashMap<>();
       this.stocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        products.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product){
        for (String product1 : products.keySet()){
            if (product1.equals(product)){
                return products.get(product1);
            } 
        }
        
        return -99; 
    }
    
    public int stock(String product){
        for (String productStock : stocks.keySet()){
            if (productStock.equals(product)){
                return stocks.get(product);
            }
        }
        return 0;
    }
    
    public boolean take(String product){
       for (String productStock : stocks.keySet()){
           if (productStock.equals(product)){
               int value = stocks.get(product);
               if (value > 0){
                   stocks.replace(productStock, value - 1);
                   return true;
               } 
           }
       }
       return false;
    }
    
    public Set<String> products(){
        
        Set<String> productSet = new HashSet<>();
        
        for (String products : stocks.keySet()){
            productSet.add(products);
        }
        return productSet;
    }
    
}
