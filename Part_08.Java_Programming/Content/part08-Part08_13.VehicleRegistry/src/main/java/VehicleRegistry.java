import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> database;

    public VehicleRegistry() {
        this.database = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {

        if (!database.containsKey(licensePlate)) {
            database.put(licensePlate, owner);
            return true;
        } else {
            return false;
        }

    }

    public String get(LicensePlate licensePlate) {
        if (database.containsKey(licensePlate)) {
            return database.get(licensePlate);
        } else {
            return null;
        }
    }

    public boolean remove(LicensePlate licensePlate) {
        if (database.containsKey(licensePlate)) {
            database.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printLicensePlates(){
        for (LicensePlate licensePlates : database.keySet()){
            System.out.println(licensePlates);
        }
    }
    
    public void printOwners(){
        ArrayList<String> printed = new ArrayList<>();
        
        for (String owners : database.values()){
            if (!printed.contains(owners)){
               printed.add(owners);
            }
        }
        
        for (String owners : printed){
            System.out.println(owners );
        }
        
    }
    
}
