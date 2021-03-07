
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.storage = new HashMap<>();
    }

    public void add(String unit, String item) {

        this.storage.putIfAbsent(unit, new ArrayList<>());

        ArrayList<String> items = this.storage.get(unit);

        items.add(item);

    }

    public ArrayList<String> contents(String storageUnit) {
        for (String contents : storage.keySet()) {
            if (contents.equals(storageUnit)) {
                return storage.get(storageUnit);
            }
        }

        ArrayList<String> emptyList = new ArrayList<>();
        return emptyList;

    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> items = this.storage.get(storageUnit);
        items.remove(item);
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> allStorage = new ArrayList<>();
        
        for (String storageUnit : storage.keySet()) {
            ArrayList<String> items = this.storage.get(storageUnit);
            if (items.size() > 0){
                allStorage.add(storageUnit);
            }
        }

        return allStorage;

    }

}
