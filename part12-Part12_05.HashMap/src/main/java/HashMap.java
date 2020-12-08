
import java.util.ArrayList;

public class HashMap<K, V> {

    private ArrayList<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        
        //It will be the hashvalue that defines the list within the array
        //It uses modulo factor so that the index stays within the length of values.
        int hashValue = Math.abs(key.hashCode() % values.length);

        //If there is no ArrayList with the given hashvalue, then return null
        if (this.values[hashValue] == null) {
            return null;
        }
        
        //Otherwise, search within the ArrayList and search if there are any pairs with the given key
        ArrayList<Pair<K, V>> valuesAtIndex = this.values[hashValue];

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }
        
        //If the key is not found, return null.

        return null;

    }

    public void add(K key, V value) {
        
        
        //Uses hashcode to see if there is a list within the array, if there isn't, then a new
        //ArrayList will be made within the array
        ArrayList<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        
        //This will return -1 or 1
        //1 meaning that the key is in the ArrayList
        //-1 meaning that there is not a key within the ArrayList
        int index = getIndexOfKey(valuesAtIndex, key);
        
        //-1 will result in creating a new key-value pair within the ArrayList
        //A positive number means that the key already exists and thus will give the pair a new value.
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }

        //If the length of the array uses more than 75% capacity, then it will grow.
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75){
            grow();
        }

    }
    
    public V remove(K key){
        
        //Uses hashcode to see if there is a list within the array, if there isn't, then a new
        //ArrayList will be made within the array
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        
        //This essentially means that there is no keys within the ArrayList, so it returns null
        if (valuesAtIndex.size() == 0){
            return null;
        }
        
        //If the size is greater than 0, then we will try to see if the ArrayList has
        //a key with a certain value
        int index = getIndexOfKey(valuesAtIndex, key);
        
        
        //The getIndexOfKey method will return 0 if the key is not in the ArrayList
        if (index < 0){
            return null;
        }
        
        //Otherwise, if the key is found, then we will save the Pair from the ArrayList in a variable
        //and then remove the pair from the ArrayList. We will allow the user have the ability to see
        //the value that it had upon being deleted.
        
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(index);
        return pair.getValue();
        
    }

    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        
        //Uses hashcode to see if there is a list with the corresponding hashvalue within the array
        int hashValue = Math.abs(key.hashCode() % values.length);

        //If there isn't, then a new ArrayList will be made within the array
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }

        //The ArrayList that corresponds to the hashvalue will be returned
        return values[hashValue];

    }
    
    //Uses an ArrayList and needs a key to figure out the index of the pair within the ArrayList
    private int getIndexOfKey(ArrayList<Pair<K, V>> myList, K key) {
        
        //For loop that goes through the ArrayList within the array
        for (int i = 0; i < myList.size(); i++) {
            //We then use the methods within the array to find whether any of the pairs
            //within the ArrayList have the corresponding key, if yes, it returns >= 0
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        
        //Otherwise, a negative value is returned, signifying that the key is not within the list.
        return -1;
    }

    private void grow() {
        
        //This is a new array with 2x the size
        ArrayList<Pair<K, V>>[] newArray = new ArrayList[this.values.length * 2];
        
        //All the contents of the old array will be copied onto the new array.
        for (int i = 0; i < values.length; i++) {
            copy(newArray, i);
        }
        
        //The current array will be updated with the new Array;
        this.values = newArray;

    }

    //This will need a newArray and index to function
    //The index is used to signify the ArrayList that will be used
    //The newArray is the array that will end up having the oldValues
    private void copy(ArrayList<Pair<K, V>>[] newArray, int fromIndex) {
        
        //a for loop that will go through the ArrayList and use the size of the ArrayList to determine
        //how many pairs their are within it
        for (int i = 0; i < values[fromIndex].size(); i++) {
            
            //This will be all the pairs that get obtained from the given ArrayList (AKA fromIndex == the ArrayList)
            Pair<K, V> value = this.values[fromIndex].get(i);
            
            //We will update the hashvalue of the array by using using the key (from the pair) and new array length
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            
            //This hashvalue will be put into the array to make a new ArrayList
            //if the index does not already have an ArrayList
            if (newArray[hashValue] == null){
                newArray[hashValue] = new ArrayList<>();
            }
            
            //As a result, the newArray will now have updated hashValues to store ArrayLists and this will add the pair gathered
            //from the old ArrayList of the oldArray onto their respective index within the newArray. The pair values may fall into
            //the same index or different index (aka different or same ArrayLists)
            newArray[hashValue].add(value);
            
        }
    }

}
