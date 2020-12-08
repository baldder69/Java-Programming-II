
import java.util.ArrayList;

public class List<T> {

    private ArrayList ports;
    private T[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (firstFreeIndex == values.length) {
            grow();
        }

        values[firstFreeIndex] = value;

        firstFreeIndex++;
    }

    public void remove(T value) {
        
        int indexOfValue = indexOfValue(value);
        
        if (indexOfValue < 0){
            return;
        }
        
        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
        
    }

    public boolean contains(T value) {

        return indexOfValue(value) >= 0;

    }

    public T value(int index) {

        if (index < 0 || index > values.length) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "outside of [0" + firstFreeIndex + "]");
        }

        return this.values[index];

    }

    public int size() {
        return this.firstFreeIndex;
    }

    public void grow() {
        int newSize = values.length + values.length / 2;

        T[] newValues = (T[]) new Object[newSize];

        for (int i = 0; i < firstFreeIndex; i++) {
            newValues[i] = values[i];
        }

        this.values = newValues;

    }

    public int indexOfValue(T value) {

        for (int i = 0; i < firstFreeIndex; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }

        return -1;

    }
    
    public void moveToTheLeft(int fromIndex){
        
        
        for (int i = fromIndex; i < firstFreeIndex - 1; i++){
            System.out.println(values[i]);
            values[i] = values[i + 1];
        }
        
    }
    
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < firstFreeIndex; i++){
            sb.append(values[i].toString());
            
            
            if (i < firstFreeIndex - 1){
                sb.append(",");
            }
            
        }
        
        sb.append("]");
        
        return sb.toString();
    }

}
