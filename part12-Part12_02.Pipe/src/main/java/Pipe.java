/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EduardoPC
 */
import java.util.ArrayList;

public class Pipe<T> {
    
    private ArrayList<T> items;
    
    public Pipe(){
        this.items = new ArrayList<>();
    }
    
    public void putIntoPipe(T value){
        this.items.add(value);
    }
    
    public T takeFromPipe(){
        
        if (this.items.size() == 0){
            return null;
        } else if (this.items.size() == 1){
            T item = this.items.get(0);
            this.items.clear();
            return item;
        } else {
            T item = this.items.get(0);
            this.items.remove(item);
            return item;
        }
        
    }
    
    public boolean isInPipe(){
        if (items.size() == 0){
            return false;
        } else {
            return true;
        }
    }
    
}
