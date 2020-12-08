/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author EduardoPC
 */
public class StandardSensor implements Sensor {
    
    private int read;
    
    public StandardSensor(int read){
        this.read = read;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        
    }

    @Override
    public void setOff() {
       
    }

    @Override
    public int read() {
        
        return this.read;
    }
    
}
