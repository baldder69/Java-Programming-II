/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author EduardoPC
 */
public class TemperatureSensor implements Sensor {

    private boolean some;

    public TemperatureSensor() {
        this.some = false;
    }

    @Override
    public boolean isOn() {
        if (this.some == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setOn() {
        this.some = true;
    }

    @Override
    public void setOff() {
        this.some = false;
    }

    @Override
    public int read() throws IllegalStateException {

        if (this.some == true) {
            Random random = new Random();
            return random.nextInt(30 + 30) - 30;
        } else {
            throw new IllegalStateException("Error");
        }
            
    }

}
