import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("milk",2,1);
        warehouse.addProduct("croissants",4,8);        
        warehouse.addProduct("watermelon",3,5);
        warehouse.addProduct("Chips A Hoy",2,9);
        
       
        Scanner scanner = new Scanner(System.in);
        Store store = new Store(warehouse, scanner);
        
        String customer = "User";
        store.shop(customer);

    }
}
